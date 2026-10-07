package net.epitap.degeneracycraft.block.machine.basic.astronomy.basic_performance_astronomical_telescope;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.epitap.degeneracycraft.block.base.machine.DCMachineScreenBase;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BasicPerformanceAstronomicalTelescopeScreen
        extends DCMachineScreenBase<BasicPerformanceAstronomicalTelescopeMenu> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(
                    Degeneracycraft.MOD_ID,
                    "textures/gui/basic/astronomy/basic_performance_astronomical_telescope/basic_performance_astronomical_telescope_gui.png"
            );


    public BasicPerformanceAstronomicalTelescopeScreen(BasicPerformanceAstronomicalTelescopeMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
    }


    @Override
    protected DCMachineScreenLayout createLayout() {

        return new DCMachineScreenLayout(
                176,
                166,
                71, 59,
                98, 62,
                8, 62,
                16,
                67, 30,
                80, 11,
                80, 47,
                133, 66,
                43, 66,

                66, 28, 26, 10,
                66, 45, 26, 10,
                117, 64, 30, 12,
                27, 64, 30, 12,

                157,
                10,
                9,
                64,

                3.0F,
                2.0F,
                2.0F,
                1.5F,
                1.0F,
                1.0F
        );
    }

    @Override
    protected ResourceLocation getTexture() {
        return TEXTURE;
    }
}