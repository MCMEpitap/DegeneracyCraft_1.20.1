package net.epitap.degeneracycraft.util;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandlerModifiable;

import javax.annotation.Nonnull;

public class DCOutputOnlyHandler implements IItemHandlerModifiable {

    private final IItemHandlerModifiable handler;
    private final int outputSlot;

    public DCOutputOnlyHandler(
            IItemHandlerModifiable handler,
            int outputSlot
    ) {
        this.handler = handler;
        this.outputSlot = outputSlot;
    }

    @Override
    public int getSlots() {
        return 1;
    }

    private int getInternalSlot(int slot) {
        return slot == 0 ? outputSlot : -1;
    }

    @Nonnull
    @Override
    public ItemStack getStackInSlot(int slot) {

        int internalSlot = getInternalSlot(slot);

        if (internalSlot < 0) {
            return ItemStack.EMPTY;
        }

        return handler.getStackInSlot(internalSlot);
    }

    @Nonnull
    @Override
    public ItemStack insertItem(
            int slot,
            @Nonnull ItemStack stack,
            boolean simulate
    ) {
        // OUTPUTなので外部からの投入は禁止
        return stack;
    }

    @Nonnull
    @Override
    public ItemStack extractItem(
            int slot,
            int amount,
            boolean simulate
    ) {
        int internalSlot = getInternalSlot(slot);

        if (internalSlot < 0) {
            return ItemStack.EMPTY;
        }

        return handler.extractItem(
                internalSlot,
                amount,
                simulate
        );
    }

    @Override
    public int getSlotLimit(int slot) {

        int internalSlot = getInternalSlot(slot);

        if (internalSlot < 0) {
            return 0;
        }

        return handler.getSlotLimit(internalSlot);
    }

    @Override
    public boolean isItemValid(
            int slot,
            @Nonnull ItemStack stack
    ) {
        return false;
    }

    @Override
    public void setStackInSlot(
            int slot,
            @Nonnull ItemStack stack
    ) {
        // 外部から直接書き込ませない
    }
}