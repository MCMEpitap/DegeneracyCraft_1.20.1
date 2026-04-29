package net.epitap.degeneracycraft.integration.jei.test;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.epitap.degeneracycraft.Degeneracycraft;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.crafting.CraftingHelper;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TestMachineRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    final float energy;
    final float time;
    final int phase;
    final List<ItemStack> inputs;
    final List<ItemStack> outputs;

    public TestMachineRecipe(ResourceLocation id, float energy, float time, int phase,
                             List<ItemStack> inputs, List<ItemStack> outputs) {
        this.id = id;
        this.energy = energy;
        this.time = time;
        this.phase = phase;
        this.inputs = inputs;
        this.outputs = outputs;
    }

    @Override
    public boolean matches(SimpleContainer container, Level level) {
        if (level.isClientSide) return false;

        if (container.getContainerSize() < inputs.size()) return false;

        for (int i = 0; i < inputs.size(); i++) {
            ItemStack required = inputs.get(i);
            ItemStack actual = container.getItem(i);

            if (!required.isEmpty()) {
                if (!ItemStack.isSameItemSameTags(required, actual)) return false;
                if (actual.getCount() < required.getCount()) return false;
            }
        }

        return true;
    }

    @Override
    public ItemStack assemble(SimpleContainer container, RegistryAccess registryAccess) {
        return outputs.isEmpty() ? ItemStack.EMPTY : outputs.get(0).copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    public float getRequiredEnergy() {
        return energy;
    }

    public float getRequiredTime() {
        return time;
    }

    public int getRequiredPhase() {
        return phase;
    }

    public List<ItemStack> getInputs() {
        return inputs;
    }

    public List<ItemStack> getOutputs() {
        return outputs;
    }

    public int getInputCount() {
        return inputs.size();
    }

    public int getOutputCount() {
        return outputs.size();
    }

    public ItemStack getInput(int index) {
        return index < inputs.size() ? inputs.get(index) : ItemStack.EMPTY;
    }

    public ItemStack getOutput(int index) {
        return index < outputs.size() ? outputs.get(index) : ItemStack.EMPTY;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return outputs.isEmpty() ? ItemStack.EMPTY : outputs.get(0);
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static ItemStack itemStackFromJson(JsonObject obj) {
        return CraftingHelper.getItemStack(obj, true, false);
    }

    // ===== Type =====
    public static class Type implements RecipeType<TestMachineRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "test_machine_recipe";
    }

    // ===== Serializer =====
    public static class Serializer implements RecipeSerializer<TestMachineRecipe> {
        public static final Serializer INSTANCE = new Serializer();

        public static final ResourceLocation ID =
                new ResourceLocation(Degeneracycraft.MOD_ID, "test_machine_recipe");

        @Override
        public TestMachineRecipe fromJson(ResourceLocation id, JsonObject json) {

            float energy = GsonHelper.getAsFloat(json, "energy", 1);
            float time = GsonHelper.getAsFloat(json, "time", 1);
            int phase = GsonHelper.getAsInt(json, "phase", 1);

            // inputs
            List<ItemStack> inputs = new ArrayList<>();
            JsonArray inputArray = GsonHelper.getAsJsonArray(json, "inputs");
            for (JsonElement e : inputArray) {
                inputs.add(itemStackFromJson(e.getAsJsonObject()));
            }

            // outputs
            List<ItemStack> outputs = new ArrayList<>();
            JsonArray outputArray = GsonHelper.getAsJsonArray(json, "outputs");
            for (JsonElement e : outputArray) {
                outputs.add(itemStackFromJson(e.getAsJsonObject()));
            }

            return new TestMachineRecipe(id, energy, time, phase, inputs, outputs);
        }

        @Override
        public @Nullable TestMachineRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            float energy = buf.readFloat();
            float time = buf.readFloat();
            int phase = buf.readInt();

            int inputSize = buf.readInt();
            List<ItemStack> inputs = new ArrayList<>();
            for (int i = 0; i < inputSize; i++) {
                inputs.add(buf.readItem());
            }

            int outputSize = buf.readInt();
            List<ItemStack> outputs = new ArrayList<>();
            for (int i = 0; i < outputSize; i++) {
                outputs.add(buf.readItem());
            }

            return new TestMachineRecipe(id, energy, time, phase, inputs, outputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, TestMachineRecipe recipe) {
            buf.writeFloat(recipe.energy);
            buf.writeFloat(recipe.time);
            buf.writeInt(recipe.phase);

            buf.writeInt(recipe.inputs.size());
            for (ItemStack stack : recipe.inputs) {
                buf.writeItem(stack);
            }

            buf.writeInt(recipe.outputs.size());
            for (ItemStack stack : recipe.outputs) {
                buf.writeItem(stack);
            }
        }
    }
}