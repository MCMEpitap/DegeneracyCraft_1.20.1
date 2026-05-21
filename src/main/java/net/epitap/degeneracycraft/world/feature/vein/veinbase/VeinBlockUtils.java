package net.epitap.degeneracycraft.world.feature.vein.veinbase;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class VeinBlockUtils {
    public static String getRegistryName(Block block) {
        return Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).toString();
    }

    public static String getRegistryName(BlockState state) {
        return getRegistryName(state.getBlock());
    }

    public static BlockPos getTopSolidBlock(LevelReader level, BlockPos start) {
        var retPos = new BlockPos(start.getX(), level.getHeight() - 1, start.getZ());
        while (retPos.getY() > 0) {
            if (level.getBlockState(retPos).isSolidRender(level, retPos)) {
                break;
            }

            retPos = retPos.below();
        }
        return retPos;
    }
}