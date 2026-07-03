package nowebsite.maker.furnitureplan.utils.uvmodel;

import net.minecraft.core.Direction;

public class FPCubeDefinition {
    private float x, y, z, w, h, d;
    private Face north, south, west, east, up, down;

    public FPCubeDefinition model(float x, float y, float z, float w, float h, float d) {
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

}
