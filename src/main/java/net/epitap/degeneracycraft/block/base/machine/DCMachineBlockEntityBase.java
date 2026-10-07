package net.epitap.degeneracycraft.block.base.machine;

import net.epitap.degeneracycraft.energy.DCEnergyStorageFloat;
import net.epitap.degeneracycraft.energy.DCEnergyStorageFloatBase;
import net.epitap.degeneracycraft.energy.DCIEnergyStorageFloat;
import net.epitap.degeneracycraft.multiblock.*;
import net.epitap.degeneracycraft.networking.DCMessages;
import net.epitap.degeneracycraft.networking.packet.DCEnergySyncS2CPacket;
import net.epitap.degeneracycraft.util.DCOutputOnlyHandler;
import net.epitap.degeneracycraft.util.DCWrappedHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public abstract class DCMachineBlockEntityBase extends BlockEntity implements MenuProvider {
    protected final float MACHINE_CAPACITY;
    protected final float MACHINE_TRANSFER;

    protected int counter;
    protected int progressPercent;
    protected int multiblockLevel = -1;
    public int hologramLevel = -1;
    public boolean forceHalt = false;
    protected boolean inputLocked = false;
    protected boolean working = false;

    protected final ContainerData data;
    protected final ItemStackHandler itemHandler;
    protected final DCEnergyStorageFloatBase energyStorage;

    protected LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    protected LazyOptional<DCIEnergyStorageFloat> lazyEnergyHandler = LazyOptional.empty();

    protected final List<DCIEnergyStorageFloat> energyInputs = new ArrayList<>();
    protected final List<DCIEnergyStorageFloat> energyOutputs = new ArrayList<>();

    protected final List<IItemHandler> itemInputs = new ArrayList<>();
    protected final List<IItemHandler> itemOutputs = new ArrayList<>();

    protected Map<Direction, LazyOptional<IItemHandler>> createDirectionItemHandlerMap;
    protected boolean multiblockFormed = false;
    protected ItemStack[] inputLockedRecipe;

    protected DCMachineBlockEntityBase(BlockEntityType<?> type, BlockPos pos, BlockState state, float machineCapacity, float machineTransfer, int inventorySize) {
        super(type, pos, state);
        MACHINE_CAPACITY = machineCapacity;
        MACHINE_TRANSFER = machineTransfer;
        itemHandler = createItemHandler(inventorySize);
        energyStorage = createEnergyStorage();
        createDirectionItemHandlerMap = createDirectionItemHandlerMap();
        inputLockedRecipe = new ItemStack[getInputSlotCount()];
        Arrays.fill(inputLockedRecipe, ItemStack.EMPTY);
        data = new ContainerData() {
            @Override public int get(int index) { return getContainerData(index); }
            @Override public void set(int index, int value) { setContainerData(index, value); }
            @Override public int getCount() { return getContainerDataCount(); }
        };
    }

    protected int getContainerData(int index) { return 0; }
    protected void setContainerData(int index, int value) {}
    protected int getContainerDataCount() { return 0; }

    protected ItemStackHandler createItemHandler(int inventorySize) {
        return new ItemStackHandler(inventorySize) {
            @Override protected void onContentsChanged(int slot) {
                setChanged();
                if (level != null && !level.isClientSide()) level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        };
    }

    protected DCEnergyStorageFloatBase createEnergyStorage() {
        return new DCEnergyStorageFloatBase(MACHINE_CAPACITY, MACHINE_TRANSFER) {
            @Override public void onEnergyChanged() {
                setChanged();
                if (level != null && !level.isClientSide()) {
                    level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
                    DCMessages.sendToClients(new DCEnergySyncS2CPacket(this.energy, getBlockPos()));
                }
            }
        };
    }

    public ItemStackHandler getItemHandler() { return itemHandler; }
    public DCEnergyStorageFloat getEnergyStorage() { return energyStorage; }
    public void setEnergyLevel(float energy) { energyStorage.setEnergyFloat(energy); }

    protected abstract ResourceLocation getMultiblockId();

    public List<ResourceLocation> getMultiblockIds() {
        return List.of(getMultiblockId());
    }

    protected Direction getExternalOutputDirection() { return Direction.WEST; }

    public Direction getMachineFacing() {
        if (level == null) return Direction.NORTH;
        return getBlockState().getValue(BlockStateProperties.FACING);
    }

    protected Direction getRelativeDirection(Direction machineFacing, Direction relative) {
        return switch (relative) {
            case NORTH -> machineFacing;
            case SOUTH -> machineFacing.getOpposite();
            case EAST -> machineFacing.getClockWise();
            case WEST -> machineFacing.getCounterClockWise();
            default -> relative;
        };
    }

    protected boolean checkMultiblock() {
        if (level == null || level.isClientSide()) return false;

        boolean previousFormed = multiblockFormed;
        int previousLevel = multiblockLevel;
        int detectedLevel = -1;
        Direction facing = getMachineFacing();
        List<ResourceLocation> ids = getMultiblockIds();

        for (int i = ids.size() - 1; i >= 0; i--) {
            DCMultiblockFile file = DCMultiblockRegistry.get(ids.get(i));

            if (file != null && DCMultiblockMatcher.matches(level, worldPosition, file, facing)) {
                detectedLevel = i;
                break;
            }
        }

        boolean formed = detectedLevel >= 0;

        if (previousFormed != formed || previousLevel != detectedLevel) {
            multiblockFormed = formed;
            multiblockLevel = detectedLevel;
            onMultiblockStateChanged(previousFormed, previousLevel, formed, detectedLevel);
            scanMultiblockStorages(level);
            setChanged();
        }

        return formed;
    }

    protected void onMultiblockStateChanged(boolean previousFormed, int previousLevel, boolean formed, int level) {}

    public boolean isMultiblockFormed() { return multiblockFormed; }
    public int getMultiblockLevel() { return multiblockLevel; }

    protected DCMultiblockFile getMultiblockFile(Level level) {
        if (multiblockLevel < 0) return null;

        List<ResourceLocation> ids = getMultiblockIds();

        if (multiblockLevel >= ids.size()) return null;

        return DCMultiblockRegistry.get(ids.get(multiblockLevel));
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
        lazyEnergyHandler = LazyOptional.of(() -> energyStorage);
        createDirectionItemHandlerMap = createDirectionItemHandlerMap();
    }

    @Override
    public void invalidateCaps() {
        lazyItemHandler.invalidate();
        lazyEnergyHandler.invalidate();
        if (createDirectionItemHandlerMap != null)
            createDirectionItemHandlerMap.values().forEach(LazyOptional::invalidate);
        super.invalidateCaps();
    }

    protected Map<Direction, LazyOptional<IItemHandler>> createDirectionItemHandlerMap() {
        int outputSlot = getOutputSlot();
        Map<Direction, LazyOptional<IItemHandler>> map = new EnumMap<>(Direction.class);

        for (Direction direction : Direction.Plane.HORIZONTAL) {
            map.put(direction, LazyOptional.of(() -> new DCWrappedHandler(itemHandler, slot -> true, (slot, stack) -> itemHandler.isItemValid(slot, stack))));
        }

        if (outputSlot >= 0) {
            Direction actualOutput = getRelativeDirection(getMachineFacing(), getExternalOutputDirection());
            map.put(actualOutput, LazyOptional.of(() -> new DCOutputOnlyHandler(itemHandler, outputSlot)));
        }

        return map;
    }

    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ENERGY) return lazyEnergyHandler.cast();
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            if (side != null) {
                LazyOptional<IItemHandler> handler = createDirectionItemHandlerMap.get(side);
                if (handler != null) return handler.cast();
            }
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag nbt) {
        super.saveAdditional(nbt);
        nbt.put("inventory", itemHandler.serializeNBT());
        nbt.putFloat("energy", energyStorage.getEnergyStoredFloat());
        nbt.putBoolean("multiblockFormed", multiblockFormed);
        nbt.putInt("multiblockLevel", multiblockLevel);
        nbt.putInt("hologramLevel", hologramLevel);
        nbt.putBoolean("forceHalt", forceHalt);
        nbt.putBoolean("inputLocked", inputLocked);

        ListTag lockedItems = new ListTag();
        for (ItemStack stack : inputLockedRecipe) {
            CompoundTag itemTag = new CompoundTag();
            stack.save(itemTag);
            lockedItems.add(itemTag);
        }
        nbt.put("inputLockedRecipe", lockedItems);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        if (nbt.contains("inventory")) itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        energyStorage.setEnergyFloat(nbt.getFloat("energy"));
        multiblockFormed = nbt.getBoolean("multiblockFormed");
        multiblockLevel = nbt.contains("multiblockLevel") ? nbt.getInt("multiblockLevel") : (multiblockFormed ? 0 : -1);
        hologramLevel = nbt.contains("hologramLevel") ? nbt.getInt("hologramLevel") : -1;
        forceHalt = nbt.getBoolean("forceHalt");
        inputLocked = nbt.getBoolean("inputLocked");

        if (nbt.contains("inputLockedRecipe", Tag.TAG_LIST)) {
            ListTag lockedItems = nbt.getList("inputLockedRecipe", Tag.TAG_COMPOUND);
            for (int i = 0; i < inputLockedRecipe.length && i < lockedItems.size(); i++) {
                inputLockedRecipe[i] = ItemStack.of(lockedItems.getCompound(i));
            }
        }
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) inventory.setItem(i, itemHandler.getStackInSlot(i));
        Containers.dropContents(level, worldPosition, inventory);
    }

    public static void setChanged(Level level, BlockPos pos, BlockState state) {
        BlockEntity.setChanged(level, pos, state);
    }

    protected void pullEnergyFromInputs() {
        float needed = MACHINE_CAPACITY - energyStorage.getEnergyStoredFloat();
        if (needed <= 0) return;

        for (DCIEnergyStorageFloat input : energyInputs) {
            if (needed <= 0) break;
            float extracted = input.extractEnergyFloat(needed, false);
            if (extracted > 0) {
                energyStorage.receiveEnergyFloat(extracted, false);
                needed -= extracted;
            }
        }
    }

    protected void pushEnergyToOutputs() {
        float stored = energyStorage.getEnergyStoredFloat();
        float transferable = stored - (MACHINE_CAPACITY - MACHINE_TRANSFER);
        if (transferable <= 0) return;

        for (DCIEnergyStorageFloat output : energyOutputs) {
            if (transferable <= 0) break;
            float accepted = output.receiveEnergyFloat(transferable, false);
            if (accepted > 0) {
                energyStorage.extractEnergyFloat(accepted, false);
                transferable -= accepted;
            }
        }
    }

    protected void pullItemsFromInputs() {
        for (IItemHandler input : itemInputs) {
            for (int inputSlot = 0; inputSlot < input.getSlots(); inputSlot++) {
                ItemStack stack = input.getStackInSlot(inputSlot);
                if (stack.isEmpty()) continue;

                for (int machineSlot = 0; machineSlot < itemHandler.getSlots(); machineSlot++) {
                    if (!canReceiveItem(machineSlot, stack)) continue;

                    ItemStack simulated = itemHandler.insertItem(machineSlot, stack.copy(), true);
                    int insertable = stack.getCount() - simulated.getCount();
                    if (insertable <= 0) continue;

                    ItemStack extracted = input.extractItem(inputSlot, insertable, false);
                    itemHandler.insertItem(machineSlot, extracted, false);
                    return;
                }
            }
        }
    }

    protected boolean canReceiveItem(int machineSlot, ItemStack stack) {
        return itemHandler.isItemValid(machineSlot, stack);
    }

    protected void pushItemsToOutputs() {
        for (int machineSlot = 0; machineSlot < itemHandler.getSlots(); machineSlot++) {
            ItemStack stack = itemHandler.getStackInSlot(machineSlot);
            if (stack.isEmpty() || !isOutputSlot(machineSlot)) continue;

            for (IItemHandler output : itemOutputs) {
                for (int outputSlot = 0; outputSlot < output.getSlots(); outputSlot++) {
                    ItemStack leftover = output.insertItem(outputSlot, stack.copy(), false);
                    if (leftover.isEmpty()) {
                        itemHandler.setStackInSlot(machineSlot, ItemStack.EMPTY);
                        return;
                    }
                    if (leftover.getCount() < stack.getCount()) {
                        itemHandler.setStackInSlot(machineSlot, leftover);
                        return;
                    }
                }
            }
        }
    }

    protected boolean isOutputSlot(int machineSlot) { return false; }
    protected int getInputSlot() { return 0; }
    protected int getOutputSlot() { return 0; }
    protected abstract int getInputSlotCount();

    protected void scanMultiblockStorages(Level level) {
        energyInputs.clear();
        energyOutputs.clear();
        itemInputs.clear();
        itemOutputs.clear();

        if (level.isClientSide() || !multiblockFormed || multiblockLevel < 0) return;

        DCMultiblockFile file = getMultiblockFile(level);
        if (file == null) return;

        BlockPos controllerOffset = file.getControllerOffset();
        if (controllerOffset == null) return;

        BlockPos controllerPos = getBlockPos();
        Direction facing = getMachineFacing();

        for (int x = 0; x < file.getX(); x++) {
            for (int y = 0; y < file.getY(); y++) {
                for (int z = 0; z < file.getZ(); z++) {
                    DCMultiblockFile.DCPlaceholder placeholder = file.getPlaceholder(x, y, z);
                    if (placeholder == null || placeholder.isController()) continue;

                    BlockPos relative = new BlockPos(
                            x - controllerOffset.getX(),
                            y - controllerOffset.getY(),
                            z - controllerOffset.getZ()
                    );

                    BlockPos rotated = DCMultiblockUtil.rotateRelativePos(relative, facing);
                    BlockPos worldPos = controllerPos.offset(rotated);

                    BlockEntity blockEntity = level.getBlockEntity(worldPos);
                    if (blockEntity == null || blockEntity == this) continue;

                    DCMultiblockBlockType expectedType = DCMultiblockBlockType.getType(placeholder);
                    if (expectedType == null) continue;

                    DCMultiblockBlockType actualType = DCMultiblockBlockType.getType(level.getBlockState(worldPos).getBlock());
                    if (actualType != expectedType) continue;

                    switch (expectedType) {
                        case ENERGY_INPUT -> blockEntity.getCapability(ForgeCapabilities.ENERGY).ifPresent(storage -> {
                            if (storage instanceof DCEnergyStorageFloat energy) energyInputs.add(energy);
                        });
                        case ENERGY_OUTPUT -> blockEntity.getCapability(ForgeCapabilities.ENERGY).ifPresent(storage -> {
                            if (storage instanceof DCEnergyStorageFloat energy) energyOutputs.add(energy);
                        });
                        case ITEM_INPUT -> blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(itemInputs::add);
                        case ITEM_OUTPUT -> blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(itemOutputs::add);
                    }
                }
            }
        }
    }

    public void toggleHologram() {
        hologramLevel++;
        if (hologramLevel > 1) hologramLevel = -1;
        setChanged();
    }

    public void toggleForceHalt() {
        forceHalt = !forceHalt;
        setChanged();
    }

    public void toggleInputLock() {
        inputLocked = !inputLocked;

        if (inputLocked) {
            for (int i = 0; i < inputLockedRecipe.length; i++) {
                inputLockedRecipe[i] = itemHandler.getStackInSlot(i).copy();
            }
        } else {
            Arrays.fill(inputLockedRecipe, ItemStack.EMPTY);
        }

        setChanged();
    }

    public boolean isInputLocked() { return inputLocked; }
    public int getHologramLevel() { return hologramLevel; }

    @Override
    public Component getDisplayName() {
        return Component.empty();
    }

    @Override
    public AABB getRenderBoundingBox() {
        BlockPos pos = getBlockPos();
        return new AABB(
                pos.getX() - 64.0,
                pos.getY() - 64.0,
                pos.getZ() - 64.0,
                pos.getX() + 65.0,
                pos.getY() + 65.0,
                pos.getZ() + 65.0);
    }

    public boolean buildMultiblock(ServerPlayer player, int multiblockLevelToBuild) {
        if (player == null) return false;

        if (multiblockLevelToBuild < 0) return false;

        List<ResourceLocation> ids = getMultiblockIds();

        if (multiblockLevelToBuild >= ids.size()) {
            return false;
        }

        ResourceLocation multiblockId =
                ids.get(multiblockLevelToBuild);

        DCMultiblockFile file =
                DCMultiblockRegistry.get(multiblockId);

        if (file == null) {
            return false;
        }

        BlockPos controllerOffset =
                file.getControllerOffset();

        if (controllerOffset == null) {
            return false;
        }

        if (level == null || level.isClientSide()) {
            return false;
        }

        Direction facing = getMachineFacing();
        BlockPos controllerPos = getBlockPos();

        this.multiblockLevel = multiblockLevelToBuild;
        this.multiblockFormed = false;
        setChanged();

        for (int x = 0; x < file.getX(); x++) {
            for (int y = 0; y < file.getY(); y++) {
                for (int z = 0; z < file.getZ(); z++) {

                    DCMultiblockFile.DCPlaceholder placeholder =
                            file.getPlaceholder(x, y, z);

                    if (placeholder == null) continue;

                    // コントローラーは既に存在するので変更しない
                    if (placeholder.isController()) continue;

                    DCMultiblockFile.DCPredicate predicate =
                            getBuildPredicate(placeholder);

                    if (predicate == null) continue;

                    ResourceLocation blockId =
                            predicate.getBlockId();

                    if (blockId == null) continue;

                    Block block =
                            BuiltInRegistries.BLOCK.get(blockId);

                    if (block == Blocks.AIR) continue;

                    BlockPos relativePos =
                            file.toRelativePos(x, y, z);

                    BlockPos rotatedPos =
                            DCMultiblockUtil.rotateRelativePos(
                                    relativePos,
                                    facing
                            );

                    BlockPos worldPos =
                            controllerPos.offset(rotatedPos);

                    level.setBlock(
                            worldPos,
                            block.defaultBlockState(),
                            3
                    );
                }
            }
        }

        // 建築後に再チェック
        checkMultiblock();

        return true;
    }

    @Nullable
    private DCMultiblockFile.DCPredicate getBuildPredicate(
            DCMultiblockFile.DCPlaceholder placeholder) {

        if (placeholder.getPredicates() == null) {
            return null;
        }

        for (DCMultiblockFile.DCPredicate predicate : placeholder.getPredicates()) {
            if (predicate != null && predicate.isBlock()) {
                return predicate;
            }
        }

        return null;
    }

    public boolean clearMultiblock(int multiblockLevel) {
        if (level == null || level.isClientSide()) return false;

        List<ResourceLocation> ids = getMultiblockIds();

        if (multiblockLevel < 0 || multiblockLevel >= ids.size()) {
            return false;
        }

        DCMultiblockFile file = DCMultiblockRegistry.get(ids.get(multiblockLevel));

        if (file == null) {
            return false;
        }

        BlockPos controllerPos = getBlockPos();
        Direction facing = getMachineFacing();

        for (int x = 0; x < file.getX(); x++) {
            for (int y = 0; y < file.getY(); y++) {
                for (int z = 0; z < file.getZ(); z++) {
                    DCMultiblockFile.DCPlaceholder placeholder =
                            file.getPlaceholder(x, y, z);

                    if (placeholder == null || placeholder.isController()) {
                        continue;
                    }

                    DCMultiblockFile.DCPredicate predicate = null;

                    if (placeholder.getPredicates() != null) {
                        for (DCMultiblockFile.DCPredicate p : placeholder.getPredicates()) {
                            if (p != null && p.isBlock()) {
                                predicate = p;
                                break;
                            }
                        }
                    }

                    if (predicate == null || predicate.getBlockId() == null) {
                        continue;
                    }

                    ResourceLocation expectedBlockId = predicate.getBlockId();

                    BlockPos relativePos = file.toRelativePos(x, y, z);
                    BlockPos rotatedPos =
                            DCMultiblockUtil.rotateRelativePos(relativePos, facing);

                    BlockPos worldPos = controllerPos.offset(rotatedPos);

                    BlockState currentState = level.getBlockState(worldPos);
                    ResourceLocation currentBlockId =
                            BuiltInRegistries.BLOCK.getKey(currentState.getBlock());

                    if (!expectedBlockId.equals(currentBlockId)) {
                        continue;
                    }

                    level.setBlock(
                            worldPos,
                            Blocks.AIR.defaultBlockState(),
                            3
                    );
                }
            }
        }

        multiblockFormed = false;
        multiblockLevel = -1;
        setChanged();

        return true;
    }

    public boolean buildMultiblockSurvival(ServerPlayer player, int multiblockLevelToBuild) {
        if (player == null) return false;
        if (multiblockLevelToBuild < 0) return false;

        List<ResourceLocation> ids = getMultiblockIds();

        if (multiblockLevelToBuild >= ids.size()) {
            return false;
        }

        ResourceLocation multiblockId =
                ids.get(multiblockLevelToBuild);

        DCMultiblockFile file =
                DCMultiblockRegistry.get(multiblockId);

        if (file == null) {
            return false;
        }

        BlockPos controllerOffset =
                file.getControllerOffset();

        if (controllerOffset == null) {
            return false;
        }

        if (level == null || level.isClientSide()) {
            return false;
        }

        Direction facing = getMachineFacing();
        BlockPos controllerPos = getBlockPos();

        this.multiblockLevel = multiblockLevelToBuild;
        this.multiblockFormed = false;
        setChanged();

        for (int x = 0; x < file.getX(); x++) {
            for (int y = 0; y < file.getY(); y++) {
                for (int z = 0; z < file.getZ(); z++) {

                    DCMultiblockFile.DCPlaceholder placeholder = file.getPlaceholder(x, y, z);

                    if (placeholder == null) continue;
                    if (placeholder.isController()) continue;

                    DCMultiblockFile.DCPredicate predicate = getBuildPredicate(placeholder);

                    if (predicate == null) continue;

                    ResourceLocation blockId = predicate.getBlockId();

                    if (blockId == null) continue;

                    Block block = BuiltInRegistries.BLOCK.get(blockId);

                    if (block == Blocks.AIR) continue;

                    BlockPos relativePos =
                            file.toRelativePos(x, y, z);

                    BlockPos rotatedPos = DCMultiblockUtil.rotateRelativePos(relativePos, facing);

                    BlockPos worldPos =
                            controllerPos.offset(rotatedPos);

                    if (!level.getBlockState(worldPos).isAir()) {
                        continue;
                    }

                    ItemStack requiredStack =
                            new ItemStack(block);

                    int inventorySlot = -1;

                    for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
                        ItemStack inventoryStack =
                                player.getInventory().getItem(i);

                        if (ItemStack.isSameItem(inventoryStack, requiredStack)) {
                            inventorySlot = i;
                            break;
                        }
                    }

                    if (inventorySlot == -1) {
                        continue;
                    }

                    level.setBlock(worldPos, block.defaultBlockState(), 3);

                    player.getInventory().removeItem(inventorySlot, 1);
                }
            }
        }

        checkMultiblock();

        return true;
    }

    public boolean clearMultiblockSurvival(
            ServerPlayer player,
            int multiblockLevel) {

        if (player == null) return false;
        if (level == null || level.isClientSide()) return false;

        List<ResourceLocation> ids = getMultiblockIds();

        if (multiblockLevel < 0 || multiblockLevel >= ids.size()) {
            return false;
        }

        DCMultiblockFile file = DCMultiblockRegistry.get(ids.get(multiblockLevel));

        if (file == null) {
            return false;
        }

        BlockPos controllerPos = getBlockPos();
        Direction facing = getMachineFacing();

        for (int x = 0; x < file.getX(); x++) {
            for (int y = 0; y < file.getY(); y++) {
                for (int z = 0; z < file.getZ(); z++) {

                    DCMultiblockFile.DCPlaceholder placeholder =
                            file.getPlaceholder(x, y, z);

                    if (placeholder == null ||
                            placeholder.isController()) {
                        continue;
                    }

                    DCMultiblockFile.DCPredicate predicate = null;

                    if (placeholder.getPredicates() != null) {
                        for (DCMultiblockFile.DCPredicate p : placeholder.getPredicates()) {

                            if (p != null && p.isBlock()) {
                                predicate = p;
                                break;
                            }
                        }
                    }

                    if (predicate == null ||
                            predicate.getBlockId() == null) {
                        continue;
                    }

                    ResourceLocation expectedBlockId = predicate.getBlockId();

                    BlockPos relativePos = file.toRelativePos(x, y, z);

                    BlockPos rotatedPos = DCMultiblockUtil.rotateRelativePos(relativePos, facing);

                    BlockPos worldPos = controllerPos.offset(rotatedPos);

                    BlockState currentState = level.getBlockState(worldPos);

                    ResourceLocation currentBlockId = BuiltInRegistries.BLOCK.getKey(currentState.getBlock());

                    if (!expectedBlockId.equals(currentBlockId)) {
                        continue;
                    }

                    ItemStack returnedStack = new ItemStack(currentState.getBlock());

                    level.setBlock(worldPos, Blocks.AIR.defaultBlockState(), 3);

                    if (!player.getInventory().add(returnedStack)) {
                        player.drop(returnedStack, false);
                    }
                }
            }
        }

        multiblockFormed = false;
        multiblockLevel = -1;
        setChanged();

        return true;
    }

    public int getMultiblockLevelCount() {
        return getMultiblockIds().size();
    }

    public void insertRecipeInputsFromPlayer(Player player, Recipe<?> recipe, boolean shift) {
        List<ItemStack> inputs = getRecipeInputs(recipe);

        if (inputs == null || inputs.isEmpty()) return;

        player.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(playerInv -> {
            this.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(machineInv -> {

                Map<Item, Integer> totalCounts = new HashMap<>();

                if (shift) {
                    for (ItemStack input : inputs) {
                        if (input.isEmpty() || input.getItem() == Items.AIR) {
                            continue;
                        }

                        int count = countItemInInventory(playerInv, input.getItem());

                        totalCounts.put(input.getItem(), count);
                    }
                }

                for (int slot = 0; slot < inputs.size(); slot++) {
                    ItemStack required = inputs.get(slot);

                    if (required.isEmpty() || required.getItem() == Items.AIR) {
                        continue;
                    }

                    if (shift) {
                        long sameCount = inputs.stream()
                                .filter(s -> !s.isEmpty()
                                        && s.getItem() != Items.AIR
                                        && s.getItem() == required.getItem())
                                .count();

                        int total = totalCounts.getOrDefault(required.getItem(), 0);

                        int perSlot = sameCount > 0 ? total / (int) sameCount : total;

                        perSlot = Math.max(1, perSlot);

                        insertItemFromPlayer(playerInv, machineInv, new ItemStack(required.getItem(), perSlot), slot);

                    } else {
                        insertItemFromPlayer(playerInv, machineInv, required.copy(), slot);
                    }
                }
            });
        });
    }

    protected abstract List<ItemStack> getRecipeInputs(Recipe<?> recipe);

    protected static int countItemInInventory(IItemHandler inventory, Item target) {
        int count = 0;

        for (int i = 0; i < inventory.getSlots(); i++) {
            ItemStack stack = inventory.getStackInSlot(i);

            if (!stack.isEmpty() && stack.getItem() == target) {
                count += stack.getCount();
            }
        }

        return count;
    }

    protected void insertItemFromPlayer(IItemHandler playerInv, IItemHandler machineInv, ItemStack required, int slotIndex) {
        if (required.isEmpty()) return;

        int needed = required.getCount();

        for (int i = 0; i < playerInv.getSlots() && needed > 0; i++) {

            ItemStack fromSlot = playerInv.getStackInSlot(i);

            if (!ItemStack.isSameItemSameTags(fromSlot, required)) {
                continue;
            }

            int toExtract = Math.min(needed, fromSlot.getCount());

            ItemStack extracted = playerInv.extractItem(i, toExtract, false);

            ItemStack leftover = machineInv.insertItem(slotIndex, extracted, false);

            if (!leftover.isEmpty()) {
                int inserted = toExtract - leftover.getCount();

                needed -= inserted;

                playerInv.insertItem(i, leftover, false);
            } else {
                needed -= toExtract;
            }
        }
    }

    protected int getParallelLimit() {
        return 1;
    }

    protected int getInputParallelCount(List<ItemStack> inputs) {
        int parallelCount = Integer.MAX_VALUE;

        for (int i = 0; i < inputs.size(); i++) {
            ItemStack required = inputs.get(i);

            if (required.isEmpty() || required.getItem() == Items.AIR) {
                continue;
            }

            ItemStack actual = itemHandler.getStackInSlot(i);

            if (!ItemStack.isSameItemSameTags(required, actual)) {
                return 0;
            }

            if (required.getCount() <= 0) {
                continue;
            }

            int possible = actual.getCount() / required.getCount();
            parallelCount = Math.min(parallelCount, possible);
        }

        return parallelCount == Integer.MAX_VALUE ? 1 : parallelCount;
    }

    protected int getOutputParallelCount(List<ItemStack> inputs, List<ItemStack> outputs) {
        if (outputs.isEmpty()) {
            return Integer.MAX_VALUE;
        }

        int outputStart = inputs.size();
        int parallelCount = Integer.MAX_VALUE;

        for (int i = 0; i < outputs.size(); i++) {
            ItemStack output = outputs.get(i);

            if (output.isEmpty() || output.getItem() == Items.AIR) {
                continue;
            }

            if (output.getCount() <= 0) {
                continue;
            }

            int slot = outputStart + i;
            ItemStack existing = itemHandler.getStackInSlot(slot);
            int slotLimit = itemHandler.getSlotLimit(slot);

            if (existing.isEmpty()) {
                parallelCount = Math.min(
                        parallelCount,
                        slotLimit / output.getCount()
                );
                continue;
            }

            if (!ItemStack.isSameItemSameTags(existing, output)) {
                return 0;
            }

            int remaining = slotLimit - existing.getCount();

            parallelCount = Math.min(parallelCount, remaining / output.getCount());
        }

        return parallelCount;
    }

    protected int getParallelCount(List<ItemStack> inputs, List<ItemStack> outputs) {
        int limit = getParallelLimit();

        int inputParallel = getInputParallelCount(inputs);
        int outputParallel = getOutputParallelCount(inputs, outputs);

        return Math.min(limit, Math.min(inputParallel, outputParallel));
    }
}