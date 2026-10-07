package net.epitap.degeneracycraft.block.base.multiblock;

import net.epitap.degeneracycraft.energy.DCEnergyStorageFloatBase;
import net.epitap.degeneracycraft.energy.DCIEnergyStorageFloat;
import net.epitap.degeneracycraft.networking.DCMessages;
import net.epitap.degeneracycraft.networking.packet.DCEnergySyncS2CPacket;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class DCMultiblockEnergyBlockEntityBase extends BlockEntity implements MenuProvider {
    protected final float STORAGE_CAPACITY;
    protected final float STORAGE_TRANSFER;
    protected final DCEnergyStorageFloatBase ENERGY_STORAGE;

    public final ItemStackHandler itemHandler;
    protected LazyOptional<DCIEnergyStorageFloat> lazyEnergyHandler = LazyOptional.empty();
    protected LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public final ContainerData data;

    protected DCMultiblockEnergyBlockEntityBase(BlockEntityType<?> type, BlockPos pos,
                                                BlockState state, float capacity, float transfer, int inventorySize) {
        super(type, pos, state);

        this.STORAGE_CAPACITY = capacity;
        this.STORAGE_TRANSFER = transfer;

        this.ENERGY_STORAGE = new DCEnergyStorageFloatBase(capacity, transfer) {
            @Override
            public void onEnergyChanged() {
                setChanged();

                if (level != null) {
                    level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
                    DCMessages.sendToClients(new DCEnergySyncS2CPacket(this.energy, getBlockPos()));
                }
            }
        };

        this.itemHandler = new ItemStackHandler(inventorySize) {
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();

                if (level != null && !level.isClientSide()) {
                    level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
                }
            }
        };

        this.data = new ContainerData() {
            @Override public int get(int index) { return 0; }
            @Override public void set(int index, int value) {}
            @Override public int getCount() { return 0; }
        };
    }

    public DCIEnergyStorageFloat getEnergyStorage() {
        return ENERGY_STORAGE;
    }

    public ItemStackHandler getItemHandler() {
        return itemHandler;
    }

    public void setEnergyLevel(float energy) {
        ENERGY_STORAGE.setEnergyFloat(energy);
    }

    public void setHandler(ItemStackHandler handler) {
        int size = Math.min(itemHandler.getSlots(), handler.getSlots());

        for (int i = 0; i < size; i++) {
            itemHandler.setStackInSlot(i, handler.getStackInSlot(i));
        }
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(
            @NotNull Capability<T> cap,
            @Nullable Direction side) {

        if (cap == ForgeCapabilities.ENERGY) {
            return lazyEnergyHandler.cast();
        }

        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();

        lazyEnergyHandler = LazyOptional.of(() -> ENERGY_STORAGE);
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        lazyEnergyHandler.invalidate();
        lazyItemHandler.invalidate();
        super.invalidateCaps();
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        nbt.putFloat("energy", ENERGY_STORAGE.getEnergyStoredFloat());
        nbt.put("inventory", itemHandler.serializeNBT());
        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);

        ENERGY_STORAGE.setEnergyFloat(nbt.getFloat("energy"));
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());

        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(level, worldPosition, inventory);
    }

    public float getEnergyCapacity() {
        return STORAGE_CAPACITY;
    }

    public float getEnergyTransfer() {
        return STORAGE_TRANSFER;
    }
}