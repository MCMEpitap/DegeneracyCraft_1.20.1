package net.epitap.degeneracycraft.items;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.block.DCBlocks;
import net.epitap.degeneracycraft.datagen.DCBlockTagGenerator;
import net.epitap.degeneracycraft.datagen.DCItemTagGenerator;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = Degeneracycraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DCCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Degeneracycraft.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DEGENERACYCRAFT_MATERIAL_TAB = CREATIVE_MODE_TABS.register("degeneracycraft_materials",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DCItems.EMPTY_CONTAINER.get()))
                    .title(Component.translatable("creativetab.degeneracycraft_materials"))
                    .displayItems((displayParameters, output) -> {
                        ForgeRegistries.ITEMS.getValues().stream()
                                .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                        .getTag(DCItemTagGenerator.ELEMENT_ITEMS)
                                        .contains(item))
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.ITEMS.getValues().stream()
                                .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                        .getTag(DCItemTagGenerator.SUBSTANCE_ITEMS)
                                        .contains(item))
                                .map(ItemStack::new)
                                .forEach(output::accept);
                    }).build());

    public static final RegistryObject<CreativeModeTab> DEGENERACYCRAFT_MACHINE_ELEMENT_TAB = CREATIVE_MODE_TABS.register("degeneracycraft_machine_elements",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DCItems.IRON_GEAR.get()))
                    .title(Component.translatable("creativetab.degeneracycraft_machine_elements"))
                    .displayItems((displayParameters, output) -> {
                        ForgeRegistries.ITEMS.getValues().stream()
                                .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                        .getTag(DCItemTagGenerator.COPPER_MACHINE_ELEMENTS)
                                        .contains(item))
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.ITEMS.getValues().stream()
                                .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                        .getTag(DCItemTagGenerator.GOLD_MACHINE_ELEMENTS)
                                        .contains(item))
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.ITEMS.getValues().stream()
                                .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                        .getTag(DCItemTagGenerator.IRON_MACHINE_ELEMENTS)
                                        .contains(item))
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.ITEMS.getValues().stream()
                                .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                        .getTag(DCItemTagGenerator.TIN_MACHINE_ELEMENTS)
                                        .contains(item))
                                .map(ItemStack::new)
                                .forEach(output::accept);
                    }).build());

    public static final RegistryObject<CreativeModeTab> DEGENERACYCRAFT_MACHINE_PART_TAB = CREATIVE_MODE_TABS.register("degeneracycraft_machine_parts",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DCItems.BASIC_MOTOR.get()))
                    .title(Component.translatable("creativetab.degeneracycraft_machine_parts"))
                    .displayItems((displayParameters, output) -> {
                        ForgeRegistries.ITEMS.getValues().stream()
                                .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                        .getTag(DCItemTagGenerator.BASIC_ASTRONOMY_MACHINE_PARTS)
                                        .contains(item))
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.ITEMS.getValues().stream()
                                .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                        .getTag(DCItemTagGenerator.BASIC_BIOLOGY_MACHINE_PARTS)
                                        .contains(item))
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.ITEMS.getValues().stream()
                                .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                        .getTag(DCItemTagGenerator.BASIC_CHEMISTRY_MACHINE_PARTS)
                                        .contains(item))
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.ITEMS.getValues().stream()
                                .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                        .getTag(DCItemTagGenerator.BASIC_DYNAMIC_ENERGETICS_MACHINE_PARTS)
                                        .contains(item))
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.ITEMS.getValues().stream()
                                .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                        .getTag(DCItemTagGenerator.BASIC_ENGINEERING_MACHINE_PARTS)
                                        .contains(item))
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.ITEMS.getValues().stream()
                                .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                        .getTag(DCItemTagGenerator.BASIC_FORMAL_SCIENCE_MACHINE_PARTS)
                                        .contains(item))
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.ITEMS.getValues().stream()
                                .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                        .getTag(DCItemTagGenerator.BASIC_MACHINE_CIRCUIT_PARTS)
                                        .contains(item))
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.ITEMS.getValues().stream()
                                .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                        .getTag(DCItemTagGenerator.BASIC_GEO_SCIENCE_MACHINE_PARTS)
                                        .contains(item))
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.ITEMS.getValues().stream()
                                .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                        .getTag(DCItemTagGenerator.BASIC_IMITATION_MAGIC_ENGINEERING_MACHINE_PARTS)
                                        .contains(item))
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.ITEMS.getValues().stream()
                                .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                        .getTag(DCItemTagGenerator.BASIC_JENITH_VOID_SCIENCE_MACHINE_PARTS)
                                        .contains(item))
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.ITEMS.getValues().stream()
                                .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                        .getTag(DCItemTagGenerator.BASIC_KALEIDOSCOPIC_REALITY_SCIENCE_MACHINE_PARTS)
                                        .contains(item))
                                .map(ItemStack::new)
                                .forEach(output::accept);
                    }).build());

    public static final RegistryObject<CreativeModeTab> DEGENERACYCRAFT_MULTIPLIED_ORE_MATERIAL_TAB =
            CREATIVE_MODE_TABS.register("degeneracycraft_multiplied_ore_material",
                    () -> CreativeModeTab.builder()
                            .icon(() -> new ItemStack(DCItems.GRAPHITE_DUST.get()))
                            .title(Component.translatable("creativetab.degeneracycraft_multiplied_ore_materials"))
                            .displayItems((parameters, output) -> {
                                ForgeRegistries.ITEMS.getValues().stream()
                                        .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                                .getTag(DCItemTagGenerator.BAUXITE_MULTIPLIED_ORE_MATERIAL)
                                                .contains(item))
                                        .map(ItemStack::new)
                                        .forEach(output::accept);
                                ForgeRegistries.ITEMS.getValues().stream()
                                        .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                                .getTag(DCItemTagGenerator.BERYL_MULTIPLIED_ORE_MATERIAL)
                                                .contains(item))
                                        .map(ItemStack::new)
                                        .forEach(output::accept);
                                ForgeRegistries.ITEMS.getValues().stream()
                                        .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                                .getTag(DCItemTagGenerator.BORAX_MULTIPLIED_ORE_MATERIAL)
                                                .contains(item))
                                        .map(ItemStack::new)
                                        .forEach(output::accept);
                                ForgeRegistries.ITEMS.getValues().stream()
                                        .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                                .getTag(DCItemTagGenerator.CASSITERITE_MULTIPLIED_ORE_MATERIAL)
                                                .contains(item))
                                        .map(ItemStack::new)
                                        .forEach(output::accept);
                                ForgeRegistries.ITEMS.getValues().stream()
                                        .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                                .getTag(DCItemTagGenerator.CHROMITE_MULTIPLIED_ORE_MATERIAL)
                                                .contains(item))
                                        .map(ItemStack::new)
                                        .forEach(output::accept);
                                ForgeRegistries.ITEMS.getValues().stream()
                                        .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                                .getTag(DCItemTagGenerator.FLUORITE_MULTIPLIED_ORE_MATERIAL)
                                                .contains(item))
                                        .map(ItemStack::new)
                                        .forEach(output::accept);
                                ForgeRegistries.ITEMS.getValues().stream()
                                        .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                                .getTag(DCItemTagGenerator.GRAPHITE_MULTIPLIED_ORE_MATERIAL)
                                                .contains(item))
                                        .map(ItemStack::new)
                                        .forEach(output::accept);
                                ForgeRegistries.ITEMS.getValues().stream()
                                        .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                                .getTag(DCItemTagGenerator.LATERITE_MULTIPLIED_ORE_MATERIAL)
                                                .contains(item))
                                        .map(ItemStack::new)
                                        .forEach(output::accept);
                                ForgeRegistries.ITEMS.getValues().stream()
                                        .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                                .getTag(DCItemTagGenerator.LIMESTONE_MULTIPLIED_ORE_MATERIAL)
                                                .contains(item))
                                        .map(ItemStack::new)
                                        .forEach(output::accept);
                                ForgeRegistries.ITEMS.getValues().stream()
                                        .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                                .getTag(DCItemTagGenerator.NITRATINE_MULTIPLIED_ORE_MATERIAL)
                                                .contains(item))
                                        .map(ItemStack::new)
                                        .forEach(output::accept);
                                ForgeRegistries.ITEMS.getValues().stream()
                                        .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                                .getTag(DCItemTagGenerator.PEGMATITE_MULTIPLIED_ORE_MATERIAL)
                                                .contains(item))
                                        .map(ItemStack::new)
                                        .forEach(output::accept);
                                ForgeRegistries.ITEMS.getValues().stream()
                                        .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                                .getTag(DCItemTagGenerator.PENTLANDITE_MULTIPLIED_ORE_MATERIAL)
                                                .contains(item))
                                        .map(ItemStack::new)
                                        .forEach(output::accept);
                                ForgeRegistries.ITEMS.getValues().stream()
                                        .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                                .getTag(DCItemTagGenerator.PHOSPHORITE_MULTIPLIED_ORE_MATERIAL)
                                                .contains(item))
                                        .map(ItemStack::new)
                                        .forEach(output::accept);
                                ForgeRegistries.ITEMS.getValues().stream()
                                        .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                                .getTag(DCItemTagGenerator.PYRITE_MULTIPLIED_ORE_MATERIAL)
                                                .contains(item))
                                        .map(ItemStack::new)
                                        .forEach(output::accept);
                                ForgeRegistries.ITEMS.getValues().stream()
                                        .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                                .getTag(DCItemTagGenerator.PYROLUSITE_MULTIPLIED_ORE_MATERIAL)
                                                .contains(item))
                                        .map(ItemStack::new)
                                        .forEach(output::accept);
                                ForgeRegistries.ITEMS.getValues().stream()
                                        .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                                .getTag(DCItemTagGenerator.QUARTZ_MULTIPLIED_ORE_MATERIAL)
                                                .contains(item))
                                        .map(ItemStack::new)
                                        .forEach(output::accept);
                                ForgeRegistries.ITEMS.getValues().stream()
                                        .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                                .getTag(DCItemTagGenerator.SPODUMENE_MULTIPLIED_ORE_MATERIAL)
                                                .contains(item))
                                        .map(ItemStack::new)
                                        .forEach(output::accept);
                                ForgeRegistries.ITEMS.getValues().stream()
                                        .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                                .getTag(DCItemTagGenerator.SYLVITE_MULTIPLIED_ORE_MATERIAL)
                                                .contains(item))
                                        .map(ItemStack::new)
                                        .forEach(output::accept);
                                ForgeRegistries.ITEMS.getValues().stream()
                                        .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                                .getTag(DCItemTagGenerator.ULEXITE_MULTIPLIED_ORE_MATERIAL)
                                                .contains(item))
                                        .map(ItemStack::new)
                                        .forEach(output::accept);
                                ForgeRegistries.ITEMS.getValues().stream()
                                        .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                                .getTag(DCItemTagGenerator.VANADINITE_MULTIPLIED_ORE_MATERIAL)
                                                .contains(item))
                                        .map(ItemStack::new)
                                        .forEach(output::accept);
                            }).build());

    public static final RegistryObject<CreativeModeTab> DEGENERACYCRAFT_MACHINE_TAB = CREATIVE_MODE_TABS.register("degeneracycraft_machines",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DCBlocks.BASIC_TECHNOLOGY_MULTIBLOCK_EQUIPMENT_FABRICATOR_BLOCK.get()))
                    .title(Component.translatable("creativetab.degeneracycraft_machines"))
                    .displayItems((displayParameters, output) -> {
                        output.accept(DCItems.WRENCH.get());
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.INITIAL_MACHINES)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_ASTRONOMY_MACHINES)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_BIOLOGY_MACHINES)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_CHEMISTRY_MACHINES)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_DYNAMIC_ENERGETICS_MACHINES)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_ENGINEERING_MACHINES)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_FORMAL_SCIENCE_MACHINES)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_GEO_SCIENCE_MACHINES)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_HYBRID_PHYSICS_MACHINES)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_IMITATION_MAGIC_ENGINEERING_MACHINES)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_JENITH_VOID_SCIENCE_MACHINES)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_KALEIDOSCOPIC_REALITY_SCIENCE_MACHINES)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_ASTRONOMY_ABILITY_BLOCKS)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_BIOLOGY_ABILITY_BLOCKS)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_CHEMISTRY_ABILITY_BLOCKS)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_DYNAMIC_ENERGETICS_ABILITY_BLOCKS)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_ENGINEERING_ABILITY_BLOCKS)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_FORMAL_SCIENCE_ABILITY_BLOCKS)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_GEO_SCIENCE_ABILITY_BLOCKS)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_HYBRID_PHYSICS_ABILITY_BLOCKS)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_IMITATION_MAGIC_ENGINEERING_ABILITY_BLOCKS)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_JENITH_VOID_SCIENCE_ABILITY_BLOCKS)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_KALEIDOSCOPIC_REALITY_SCIENCE_ABILITY_BLOCKS)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.DEGENERACYCRAFT_PIPES)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                    }).build());

    public static final RegistryObject<CreativeModeTab> DEGENERACYCRAFT_MULTIBLOCK_TAB = CREATIVE_MODE_TABS.register("degeneracycraft_multiblock",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DCBlocks.BASIC_STRENGTH_ENGINEERING_MULTIBLOCK_STRUCTURE_FRAME_BLOCK.get()))
                    .title(Component.translatable("creativetab.degeneracycraft_multiblock"))
                    .displayItems((displayParameters, output) -> {
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_ASTRONOMY_MULTIBLOCKS)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_BIOLOGY_MULTIBLOCKS)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_CHEMISTRY_MULTIBLOCKS)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_DYNAMIC_ENERGETICS_MULTIBLOCKS)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_ENGINEERING_MULTIBLOCKS)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_FORMAL_SCIENCE_MULTIBLOCKS)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_GEO_SCIENCE_MULTIBLOCKS)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_HYBRID_PHYSICS_MULTIBLOCKS)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_IMITATION_MAGIC_ENGINEERING_MULTIBLOCKS)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_JENITH_VOID_SCIENCE_MULTIBLOCKS)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.BASIC_KALEIDOSCOPIC_REALITY_SCIENCE_MULTIBLOCKS)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                    }).build());

    public static final RegistryObject<CreativeModeTab> DEGENERACYCRAFT_ORE_TAB = CREATIVE_MODE_TABS.register("degeneracycraft_ores",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DCBlocks.OVERWORLD_CASSITERITE_ORE.get()))
                    .title(Component.translatable("creativetab.degeneracycraft_multiblock"))
                    .displayItems((displayParameters, output) -> {
//                        ForgeRegistries.BLOCKS.getValues().stream()
//                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
//                                        .getTag(DCBlockTagGenerator.DEGENERACYCRAFT_MULTIBLOCKS)
//                                        .contains(block))
//                                .map(Block::asItem)
//                                .filter(item -> item != Items.AIR)
//                                .map(ItemStack::new)
//                                .forEach(output::accept);
                    }).build());



    public static final RegistryObject<CreativeModeTab> DEGENERACYCRAFT_TESTS = CREATIVE_MODE_TABS.register("degeneracycraft_tests",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DCBlocks.TEST_MACHINE_BLOCK.get()))
                    .title(Component.translatable("degeneracycraft_tests"))
                    .displayItems((displayParameters, output) -> {
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.tags())
                                        .getTag(DCBlockTagGenerator.TEST_BLOCKS)
                                        .contains(block))
                                .map(Block::asItem)
                                .filter(item -> item != Items.AIR)
                                .map(ItemStack::new)
                                .forEach(output::accept);
                        ForgeRegistries.ITEMS.getValues().stream()
                                .filter(item -> Objects.requireNonNull(ForgeRegistries.ITEMS.tags())
                                        .getTag(DCItemTagGenerator.TEST_ITEMS)
                                        .contains(item))
                                .map(ItemStack::new)
                                .forEach(output::accept);
                    }).build());

//
//    public static final CreativeModeTab DEGENERACYCRAFT_MACHINE_TAB = new CreativeModeTab("degeneracycraft_machine") {
//        @Override
//        public ItemStack makeIcon() {
//            return new ItemStack(DCBlocks.BASIC_POWER_STEAM_GENERATOR_BLOCK.get());
//        }
//    };
//
//    public static final CreativeModeTab DEGENERACYCRAFT_ORE_TAB = new CreativeModeTab("degeneracycraft_ore") {
//        @Override
//        public ItemStack makeIcon() {
//            return new ItemStack(DCBlocks.OVERWORLD_GRAVITATION_ORE.get());
//        }
//    };

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}