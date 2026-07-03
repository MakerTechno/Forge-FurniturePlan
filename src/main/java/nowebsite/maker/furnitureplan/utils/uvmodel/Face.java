package nowebsite.maker.furnitureplan.utils.uvmodel;

import net.minecraft.core.Direction;

public class Face {
    public final Direction dir;
    public final float u0, v0, u1, v1;
    public final int rotation; // 0, 90, 180, 270

    Face(Direction dir, float u0, float v0, float u1, float v1, int rotation) {
        this.dir = dir;
        this.u0 = u0 / 16;
        this.v0 = v0 / 16;
        this.u1 = u1 / 16;
        this.v1 = v1 / 16;
        this.rotation = rotation % 360;
    }

    public Direction getDir() {
        return dir;
    }

    public int getRotation() {
        return rotation;
    }

    // 返回旋转后的四个 UV
    public float[][] getRotatedUVs() {
        float[][] uvs = {
            {u0, v0}, // 左下
            {u1, v0}, // 右下
            {u1, v1}, // 右上
            {u0, v1}  // 左上
        };
        int steps = rotation / 90;
        for (int i = 0; i < steps; i++) {
            float[] tmp = uvs[0];
            uvs[0] = uvs[3];
            uvs[3] = uvs[2];
            uvs[2] = uvs[1];
            uvs[1] = tmp;
        }
        return uvs;
    }

}
