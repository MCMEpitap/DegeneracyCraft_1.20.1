package net.epitap.degeneracycraft.networking.packet;

import net.epitap.degeneracycraft.block.base.machine.DCMachineBlockEntityBase;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class DCMachineToggleC2SPacketTest {

    private final BlockPos pos;
    private final int type;

    public static final int TOGGLE_HOLOGRAM = 0;
    public static final int TOGGLE_HALT = 1;
    public static final int TOGGLE_LOCK = 2;

    public DCMachineToggleC2SPacketTest(FriendlyByteBuf buf) {
        this.pos = buf.readBlockPos();
        this.type = buf.readInt();
    }

    public DCMachineToggleC2SPacketTest(BlockPos pos, int type) {
        this.pos = pos;
        this.type = type;
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBlockPos(pos);
        buf.writeInt(type);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {

        NetworkEvent.Context ctx = supplier.get();

        ctx.enqueueWork(() -> {

            ServerPlayer player = ctx.getSender();

            if (player == null) {
                return;
            }

            BlockEntity blockEntity =
                    player.level().getBlockEntity(pos);

            if (!(blockEntity instanceof DCMachineBlockEntityBase machine)) {
                return;
            }

            if (type == TOGGLE_HOLOGRAM) {
                machine.toggleHologram();
            }

            if (type == TOGGLE_HALT) {
                machine.toggleForceHalt();
            }

            if (type == TOGGLE_LOCK) {
                machine.toggleInputLock();
            }

            machine.setChanged();
        });


        ctx.setPacketHandled(true);
        return true;
    }
}