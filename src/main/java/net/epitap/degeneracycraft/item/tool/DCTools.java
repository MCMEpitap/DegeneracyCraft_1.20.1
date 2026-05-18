package net.epitap.degeneracycraft.item.tool;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.item.tool.initial.PrototypeMechanicalPickaxeItem;
import net.epitap.degeneracycraft.tier.DCTiers;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DCTools {
    public static final DeferredRegister<Item> TOOL_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Degeneracycraft.MOD_ID);

    public static final RegistryObject<Item> PROTOTYPE_MECHANICAL_PICKAXE =
            TOOL_ITEMS.register("prototype_mechanical_pickaxe",() -> new PrototypeMechanicalPickaxeItem(DCTiers.INITIAL_MINING_TOOL, 1,-2.8F, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        TOOL_ITEMS.register(eventBus);
    }

}
