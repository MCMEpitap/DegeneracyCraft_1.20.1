package net.epitap.degeneracycraft.block.base.machine;

import net.epitap.degeneracycraft.block.base.DCBlockBase;
import net.epitap.degeneracycraft.item.tool.CreativeMultiblockBuilderItem;
import net.epitap.degeneracycraft.item.tool.MultiblockBuilderItem;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

public abstract class DCMachineBlockBase extends DCBlockBase {

    protected DCMachineBlockBase(Properties properties) {
        super(properties);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);

            if (blockEntity instanceof DCMachineBlockEntityBase machine) {
                machine.drops();
            }
        }

        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);

        if (stack.getItem() instanceof CreativeMultiblockBuilderItem ||
                stack.getItem() instanceof MultiblockBuilderItem) {
            return InteractionResult.PASS;
        }

        if (!level.isClientSide()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);

            if (blockEntity instanceof DCMachineBlockEntityBase machine) {
                if (player instanceof ServerPlayer serverPlayer) {
                    NetworkHooks.openScreen(
                            serverPlayer,
                            machine,
                            pos
                    );

                    return InteractionResult.CONSUME;
                }
            }
        }

        return InteractionResult.sidedSuccess(
                level.isClientSide()
        );
    }

    @Nullable
    protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> serverType, BlockEntityType<E> clientType, BlockEntityTicker<? super E> ticker) {
        return clientType == serverType ? (BlockEntityTicker<A>) ticker : null;
    }
}