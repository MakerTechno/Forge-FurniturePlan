package nowebsite.maker.furnitureplan.common.block.storaging;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.block.abstraction.BasePropertyExtendedBlock;
import nowebsite.maker.furnitureplan.common.block.abstraction.BasePropertyHorizontalDirectionBlock;
import nowebsite.maker.furnitureplan.common.block.abstraction.BlockSetGetter;
import nowebsite.maker.furnitureplan.common.block.abstraction.generators.HorizontalBDG;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockSetType;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockType;
import nowebsite.maker.furnitureplan.common.block.storaging.entity.CupboardBlockEntity;
import nowebsite.maker.furnitureplan.common.data.gen.empowered.AutoGenBlockData;
import nowebsite.maker.furnitureplan.common.data.gen.empowered.BlockDataGenerator;
import nowebsite.maker.furnitureplan.common.init.FPTags;
import nowebsite.maker.furnitureplan.utils.Vec3Utils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CupboardBlock extends BasePropertyHorizontalDirectionBlock<CupboardBlock> implements EntityBlock, AutoGenBlockData<@NotNull CupboardBlock>, BlockSetGetter {
    public static final VoxelShape SHAPE = Shapes.or(
        Shapes.box(0, 0, 0, 0.0625, 0.125, 0.0625),
        Shapes.box(0, 0.0625, 0.0625, 0.0625, 0.125, 0.125),
        Shapes.box(0.0625, 0.0625, 0, 0.125, 0.125, 0.0625),
        Shapes.box(0, 0, 0.9375, 0.0625, 0.125, 1),
        Shapes.box(0.0625, 0.0625, 0.9375, 0.125, 0.125, 1),
        Shapes.box(0, 0.0625, 0.875, 0.0625, 0.125, 0.9375),
        Shapes.box(0.9375, 0, 0.9375, 1, 0.125, 1),
        Shapes.box(0.9375, 0.0625, 0.875, 1, 0.125, 0.9375),
        Shapes.box(0.875, 0.0625, 0.9375, 0.9375, 0.125, 1),
        Shapes.box(0.9375, 0, 0, 1, 0.125, 0.0625),
        Shapes.box(0.875, 0.0625, 0, 0.9375, 0.125, 0.0625),
        Shapes.box(0.9375, 0.0625, 0.0625, 1, 0.125, 0.125),
        Shapes.box(0, 0.125, 0, 1, 0.1875, 1),
        Shapes.box(0.03125, 0.1875, 0.03125, 0.96875, 0.9375, 0.96875),
        Shapes.box(0, 0.9375, 0, 1, 1, 1)
    );

    public CupboardBlock(FPBlockSetType type, BlockState base, BlockBehaviour.Properties properties) {
        super(type, base, properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    protected boolean triggerEvent(BlockState state, Level level, BlockPos pos, int b0, int b1) {
        super.triggerEvent(state, level, pos, b0, b1);
        BlockEntity blockEntity = level.getBlockEntity(pos);
        return blockEntity != null && blockEntity.triggerEvent(b0, b1);
    }

    @Override
    protected @org.jspecify.annotations.Nullable MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        return blockEntity instanceof MenuProvider ? (MenuProvider)blockEntity : null;
    }

    @SuppressWarnings("unchecked")
    protected static <E extends BlockEntity, A extends BlockEntity> @org.jspecify.annotations.Nullable BlockEntityTicker<A> createTickerHelper(
        BlockEntityType<A> actual, BlockEntityType<E> expected, BlockEntityTicker<? super E> ticker
    ) {
        return expected == actual ? (BlockEntityTicker<A>)ticker : null;
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState pState) {
        return true;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CupboardBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide() ? (_, _, _, t) -> {
            if (t instanceof CupboardBlockEntity cupboard) cupboard.animateTick();
        } : null;
    }

    private static boolean isNotBlockedDrawerByBlock(BlockGetter level, BlockPos pos) {
        Direction direction = level.getBlockState(pos).getValue(FACING);
        BlockPos faceBlock = switch (direction){
            case NORTH -> pos.north();
            case EAST -> pos.east();
            case SOUTH -> pos.south();
            case WEST -> pos.west();
            default -> null;
        };
        if (faceBlock == null) return true;
        return !level.getBlockState(faceBlock).isRedstoneConductor(level, faceBlock);
    }
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof CupboardBlockEntity blockEntity) {
            Direction facing = state.getValue(CupboardBlock.FACING);
            if (facing != hitResult.getDirection()) return InteractionResult.PASS;
            Vec3 hit = hitResult.getLocation().subtract(pos.getX(), pos.getY(), pos.getZ());
            double x = Vec3Utils.getXFromHit(facing, hit);

            if (level.isClientSide()) {
                return InteractionResult.SUCCESS;
            } else {
                if (x > 3.0 / 16 && x < 15.0 / 16 && isNotBlockedDrawerByBlock(level, pos)) {
                    if (x < 7.3 / 16) { //Drawer3
                        blockEntity.removeUsingD1Player(player);
                        blockEntity.removeUsingD2Player(player);
                        blockEntity.addUsingD3Player(player);
                    } else if (x < 11.3 / 16) {//Drawer2
                        blockEntity.removeUsingD1Player(player);
                        blockEntity.removeUsingD3Player(player);
                        blockEntity.addUsingD2Player(player);
                    } else {//Drawer1
                        blockEntity.removeUsingD2Player(player);
                        blockEntity.removeUsingD3Player(player);
                        blockEntity.addUsingD1Player(player);
                    }
                }
                MenuProvider menuprovider = this.getMenuProvider(state, level, pos);
                if (menuprovider != null) {
                    player.openMenu(menuprovider);
                }
                return InteractionResult.CONSUME;
            }
        }
        return InteractionResult.FAIL;
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        if (pStack.get(DataComponents.CUSTOM_DATA) != null) {
            if (pLevel.getBlockEntity(pPos) instanceof CupboardBlockEntity blockEntity) {
                blockEntity.setCustomName(pStack.getHoverName());
            }
        }
    }

    @Override
    protected boolean shouldChangedStateKeepBlockEntity(BlockState oldState) {
        return true;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected BasePropertyExtendedBlock<CupboardBlock> createNewInstance(BlockState baseState, Properties properties) {
        return new CupboardBlock(getType(), baseState, properties);
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pLevel.getBlockEntity(pPos) instanceof CupboardBlockEntity blockEntity) {
            blockEntity.recheckOpen();
        }
    }

    @Override
    public @Nullable BlockDataGenerator<? super CupboardBlock> getGenerator() {
        return new HorizontalBDG<>() {
            @Override
            public FPBlockType<? extends @NotNull CupboardBlock> getTemplateType(@NotNull CupboardBlock block) {
                return FPBlockType.CUPBOARD;
            }

            @Override
            public void addBlockTags(CupboardBlock block, BlockTagsProvider provider, List<TagKey<Block>> keys) {
                super.addBlockTags(block, provider, keys);
                keys.add(FPTags.CUPBOARD_BLOCK);
            }

            @Override
            public Identifier getItemTemplate() {
                return FurniturePlan.asResource("item/cupboard");
            }
        };
    }
}
