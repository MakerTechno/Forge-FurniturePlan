package nowebsite.maker.furnitureplan.blocks.singleblockfurniture;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.CabinetBlockEntity;
import nowebsite.maker.furnitureplan.registry.kindsblock.cabinet.*;
import org.jetbrains.annotations.NotNull;

import static nowebsite.maker.furnitureplan.registry.kindsblock.cabinet.CabinetBlockRegistration.CABINET_BLOCK_ENTITY;

public class ColorfulBorderedCabinet extends CabinetBlock{
    private final MapCodec<ColorfulBorderedCabinet> CODEC = RecordCodecBuilder.mapCodec(
        cabinetBlockInstance -> cabinetBlockInstance.group(
            propertiesCodec(),
            BlockState.CODEC.fieldOf("base_state").forGetter(block -> block.baseState),
            Codec.BOOL.fieldOf("hasDoorRendered").forGetter(block -> block.hasDoorRendered),
            Codec.INT.fieldOf("colorId").forGetter(block -> block.colorId)
        ).apply(cabinetBlockInstance, this::getSelfNew)
    );
    final int colorId;
    public ColorfulBorderedCabinet(Properties properties, BlockState state, boolean hasDoorRendered, int colorId) {
        super(properties, state, hasDoorRendered);
        this.colorId = colorId;
    }
    @Override
    protected @NotNull MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }
    protected @NotNull ColorfulBorderedCabinet getSelfNew(Properties properties, BlockState baseState, boolean hasDoorRendered, int colorId) {
        return new ColorfulBorderedCabinet(properties, baseState, hasDoorRendered, colorId);
    }
    public int getColorId() {
        return colorId;
    }
    @Override
    public String parentName() {
        return "cabinet"+colorId;
    }
    @Override
    public String textureKey() {
        return "particle";
    }

    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new CabinetBlockEntity(getColored(), pos, state);
    }
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level pLevel, @NotNull BlockState pState, @NotNull BlockEntityType<T> pBlockEntityType) {
        return pLevel.isClientSide ? createTickerHelper(pBlockEntityType, getColored(), CabinetBlockEntity::animateTick) : null;
    }
    public BlockEntityType<CabinetBlockEntity> getColored(){
        return switch (colorId) {
            case 0 -> BlackCabinetRegistration.BLACK_CABINET_BLOCK_ENTITY.get();
            case 1 -> BlueCabinetRegistration.BLUE_CABINET_BLOCK_ENTITY.get();
            case 2 -> BrownCabinetRegistration.BROWN_CABINET_BLOCK_ENTITY.get();
            case 3 -> CyanCabinetRegistration.CYAN_CABINET_BLOCK_ENTITY.get();
            case 4 -> GrayCabinetRegistration.GRAY_CABINET_BLOCK_ENTITY.get();
            case 5 -> GreenCabinetRegistration.GREEN_CABINET_BLOCK_ENTITY.get();
            case 6 -> LightBlueCabinetRegistration.LIGHT_BLUE_CABINET_BLOCK_ENTITY.get();
            case 7 -> LightGrayCabinetRegistration.LIGHT_GRAY_CABINET_BLOCK_ENTITY.get();
            case 8 -> LimeCabinetRegistration.LIME_CABINET_BLOCK_ENTITY.get();
            case 9 -> MagentaCabinetRegistration.MAGENTA_CABINET_BLOCK_ENTITY.get();
            case 10 -> OrangeCabinetRegistration.ORANGE_CABINET_BLOCK_ENTITY.get();
            case 11 -> PinkCabinetRegistration.PINK_CABINET_BLOCK_ENTITY.get();
            case 12 -> PurpleCabinetRegistration.PURPLE_CABINET_BLOCK_ENTITY.get();
            case 13 -> RedCabinetRegistration.RED_CABINET_BLOCK_ENTITY.get();
            case 14 -> YellowCabinetRegistration.YELLOW_CABINET_BLOCK_ENTITY.get();
            case 15 -> WhiteCabinetRegistration.WHITE_CABINET_BLOCK_ENTITY.get();
            default -> CABINET_BLOCK_ENTITY.get();
        };
    }
}
