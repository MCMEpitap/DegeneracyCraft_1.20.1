package net.epitap.degeneracycraft.transport.pipe.parametor;

import net.epitap.degeneracycraft.Degeneracycraft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.ModelEvent;

public class PipeModelRegistry {

    public enum DCPipeModel {
        BASIC_ENERGY_PIPE_BLOCK_EXTRACT("block/basic_energy_pipe_extract"),
        BASIC_ITEM_PIPE_BLOCK_EXTRACT("block/basic_item_pipe_extract"),
        FLOAT_ENERGY_PIPE_BLOCK_EXTRACT("block/basic_energy_pipe_extract");

        private final ResourceLocation resource;
        private final PipeTransportModelValue<BakedModel> cachedModel;

        DCPipeModel(String name) {
            this.resource = new ResourceLocation(Degeneracycraft.MOD_ID, name);

            this.cachedModel = new PipeTransportModelValue<>(() -> {
                BakedModel model = Minecraft.getInstance()
                        .getModelManager()
                        .getModel(resource);
                return model;
            });
        }

        public ResourceLocation getResourceLocation() {
            return resource;
        }

        public PipeTransportModelValue<BakedModel> getCachedModel() {
            return cachedModel;
        }
    }

    public static void onModelRegister(ModelEvent.RegisterAdditional event) {
        for (DCPipeModel model : DCPipeModel.values()) {
            event.register(model.getResourceLocation());
        }
    }


    public static void onModelBake(ModelEvent.BakingCompleted event) {
        for (DCPipeModel model : DCPipeModel.values()) {
            model.getCachedModel().invalidate();
        }
    }
}
