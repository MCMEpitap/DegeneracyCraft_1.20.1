package net.epitap.degeneracycraft.block.storage.basic.hybrid_physics.item.item_storage;

import net.epitap.degeneracycraft.block.DCBlockEntities;
import net.epitap.degeneracycraft.block.base.multiblock.DCMultiblockItemBlockEntityBase;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class BasicStrengthHybridPhysicsMultiblockItemStorageBlockEntity extends DCMultiblockItemBlockEntityBase {
    public static final int STORAGE_COUNT = 18;

    public BasicStrengthHybridPhysicsMultiblockItemStorageBlockEntity(BlockPos pos, BlockState state) {
        super(DCBlockEntities.BASIC_STRENGTH_HYBRID_PHYSICS_MULTIBLOCK_ITEM_STORAGE_BLOCK_ENTITY.get(), pos, state, STORAGE_COUNT);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new BasicStrengthHybridPhysicsMultiblockItemStorageMenu(containerId, inventory, this, data);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, BasicStrengthHybridPhysicsMultiblockItemStorageBlockEntity blockEntity) {
    }
}