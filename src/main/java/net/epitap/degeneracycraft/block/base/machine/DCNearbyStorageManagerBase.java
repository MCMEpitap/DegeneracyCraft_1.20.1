package net.epitap.degeneracycraft.block.base.machine;

import net.epitap.degeneracycraft.energy.DCIEnergyStorageFloat;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class DCNearbyStorageManagerBase {

    public static final int SEARCH_RANGE = 1;

    private DCNearbyStorageManagerBase() {
    }

    public static <T extends BlockEntity> List<ExtractEnergyStorageCandidate> findExtractEnergyStorages(Level level, BlockPos center, Class<T> allowedClass) {
        List<ExtractEnergyStorageCandidate> result = new ArrayList<>();

        if (level == null || level.isClientSide()) {
            return result;
        }

        for (BlockPos pos : BlockPos.betweenClosed(
                center.offset(-SEARCH_RANGE, -SEARCH_RANGE, -SEARCH_RANGE),
                center.offset(SEARCH_RANGE, SEARCH_RANGE, SEARCH_RANGE))) {

            if (pos.equals(center)) {
                continue;
            }

            BlockEntity blockEntity = level.getBlockEntity(pos);

            if (blockEntity == null || !allowedClass.isInstance(blockEntity)) {
                continue;
            }

            blockEntity.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(storage -> {

                if (!(storage instanceof DCIEnergyStorageFloat dcStorage)) {
                    return;
                }

                result.add(new ExtractEnergyStorageCandidate(pos.immutable(), dcStorage, center.distSqr(pos)));
            });
        }

        result.sort(Comparator.comparingDouble(ExtractEnergyStorageCandidate::distance));

        return result;
    }

    public static <T extends BlockEntity> List<ReceiveEnergyStorageCandidate> findReceiveEnergyStorages(Level level, BlockPos center, Class<T> allowedClass) {
        List<ReceiveEnergyStorageCandidate> result = new ArrayList<>();

        if (level == null || level.isClientSide()) {
            return result;
        }

        for (BlockPos pos : BlockPos.betweenClosed(
                center.offset(-SEARCH_RANGE, -SEARCH_RANGE, -SEARCH_RANGE),
                center.offset(SEARCH_RANGE, SEARCH_RANGE, SEARCH_RANGE))) {

            if (pos.equals(center)) {
                continue;
            }

            BlockEntity blockEntity = level.getBlockEntity(pos);

            if (blockEntity == null || !allowedClass.isInstance(blockEntity)) {
                continue;
            }

            blockEntity.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(storage -> {

                if (!(storage instanceof DCIEnergyStorageFloat dcStorage)) {
                    return;
                }

                result.add(new ReceiveEnergyStorageCandidate(pos.immutable(), dcStorage, center.distSqr(pos)));
            });
        }

        result.sort(Comparator.comparingDouble(ReceiveEnergyStorageCandidate::distance));

        return result;
    }

    public static <T extends BlockEntity> List<ExtractItemStorageCandidate> findExtractItemStorages(
            Level level,
            BlockPos center,
            Class<T> allowedClass
    ) {
        List<ExtractItemStorageCandidate> result = new ArrayList<>();

        if (level == null || level.isClientSide()) {
            return result;
        }

        for (BlockPos pos : BlockPos.betweenClosed(
                center.offset(-SEARCH_RANGE, -SEARCH_RANGE, -SEARCH_RANGE),
                center.offset(SEARCH_RANGE, SEARCH_RANGE, SEARCH_RANGE))) {

            if (pos.equals(center)) {
                continue;
            }

            BlockEntity blockEntity = level.getBlockEntity(pos);

            if (blockEntity == null || !allowedClass.isInstance(blockEntity)) {
                continue;
            }

            blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(handler -> {

                result.add(new ExtractItemStorageCandidate(pos.immutable(), handler, center.distSqr(pos)));
            });
        }

        result.sort(Comparator.comparingDouble(ExtractItemStorageCandidate::distance));

        return result;
    }

    public static <T extends BlockEntity> List<ReceiveItemStorageCandidate> findReceiveItemStorages(
            Level level,
            BlockPos center,
            Class<T> allowedClass
    ) {
        List<ReceiveItemStorageCandidate> result = new ArrayList<>();

        if (level == null || level.isClientSide()) {
            return result;
        }

        for (BlockPos pos : BlockPos.betweenClosed(
                center.offset(-SEARCH_RANGE, -SEARCH_RANGE, -SEARCH_RANGE),
                center.offset(SEARCH_RANGE, SEARCH_RANGE, SEARCH_RANGE))) {

            if (pos.equals(center)) {
                continue;
            }

            BlockEntity blockEntity = level.getBlockEntity(pos);

            if (blockEntity == null || !allowedClass.isInstance(blockEntity)) {
                continue;
            }

            blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(handler -> {

                result.add(new ReceiveItemStorageCandidate(pos.immutable(), handler, center.distSqr(pos)));
            });
        }

        result.sort(Comparator.comparingDouble(ReceiveItemStorageCandidate::distance));

        return result;
    }

    public record ExtractEnergyStorageCandidate(BlockPos position, DCIEnergyStorageFloat storage, double distance) {
    }

    public record ReceiveEnergyStorageCandidate(BlockPos position, DCIEnergyStorageFloat storage, double distance) {
    }

    public record ExtractItemStorageCandidate(BlockPos position, IItemHandler handler, double distance) {
    }

    public record ReceiveItemStorageCandidate(BlockPos position, IItemHandler handler, double distance) {
    }
}
