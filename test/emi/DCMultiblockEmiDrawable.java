//package net.epitap.degeneracycraft.integration.emi;
//
//import net.minecraft.client.gui.GuiGraphics;
//
//public class DCMultiblockEmiDrawable {
//    private final DCMultiblockDisplayData data;
//    private final DCMultiblockPreviewRenderer renderer;
//    private final int width;
//    private final int height;
//
//    public DCMultiblockEmiDrawable(
//            DCMultiblockDisplayData data,
//            int width,
//            int height
//    ) {
//        this.data = data;
//        this.renderer = new DCMultiblockPreviewRenderer();
//        this.width = width;
//        this.height = height;
//    }
//
//    public void render(
//            GuiGraphics graphics,
//            int mouseX,
//            int mouseY,
//            float delta
//    ) {
//        renderer.render(
//                graphics,
//                data,
//                width,
//                height
//        );
//    }
//}