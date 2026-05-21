package net.epitap.degeneracycraft.world.feature.vein.veinbase;

import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class VeinUtils {
    private static HashSet<BlockState> defaultMatchersCached = null;

    @Nullable
    public static BlockState pick(HashMap<BlockState, Float> map, RandomSource random) {
        if (map.isEmpty()) return null;

        float rng = random.nextFloat();
        for (Entry<BlockState, Float> e : map.entrySet()) {
            float wt = e.getValue();
            if (rng < wt) {
                return e.getKey();
            }
            rng -= wt;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static HashSet<BlockState> getDefaultMatchers() {
        if (defaultMatchersCached == null) {
            defaultMatchersCached = new HashSet<>();
        }

        return (HashSet<BlockState>) defaultMatchersCached.clone();
    }
}
