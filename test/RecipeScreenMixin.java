package net.epitap.degeneracycraft.mixin;

import dev.emi.emi.api.widget.Widget;
import dev.emi.emi.screen.RecipeScreen;
import dev.emi.emi.screen.WidgetGroup;
import net.epitap.degeneracycraft.integration.emi.DCMultiblockEmiWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(RecipeScreen.class)
public abstract class RecipeScreenMixin {

    @Shadow(remap = false)
    private List<WidgetGroup> currentPage;

    @Unique
    private DCMultiblockEmiWidget degeneracycraft$activeWidget;

    @Unique
    private int degeneracycraft$activeGroupX;

    @Unique
    private int degeneracycraft$activeGroupY;

    @Unique
    private boolean degeneracycraft$activeCameraDrag;

    // =========================
    // Mouse Clicked
    // =========================

    @Inject(
            method = "mouseClicked",
            at = @At("HEAD"),
            cancellable = true
    )
    private void degeneracycraft$mouseClicked(
            double mouseX,
            double mouseY,
            int button,
            CallbackInfoReturnable<Boolean> cir
    ) {
        degeneracycraft$activeWidget = null;
        degeneracycraft$activeCameraDrag = false;

        DCMultiblockEmiWidget widget =
                degeneracycraft$findWidget(
                        mouseX,
                        mouseY
                );

        if (widget == null) {
            return;
        }

        double localX =
                mouseX
                        - degeneracycraft$activeGroupX;

        double localY =
                mouseY
                        - degeneracycraft$activeGroupY;

        /*
         * Widget側でクリック処理。
         */
        boolean handled =
                widget.mousePressed(
                        localX,
                        localY,
                        button
                );

        if (!handled) {
            return;
        }

        /*
         * 重要：
         *
         * 「3Dプレビュー上で左クリックした」
         * 場合だけカメラドラッグを開始する。
         *
         * Required BlocksやLayerボタンを
         * クリックした場合はfalse。
         */
        if (button == 0
                && widget.isInsidePreview(
                localX,
                localY
        )) {

            degeneracycraft$activeWidget = widget;
            degeneracycraft$activeCameraDrag = true;
        }

        /*
         * Widgetが処理したクリックだけ
         * EMI本来の処理へ流さない。
         */
        cir.setReturnValue(true);
    }

    // =========================
    // Mouse Dragged
    // =========================

    @Inject(
            method = "mouseDragged",
            at = @At("HEAD"),
            cancellable = true
    )
    private void degeneracycraft$mouseDragged(
            double mouseX,
            double mouseY,
            int button,
            double deltaX,
            double deltaY,
            CallbackInfoReturnable<Boolean> cir
    ) {
        /*
         * カメラドラッグ中でなければ
         * EMI本来の処理をそのまま続行。
         */
        if (button != 0
                || degeneracycraft$activeWidget == null
                || !degeneracycraft$activeCameraDrag) {
            return;
        }

        double localX =
                mouseX
                        - degeneracycraft$activeGroupX;

        double localY =
                mouseY
                        - degeneracycraft$activeGroupY;

        degeneracycraft$activeWidget.mouseDragged(
                localX,
                localY
        );

        cir.setReturnValue(true);
    }

    // =========================
    // Mouse Released
    // =========================

    @Inject(
            method = "mouseReleased",
            at = @At("HEAD"),
            cancellable = true
    )
    private void degeneracycraft$mouseReleased(
            double mouseX,
            double mouseY,
            int button,
            CallbackInfoReturnable<Boolean> cir
    ) {
        if (button != 0
                || degeneracycraft$activeWidget == null) {
            return;
        }

        if (degeneracycraft$activeCameraDrag) {
            degeneracycraft$activeWidget.mouseReleased();

            degeneracycraft$activeWidget = null;
            degeneracycraft$activeCameraDrag = false;

            cir.setReturnValue(true);
        }
    }

    // =========================
    // Mouse Scrolled
    // =========================

    @Inject(
            method = "mouseScrolled",
            at = @At("HEAD"),
            cancellable = true
    )
    private void degeneracycraft$mouseScrolled(
            double mouseX,
            double mouseY,
            double amount,
            CallbackInfoReturnable<Boolean> cir
    ) {
        DCMultiblockEmiWidget widget =
                degeneracycraft$findWidget(
                        mouseX,
                        mouseY
                );

        if (widget == null) {
            return;
        }

        double localX =
                mouseX
                        - degeneracycraft$activeGroupX;

        double localY =
                mouseY
                        - degeneracycraft$activeGroupY;

        /*
         * 3Dプレビュー上だけズームを処理する。
         *
         * Required Blocks上でのホイールを
         * DCMultiblock側が奪わない。
         */
        if (widget.isInsidePreview(
                localX,
                localY
        )) {
            widget.mouseScrolled(amount);

            cir.setReturnValue(true);
        }
    }

    // =========================
    // Find Widget
    // =========================

    @Unique
    private DCMultiblockEmiWidget degeneracycraft$findWidget(
            double mouseX,
            double mouseY
    ) {
        if (currentPage == null) {
            return null;
        }

        for (WidgetGroup group : currentPage) {

            int groupX = group.x();
            int groupY = group.y();

            double localX =
                    mouseX - groupX;

            double localY =
                    mouseY - groupY;

            for (Widget widget : group.widgets) {

                if (widget instanceof DCMultiblockEmiWidget dcWidget
                        && dcWidget.isMouseOver(
                        localX,
                        localY
                )) {

                    degeneracycraft$activeGroupX =
                            groupX;

                    degeneracycraft$activeGroupY =
                            groupY;

                    return dcWidget;
                }
            }
        }

        return null;
    }
}