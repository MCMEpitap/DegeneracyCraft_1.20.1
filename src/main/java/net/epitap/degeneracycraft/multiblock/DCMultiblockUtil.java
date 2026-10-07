package net.epitap.degeneracycraft.multiblock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

public final class DCMultiblockUtil {
    private DCMultiblockUtil() {}

    public static BlockPos rotateRelativePos(BlockPos relative, Direction facing) {
        return switch (facing) {
            case NORTH -> new BlockPos(relative.getX(), relative.getY(), relative.getZ());
            case EAST -> new BlockPos(-relative.getZ(), relative.getY(), relative.getX());
            case SOUTH -> new BlockPos(-relative.getX(), relative.getY(), -relative.getZ());
            case WEST -> new BlockPos(relative.getZ(), relative.getY(), -relative.getX());
            default -> relative;
        };
    }
}
