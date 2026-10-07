package net.epitap.degeneracycraft.integration.emi;

import org.joml.Matrix4f;

public final class DCMultiblockProjection {
    private DCMultiblockProjection() {
    }

    public static Matrix4f create(
            int width,
            int height
    ) {
        float aspect = (float) width / (float) Math.max(height, 1);

        return new Matrix4f().perspective(
                (float) Math.toRadians(45.0F),
                aspect,
                0.05F,
                1000.0F
        );
    }
}