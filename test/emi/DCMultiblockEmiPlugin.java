package net.epitap.degeneracycraft.integration.emi;

import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.IRecipeSlotBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.integration.jei.JEIDCPlugin;
import net.epitap.degeneracycraft.multiblock.DCMultiblockFile;
import net.epitap.degeneracycraft.multiblock.DCMultiblockRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraftforge.registries.ForgeRegistries;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Proxy;
import java.util.Collections;

/** Registers DegeneracyCraft multiblocks and its JEI-backed machine recipes in EMI. */
@EmiEntrypoint
public class DCMultiblockEmiPlugin implements EmiPlugin {
    public static final ResourceLocation MULTIBLOCK_CATEGORY_ID =
            new ResourceLocation(Degeneracycraft.MOD_ID, "multiblock");
    public static final EmiRecipeCategory MULTIBLOCK_CATEGORY =
            new EmiRecipeCategory(MULTIBLOCK_CATEGORY_ID, EmiStack.EMPTY);

    private static final String JEI_RECIPE_PACKAGE =
            "net.epitap.degeneracycraft.integration.jei";

    @Override
    public void register(EmiRegistry registry) {
        registerMultiblocks(registry);
        registerJeiRecipes(registry);
    }

    private static void registerMultiblocks(EmiRegistry registry) {
        registry.addCategory(MULTIBLOCK_CATEGORY);

        for (Map.Entry<ResourceLocation, DCMultiblockFile> entry
                : DCMultiblockRegistry.getAll().entrySet()) {
            DCMultiblockFile file = entry.getValue();
            if (file == null) {
                continue;
            }

            DCMultiblockDisplayData data =
                    DCMultiblockDisplayDataFactory.create(entry.getKey(), file);
            registry.addRecipe(new DCMultiblockEmiRecipe(data));
        }
    }

    /**
     * JEI's categories are not EMI recipes. Convert every loaded DegeneracyCraft
     * Recipe in the JEI integration package into a native EMI recipe so the recipe
     * keeps its real RecipeManager ID and can be found by EMI's recipe tree/search.
     */
    private static void registerJeiRecipes(EmiRegistry registry) {
        Map<ResourceLocation, EmiRecipeCategory> categories = new HashMap<>();

        for (Recipe<?> recipe : registry.getRecipeManager().getRecipes()) {
            if (!recipe.getClass().getPackageName().startsWith(JEI_RECIPE_PACKAGE)) {
                continue;
            }

            List<ItemStack> inputs = readStacks(recipe, "getInputs");
            List<ItemStack> outputs = readStacks(recipe, "getOutputs");
            if (inputs == null || outputs == null) {
                Degeneracycraft.LOGGER.warn(
                        "Skipping EMI registration for {}: getInputs/getOutputs were unavailable",
                        recipe.getId()
                );
                continue;
            }

            ResourceLocation jeiCategoryId = findJeiCategoryId(recipe);
            ResourceLocation emiCategoryId = new ResourceLocation(
                    Degeneracycraft.MOD_ID,
                    "emi/" + jeiCategoryId.getPath()
            );

            EmiRecipeCategory category = categories.get(emiCategoryId);
            if (category == null) {
                EmiStack icon = outputs.isEmpty() ? EmiStack.EMPTY : EmiStack.of(outputs.get(0).copy());
                category = new EmiRecipeCategory(emiCategoryId, icon);
                categories.put(emiCategoryId, category);
                registry.addCategory(category);
            }

            registry.addRecipe(new GenericMachineEmiRecipe(recipe, category, inputs, outputs));
        }

        Degeneracycraft.LOGGER.info(
                "Registered {} DegeneracyCraft JEI recipe categories with EMI",
                categories.size()
        );
    }

    private static ResourceLocation findJeiCategoryId(Recipe<?> recipe) {
        String categoryClassName = recipe.getClass().getName() + "Category";
        try {
            Class<?> categoryClass = Class.forName(
                    categoryClassName, false, recipe.getClass().getClassLoader()
            );
            Field uidField = categoryClass.getField("UID");
            Object value = uidField.get(null);
            if (value instanceof ResourceLocation uid) {
                return uid;
            }
        } catch (ReflectiveOperationException ignored) {
            // Fall back to the registered serializer ID for recipe types without
            // a matching JEI category class.
        }

        ResourceLocation serializerId =
                ForgeRegistries.RECIPE_SERIALIZERS.getKey(recipe.getSerializer());
        if (serializerId != null) {
            return serializerId;
        }
        return recipe.getId();
    }

    private static List<ItemStack> readStacks(Recipe<?> recipe, String methodName) {
        try {
            Method method = recipe.getClass().getMethod(methodName);
            Object value = method.invoke(recipe);
            if (!(value instanceof Iterable<?> iterable)) {
                return null;
            }

            List<ItemStack> stacks = new ArrayList<>();
            for (Object element : iterable) {
                if (element instanceof ItemStack stack && !stack.isEmpty()) {
                    stacks.add(stack.copy());
                }
            }
            return stacks;
        } catch (ReflectiveOperationException exception) {
            return null;
        }
    }

    private static JeIInfo createJeiInfo(Recipe<?> recipe) {
        try {
            if (JEIDCPlugin.EMI_GUI_HELPER == null) return null;
            Class<?> type = Class.forName(recipe.getClass().getName() + "Category", true,
                    recipe.getClass().getClassLoader());
            Object category = type.getConstructor(mezz.jei.api.helpers.IGuiHelper.class)
                    .newInstance(JEIDCPlugin.EMI_GUI_HELPER);
            int width = (int) type.getMethod("getWidth").invoke(category);
            int height = (int) type.getMethod("getHeight").invoke(category);
            IDrawable background = (IDrawable) type.getMethod("getBackground").invoke(category);
            Object iconObject = type.getMethod("getIcon").invoke(category);
            EmiStack icon = null;
            if (iconObject != null) {
                for (Method method : iconObject.getClass().getMethods()) {
                    if (method.getName().equals("getIngredient") && method.getParameterCount() == 0) {
                        Object value = method.invoke(iconObject);
                        if (value instanceof ItemStack stack) icon = EmiStack.of(stack.copy());
                        break;
                    }
                }
            }

            List<SlotData> slots = new ArrayList<>();
            IRecipeLayoutBuilder builder = (IRecipeLayoutBuilder) Proxy.newProxyInstance(
                    IRecipeLayoutBuilder.class.getClassLoader(), new Class[]{IRecipeLayoutBuilder.class},
                    (proxy, method, args) -> {
                        RecipeIngredientRole role = null;
                        int x = 0, y = 0;
                        if (args != null && args.length == 3 && args[0] instanceof RecipeIngredientRole r) {
                            role = r; x = (int) args[1]; y = (int) args[2];
                        } else if (args != null && args.length == 2 && (method.getName().equals("addInputSlot")
                                || method.getName().equals("addOutputSlot"))) {
                            role = method.getName().equals("addInputSlot") ? RecipeIngredientRole.INPUT : RecipeIngredientRole.OUTPUT;
                            x = (int) args[0]; y = (int) args[1];
                        }
                        if (role != null) {
                            SlotData slot = new SlotData(role, x, y);
                            slots.add(slot);
                            return slotProxy(slot);
                        }
                        return defaultValue(method.getReturnType());
                    });
            Method setRecipe = null;
            for (Method method : type.getMethods()) {
                if (method.getName().equals("setRecipe") && method.getParameterCount() == 3
                        && method.getParameterTypes()[0] == IRecipeLayoutBuilder.class
                        && method.getParameterTypes()[1].isInstance(recipe)) {
                    setRecipe = method;
                    break;
                }
            }
            if (setRecipe != null) {
                Object focus = Proxy.newProxyInstance(IFocusGroup.class.getClassLoader(),
                        new Class[]{IFocusGroup.class}, (p, m, a) -> defaultValue(m.getReturnType()));
                try {
                    setRecipe.invoke(category, builder, recipe, focus);
                } catch (Throwable layoutError) {
                    // Preserve the category background even if a JEI category needs
                    // runtime menu state that is unavailable during EMI registration.
                    Degeneracycraft.LOGGER.debug("JEI slot layout unavailable for {}", recipe.getId(), layoutError);
                }
            }
            return new JeIInfo(category, background, width, height, icon, slots);
        } catch (Throwable error) {
            Degeneracycraft.LOGGER.warn("Could not read JEI category/layout for {}", recipe.getId(), error);
            return JeIInfo.EMPTY;
        }
    }

    private static Object slotProxy(SlotData slot) {
        return Proxy.newProxyInstance(IRecipeSlotBuilder.class.getClassLoader(),
                new Class[]{IRecipeSlotBuilder.class}, (proxy, method, args) -> {
                    if (args != null) for (Object arg : args) {
                        if (arg instanceof ItemStack stack && !stack.isEmpty()) slot.stacks.add(stack.copy());
                        else if (arg instanceof Iterable<?> iterable) for (Object value : iterable)
                            if (value instanceof ItemStack stack && !stack.isEmpty()) slot.stacks.add(stack.copy());
                    }
                    return method.getReturnType().isInstance(proxy) ? proxy : defaultValue(method.getReturnType());
                });
    }

    private static Object defaultValue(Class<?> type) {
        if (!type.isPrimitive()) return null;
        if (type == boolean.class) return false;
        if (type == char.class) return '\0';
        if (type == byte.class) return (byte) 0;
        if (type == short.class) return (short) 0;
        if (type == int.class) return 0;
        if (type == long.class) return 0L;
        if (type == float.class) return 0F;
        if (type == double.class) return 0D;
        return null;
    }

    private static final class SlotData {
        final RecipeIngredientRole role; final int x, y; final List<ItemStack> stacks = new ArrayList<>();
        SlotData(RecipeIngredientRole role, int x, int y) { this.role = role; this.x = x; this.y = y; }
    }
    private static final class JeIInfo {
        static final JeIInfo EMPTY = new JeIInfo(null, null, 176, 64, null, List.of());
        final Object category; final IDrawable background; final int width, height; final EmiStack icon; final List<SlotData> slots;
        JeIInfo(Object category, IDrawable background, int width, int height, EmiStack icon, List<SlotData> slots) {
            this.category=category; this.background=background; this.width=width; this.height=height; this.icon=icon; this.slots=slots;
        }
    }

    private static final class GenericMachineEmiRecipe implements EmiRecipe {
        private static final int WIDTH = 176;
        private static final int TOP = 22;
        private static final int COLUMNS = 3;

        private final Recipe<?> backingRecipe;
        private final EmiRecipeCategory category;
        private final List<ItemStack> inputs;
        private final List<ItemStack> outputs;
        private final List<EmiIngredient> emiInputs;
        private final List<EmiStack> emiOutputs;
        private final int height;
        private volatile JeIInfo jei;

        private GenericMachineEmiRecipe(
                Recipe<?> backingRecipe,
                EmiRecipeCategory category,
                List<ItemStack> inputs,
                List<ItemStack> outputs
        ) {
            this.backingRecipe = backingRecipe;
            this.category = category;
            this.inputs = List.copyOf(inputs);
            this.outputs = List.copyOf(outputs);

            this.emiInputs = new ArrayList<>();
            for (ItemStack stack : inputs) {
                this.emiInputs.add(EmiStack.of(stack.copy()));
            }
            this.emiOutputs = new ArrayList<>();
            for (ItemStack stack : outputs) {
                this.emiOutputs.add(EmiStack.of(stack.copy()));
            }

            int rows = Math.max(rowCount(inputs.size()), rowCount(outputs.size()));
            this.height = Math.max(64, TOP + rows * 18 + 8);
        }

        private JeIInfo getJeiInfo() {
            JeIInfo info = jei;
            if (info == null) {
                synchronized (this) {
                    info = jei;
                    if (info == null) {
                        info = createJeiInfo(backingRecipe);
                        if (info == null) return JeIInfo.EMPTY;
                        jei = info;
                    }
                }
            }
            return info;
        }

        @Override
        public EmiRecipeCategory getCategory() {
            return category;
        }

        @Override
        public ResourceLocation getId() {
            return backingRecipe.getId();
        }

        @Override
        public List<EmiIngredient> getInputs() {
            return emiInputs;
        }

        @Override
        public List<EmiStack> getOutputs() {
            return emiOutputs;
        }

        @Override
        public int getDisplayWidth() {
            JeIInfo info = getJeiInfo();
            return info.width > 0 ? info.width : WIDTH;
        }

        @Override
        public int getDisplayHeight() {
            JeIInfo info = getJeiInfo();
            return info.height > 0 ? info.height : height;
        }

        @Override
        public Recipe<?> getBackingRecipe() {
            return backingRecipe;
        }

        @Override
        public void addWidgets(WidgetHolder widgets) {
            JeIInfo jei = getJeiInfo();
            if (jei.background != null) {
                widgets.addDrawable(0, 0, jei.width, jei.height,
                        (graphics, mouseX, mouseY, delta) -> jei.background.draw(graphics, 0, 0));
            }
            if (jei.category != null) {
                widgets.addDrawable(0, 0, jei.width, jei.height, (graphics, mouseX, mouseY, delta) -> {
                    try {
                        Method draw = null;
                        for (Method method : jei.category.getClass().getMethods())
                            if (method.getName().equals("draw") && method.getParameterCount() == 5
                                    && method.getParameterTypes()[0].isInstance(backingRecipe)) { draw = method; break; }
                        if (draw != null) {
                            IRecipeSlotsView view = (IRecipeSlotsView) Proxy.newProxyInstance(
                                    IRecipeSlotsView.class.getClassLoader(), new Class[]{IRecipeSlotsView.class},
                                    (p, m, a) -> m.getName().equals("getSlotViews") ? Collections.emptyList() : defaultValue(m.getReturnType()));
                            draw.invoke(jei.category, backingRecipe, view, graphics, (double) mouseX, (double) mouseY);
                        }
                    } catch (Throwable ignored) { }
                });
            }
            boolean captured = !jei.slots.isEmpty();
            if (captured) {
                for (SlotData slot : jei.slots) for (ItemStack stack : slot.stacks) {
                    if (slot.role == RecipeIngredientRole.OUTPUT)
                        widgets.addSlot(EmiStack.of(stack.copy()), slot.x, slot.y).recipeContext(this);
                    else widgets.addSlot(EmiStack.of(stack.copy()), slot.x, slot.y).recipeContext(this);
                }
                return;
            }
            for (int i = 0; i < inputs.size(); i++) {
                int x = 6 + (i % COLUMNS) * 18;
                int y = TOP + (i / COLUMNS) * 18;
                widgets.addSlot(EmiStack.of(inputs.get(i).copy()), x, y)
                        .recipeContext(this);
            }

            widgets.addTexture(EmiTexture.EMPTY_ARROW, 78, TOP + 1);

            for (int i = 0; i < outputs.size(); i++) {
                int x = 110 + (i % COLUMNS) * 18;
                int y = TOP + (i / COLUMNS) * 18;
                widgets.addSlot(EmiStack.of(outputs.get(i).copy()), x, y)
                        .recipeContext(this);
            }
        }

        private static int rowCount(int count) {
            return Math.max(1, (count + COLUMNS - 1) / COLUMNS);
        }
    }
}

