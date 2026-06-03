package net.epitap.degeneracycraft.world.feature.vein.parametor;

import net.epitap.degeneracycraft.world.feature.vein.veinbase.AbstractVein;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.WorldGenLevel;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class VeinBlockRegistry {
    private ArrayList<AbstractVein> veins;

    public VeinBlockRegistry() {
        this.veins = new ArrayList<>();
    }

    public void clear() {
        this.veins = new ArrayList<>();
    }
    
    public void addVein(AbstractVein ore) {
        this.veins.add(ore);
    }

    @Nullable
    public AbstractVein pick(WorldGenLevel level, BlockPos pos) {
        @SuppressWarnings("unchecked")
        ArrayList<AbstractVein> choices = (ArrayList<AbstractVein>) this.veins.clone();
        ResourceLocation dimension = level.getLevel().dimension().location();

        choices.removeIf(dep ->
                !dep.canPlaceInBiome(level.getBiome(pos)) ||
                        !dep.canPlaceInDimension(dimension)
        );

        if (choices.isEmpty()) {
            return null;
        }

        float totalWt = 0;
        for (AbstractVein vein : choices) {
            totalWt += vein.getGenerationWeight();
        }

        float ran = level.getRandom().nextFloat() * totalWt;
        for (AbstractVein vein : choices) {
            float wt = vein.getGenerationWeight();
            if (ran < wt) {
                return vein;
            }
            ran -= wt;
        }
        return null;
    }
}
