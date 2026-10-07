package net.epitap.degeneracycraft.multiblock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public final class DCMultiblockMatcher {
    private DCMultiblockMatcher() {}

    public static boolean matches(Level level, BlockPos controllerPos, DCMultiblockFile file) {
        return matches(level, controllerPos, file, Direction.NORTH);
    }

    public static boolean matches(Level level, BlockPos controllerPos, DCMultiblockFile file, Direction facing) {
        BlockPos controllerOffset = file.getControllerOffset();
        if (controllerOffset == null) return false;

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

                    BlockPos worldPos = controllerPos.offset(
                            DCMultiblockUtil.rotateRelativePos(relative, facing)
                    );

                    if (!matchesPlaceholder(level, worldPos, placeholder)) return false;
                }
            }
        }

        return true;
    }

    private static boolean matchesPlaceholder(Level level, BlockPos pos, DCMultiblockFile.DCPlaceholder placeholder) {
        if (placeholder.getPredicates().isEmpty()) return false;

        for (DCMultiblockFile.DCPredicate predicate : placeholder.getPredicates()) {
            if (matchesPredicate(level, pos, predicate)) return true;
        }

        return false;
    }

    private static boolean matchesPredicate(Level level, BlockPos pos, DCMultiblockFile.DCPredicate predicate) {
        if (predicate.isAny()) return true;
        if (predicate.isAir()) return level.isEmptyBlock(pos);

        if (predicate.isBlock()) {
            ResourceLocation expected = predicate.getBlockId();
            if (expected == null) return false;

            ResourceLocation actual = BuiltInRegistries.BLOCK.getKey(level.getBlockState(pos).getBlock());
            return expected.equals(actual);
        }

        return false;
    }
}