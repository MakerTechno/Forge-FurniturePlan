package nowebsite.maker.furnitureplan.utils;

import net.minecraft.core.Direction;

public class FPCubeDefinition {
    private float x, y, z, w, h, d;
    private Face north, south, west, east, up, down;

    public FPCubeDefinition model(float x, float y, float z,
                                  float w, float h, float d) {
        this.x = x; this.y = y; this.z = z;
        this.w = w; this.h = h; this.d = d;
        return this;
    }

    // 六个面贴图声明，增加 rotation 参数
    public FPCubeDefinition north(float u0, float v0, float u1, float v1, int rotation) {
        this.north = new Face(Direction.NORTH, u0, v0, u1, v1, rotation);
        return this;
    }
    public FPCubeDefinition south(float u0, float v0, float u1, float v1, int rotation) {
        this.south = new Face(Direction.SOUTH, u0, v0, u1, v1, rotation);
        return this;
    }
    public FPCubeDefinition west(float u0, float v0, float u1, float v1, int rotation) {
        this.west = new Face(Direction.WEST, u0, v0, u1, v1, rotation);
        return this;
    }
    public FPCubeDefinition east(float u0, float v0, float u1, float v1, int rotation) {
        this.east = new Face(Direction.EAST, u0, v0, u1, v1, rotation);
        return this;
    }
    public FPCubeDefinition up(float u0, float v0, float u1, float v1, int rotation) {
        this.up = new Face(Direction.UP, u0, v0, u1, v1, rotation);
        return this;
    }
    public FPCubeDefinition down(float u0, float v0, float u1, float v1, int rotation) {
        this.down = new Face(Direction.DOWN, u0, v0, u1, v1, rotation);
        return this;
    }

    public CubeModel build() {
        CubeModel model = new CubeModel(x / 16, y / 16, z / 16, w / 16, h / 16, d / 16);
        if (north != null) model.addFace(north);
        if (south != null) model.addFace(south);
        if (west != null) model.addFace(west);
        if (east != null) model.addFace(east);
        if (up != null) model.addFace(up);
        if (down != null) model.addFace(down);
        return model;
    }

    public static class Face {
        private final Direction dir;
        private final float u0, v0, u1, v1;
        private final int rotation; // 0, 90, 180, 270

        Face(Direction dir, float u0, float v0, float u1, float v1, int rotation) {
            this.dir = dir;
            this.u0 = u0 / 16; this.v0 = v0 / 16;
            this.u1 = u1 / 16; this.v1 = v1 / 16;
            this.rotation = rotation % 360;
        }

        public Direction getDir() { return dir; }
        public int getRotation() { return rotation; }

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
}
