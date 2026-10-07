package net.epitap.degeneracycraft.multiblock;

import com.mojang.blaze3d.vertex.VertexConsumer;

public class DCAlphaVertexConsumer implements VertexConsumer {

    private final VertexConsumer delegate;
    private final float alpha;

    public DCAlphaVertexConsumer(VertexConsumer delegate, float alpha) {
        this.delegate = delegate;
        this.alpha = alpha;
    }

    @Override
    public VertexConsumer vertex(double x, double y, double z) {
        delegate.vertex(x, y, z);
        return this;
    }

    @Override
    public VertexConsumer color(int red, int green, int blue, int originalAlpha) {
        delegate.color(
                red,
                green,
                blue,
                (int)(originalAlpha * alpha)
        );
        return this;
    }

    @Override
    public VertexConsumer uv(float u, float v) {
        delegate.uv(u, v);
        return this;
    }

    @Override
    public VertexConsumer overlayCoords(int u, int v) {
        delegate.overlayCoords(u, v);
        return this;
    }

    @Override
    public VertexConsumer uv2(int u, int v) {
        delegate.uv2(u, v);
        return this;
    }

    @Override
    public VertexConsumer normal(float x, float y, float z) {
        delegate.normal(x, y, z);
        return this;
    }

    @Override
    public void endVertex() {
        delegate.endVertex();
    }

    @Override
    public void defaultColor(int red, int green, int blue, int originalAlpha) {
        delegate.defaultColor(
                red,
                green,
                blue,
                (int)(originalAlpha * alpha)
        );
    }
    @Override
    public void unsetDefaultColor() {
        delegate.unsetDefaultColor();
    }
}