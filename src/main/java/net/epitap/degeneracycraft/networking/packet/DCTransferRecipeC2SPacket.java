package net.epitap.degeneracycraft.networking.packet;

import net.epitap.degeneracycraft.block.base.machine.DCMachineBlockEntityBase;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class DCTransferRecipeC2SPacket {

    private final ResourceLocation recipeId;
    private final BlockPos pos;
    private final boolean shift;

    public DCTransferRecipeC2SPacket(BlockPos pos, ResourceLocation recipeId, boolean shift) {
        this.pos = pos;
        this.recipeId = recipeId;
        this.shift = shift;
    }

    public DCTransferRecipeC2SPacket(FriendlyByteBuf buf) {
        this.recipeId = buf.readResourceLocation();
        this.pos = buf.readBlockPos();
        this.shift = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeResourceLocation(recipeId);
        buf.writeBlockPos(pos);
        buf.writeBoolean(shift);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {

            ServerPlayer player = ctx.get().getSender();
            if (player == null) return;

            player.level().getRecipeManager().byKey(recipeId).ifPresent(recipe -> {
                        if (player.level().getBlockEntity(pos)
                                instanceof DCMachineBlockEntityBase blockEntity) {
                            blockEntity.insertRecipeInputsFromPlayer(player, recipe, shift);
                        }
            });
        });

        ctx.get().setPacketHandled(true);
    }
}