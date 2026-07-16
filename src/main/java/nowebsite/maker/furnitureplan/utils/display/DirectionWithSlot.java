package nowebsite.maker.furnitureplan.utils.display;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Direction;
import net.minecraft.util.ExtraCodecs;

public record DirectionWithSlot(int slot, Direction direction) {
    public static final Codec<DirectionWithSlot> CODEC = RecordCodecBuilder.create(
        i -> i.group(
                ExtraCodecs.UNSIGNED_BYTE.fieldOf("Slot").orElse(0).forGetter(DirectionWithSlot::slot),
                Direction.CODEC.fieldOf("Dir").orElse(Direction.UP).forGetter(DirectionWithSlot::direction)
            )
            .apply(i, DirectionWithSlot::new)
    );

    public boolean isValidInContainer(int containerSize) {
        return this.slot >= 0 && this.slot < containerSize;
    }
}