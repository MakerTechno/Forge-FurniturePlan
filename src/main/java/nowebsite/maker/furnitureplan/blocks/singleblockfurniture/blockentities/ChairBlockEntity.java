package nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredHolder;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.ChairBlock;
import nowebsite.maker.furnitureplan.entities.RideableEntityNull;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ChairBlockEntity extends BlockEntity {
    public RideableEntityNull sit = null;
    public final BlockState containerBlock;
    private int count = 0;

    public ChairBlockEntity(@NotNull DeferredHolder<BlockEntityType<?>, BlockEntityType<ChairBlockEntity>> type, BlockPos pos, BlockState state) {
        super(type.get(), pos, state);
        containerBlock = state;
    }

    public void tickAtServer() {
        if (this.sit != null && this.sit.getFirstPassenger() == null && this.count >= 10) {
            this.sit.kill();
            this.sit = null;
        } else if (this.count <= 10) {
            ++this.count;
        }
    }

    public InteractionResult useAct(Level level, BlockPos pos, Player player, Direction direction) {
        //TODO: Trying to add cat sit ability
        if (this.sit == null) {
            this.count = 0;
            this.sit = new RideableEntityNull(EntityType.ARMOR_STAND, level, () -> this);
            this.sit.setPos((double)pos.getX() + 0.5, (double)pos.getY() - 1.26, (double)pos.getZ() + 0.5);
            int rotate = switch (direction) {
                case EAST -> 90;
                case SOUTH -> 180;
                case WEST -> 270;
                default -> 0;
            };

            sit.setYRot(180 + rotate);
            level.addFreshEntity(this.sit);
            if (!player.startRiding(this.sit, true)) {
                player.displayClientMessage(Component.translatable("msg.furnitureplan.sit"), true);
                this.sit.kill();
                this.sit = null;
                return InteractionResult.PASS;
            } else {
                return InteractionResult.SUCCESS;
            }
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    public void setRemoved() {
        Objects.requireNonNull(getLevel()).removeBlockEntity(getBlockPos());
        if (containerBlock.getBlock() instanceof ChairBlock chairBlock){
            chairBlock.newBlockEntity(this.getBlockPos(), containerBlock);
        }
        if (this.sit != null) {
            this.sit.kill();
            this.sit = null;
        }
    }
}
