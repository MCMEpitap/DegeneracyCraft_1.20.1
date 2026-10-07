package net.epitap.degeneracycraft.block.machine.basic.astronomy.basic_performance_astronomical_telescope;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.multiblock.DCMultiblockHologramRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class BasicPerformanceAstronomicalTelescopeMultiblockRenderer
        extends DCMultiblockHologramRenderer<BasicPerformanceAstronomicalTelescopeBlockEntity> {

    public static final ResourceLocation LEVEL_0 = new ResourceLocation(
            Degeneracycraft.MOD_ID,
            "basic/astronomy/basic_performance_astronomical_telescope_0"
    );

    public static final ResourceLocation LEVEL_1 = new ResourceLocation(
            Degeneracycraft.MOD_ID,
            "basic/astronomy/basic_performance_astronomical_telescope_1"
    );

    public BasicPerformanceAstronomicalTelescopeMultiblockRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected ResourceLocation getHologramMultiblockId(BasicPerformanceAstronomicalTelescopeBlockEntity blockEntity, int hologramLevel) {
        return switch (hologramLevel) {
            case 0 -> LEVEL_0;
            case 1 -> LEVEL_1;
            default -> null;
        };
    }
}