package net.epitap.degeneracycraft.integration.emi;

import net.minecraft.util.Mth;

public class DCMultiblockCamera {
    private static final float DEFAULT_YAW = 135.0F;
    private static final float DEFAULT_PITCH = 30.0F;
    private static final float DEFAULT_ZOOM = 1.0F;

    private static final float ROTATION_SPEED = 0.7F;
    private static final float MIN_PITCH = -89.0F;
    private static final float MAX_PITCH = 89.0F;

    /*
     * ズーム設定
     */
    private static final float MIN_ZOOM = 0.25F;
    private static final float MAX_ZOOM = 1.5F;
    private static final float ZOOM_SPEED = 0.1F;

    private float yaw = DEFAULT_YAW;
    private float pitch = DEFAULT_PITCH;
    private float zoom = DEFAULT_ZOOM;

    private boolean dragging;
    private double lastMouseX;
    private double lastMouseY;

    public void beginDrag(double mouseX, double mouseY) {
        dragging = true;
        lastMouseX = mouseX;
        lastMouseY = mouseY;
    }

    public void endDrag() {
        dragging = false;
    }

    public void drag(double mouseX, double mouseY) {
        if (!dragging) {
            return;
        }

        double deltaX = mouseX - lastMouseX;
        double deltaY = mouseY - lastMouseY;

        yaw += (float) deltaX * ROTATION_SPEED;
        pitch += (float) deltaY * ROTATION_SPEED;

        pitch = Mth.clamp(
                pitch,
                MIN_PITCH,
                MAX_PITCH
        );

        lastMouseX = mouseX;
        lastMouseY = mouseY;
    }

    public void scroll(double amount) {
        zoom += (float) amount * ZOOM_SPEED;

        zoom = Mth.clamp(
                zoom,
                MIN_ZOOM,
                MAX_ZOOM
        );
    }

    public float getYaw() {
        return yaw;
    }

    public float getPitch() {
        return pitch;
    }

    public float getZoom() {
        return zoom;
    }

    public boolean isDragging() {
        return dragging;
    }

    public void reset() {
        yaw = DEFAULT_YAW;
        pitch = DEFAULT_PITCH;
        zoom = DEFAULT_ZOOM;
        dragging = false;
    }
}