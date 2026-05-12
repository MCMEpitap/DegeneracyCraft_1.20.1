package net.epitap.degeneracycraft.items;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DCIcons {
    public static final DeferredRegister<Item> ICON_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Degeneracycraft.MOD_ID);

    public static final RegistryObject<Item> ASTRONOMY_ICON = ICON_ITEMS.register("astronomy_icon",()-> new Item(new Item.Properties().stacksTo(0)));
    public static final RegistryObject<Item> BIOLOGY_ICON = ICON_ITEMS.register("biology_icon",()-> new Item(new Item.Properties().stacksTo(0)));
    public static final RegistryObject<Item> CHEMISTRY_ICON = ICON_ITEMS.register("chemistry_icon",()-> new Item(new Item.Properties().stacksTo(0)));
    public static final RegistryObject<Item> DYNAMIC_ENERGETICS_ICON = ICON_ITEMS.register("dynamic_energetics_icon",()-> new Item(new Item.Properties().stacksTo(0)));
    public static final RegistryObject<Item> ENGINEERING_ICON = ICON_ITEMS.register("engineering_icon", () -> new Item(new Item.Properties().stacksTo(0)));
    public static final RegistryObject<Item> FORMAL_SCIENCE_ICON = ICON_ITEMS.register("formal_science_icon", () -> new Item(new Item.Properties().stacksTo(0)));
    public static final RegistryObject<Item> GEO_SCIENCE_ICON = ICON_ITEMS.register("geo_science_icon", () -> new Item(new Item.Properties().stacksTo(0)));
    public static final RegistryObject<Item> HYBRID_PHYSICS_ICON = ICON_ITEMS.register("hybrid_physics_icon", () -> new Item(new Item.Properties().stacksTo(0)));
    public static final RegistryObject<Item> IMITATION_MAGIC_ENGINEERING_ICON = ICON_ITEMS.register("imitation_magic_engineering_icon", () -> new Item(new Item.Properties().stacksTo(0)));
    public static final RegistryObject<Item> JEHITH_VOID_SCIENCE_ICON = ICON_ITEMS.register("jenith_void_science_icon", () -> new Item(new Item.Properties().stacksTo(0)));
    public static final RegistryObject<Item> KALEIDOSCOPIC_REALITY_SCIENCE_ICON = ICON_ITEMS.register("kaleidoscopic_reality_science_icon", () -> new Item(new Item.Properties().stacksTo(0)));

    public static final RegistryObject<Item> INITIAL_ICON = ICON_ITEMS.register("initial_icon",()-> new Item(new Item.Properties().stacksTo(0)));
    public static final RegistryObject<Item> BASIC_ICON = ICON_ITEMS.register("basic_icon",()-> new Item(new Item.Properties().stacksTo(0)));
    public static final RegistryObject<Item> LOW_ICON = ICON_ITEMS.register("low_icon",()-> new Item(new Item.Properties().stacksTo(0)));
    public static final RegistryObject<Item> MEDIUM_ICON = ICON_ITEMS.register("medium_icon",()-> new Item(new Item.Properties().stacksTo(0)));
    public static final RegistryObject<Item> HIGH_ICON = ICON_ITEMS.register("high_icon", () -> new Item(new Item.Properties().stacksTo(0)));
    public static final RegistryObject<Item> SUPER_ICON = ICON_ITEMS.register("super_icon", () -> new Item(new Item.Properties().stacksTo(0)));
    public static final RegistryObject<Item> OVER_ICON = ICON_ITEMS.register("over_icon", () -> new Item(new Item.Properties().stacksTo(0)));
    public static final RegistryObject<Item> ULTRA_ICON = ICON_ITEMS.register("ultra_icon", () -> new Item(new Item.Properties().stacksTo(0)));
    public static final RegistryObject<Item> ANTI_ICON = ICON_ITEMS.register("anti_icon", () -> new Item(new Item.Properties().stacksTo(0)));
    public static final RegistryObject<Item> IMAGINARY_ICON = ICON_ITEMS.register("imaginary_icon", () -> new Item(new Item.Properties().stacksTo(0)));
    public static final RegistryObject<Item> INFINITY_ICON = ICON_ITEMS.register("infinity_icon", () -> new Item(new Item.Properties().stacksTo(0)));

    public static void register(IEventBus eventBus) {
        ICON_ITEMS.register(eventBus);
    }

}
