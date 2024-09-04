package nowebsite.maker.furnitureplan.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.VehicleEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.entity.IEntityWithComplexSpawn;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.BaseSittableBE;
import org.jetbrains.annotations.NotNull;

public class RideableEntityNull extends VehicleEntity implements IEntityWithComplexSpawn {
    private BlockPos blockEntityPos;
    public RideableEntityNull(EntityType<? extends VehicleEntity> entityType, Level level) {
        this(entityType, level, BlockPos.ZERO);
    }
    public RideableEntityNull(EntityType<? extends VehicleEntity> entityType, Level level, BlockPos blockEntityPos) {
        super(entityType, level);
        this.blockEntityPos = blockEntityPos;
        setNoGravity(true);
        setInvisible(true);
        horizontalCollision = false;
        minorHorizontalCollision = false;
        verticalCollision = false;
        verticalCollisionBelow = false;
    }
    @Override
    protected @NotNull Item getDropItem() {
        return Items.AIR;
    }
    @Override
    public void tick() {
        super.tick();
        BlockEntity blockEntity = level().getBlockEntity(blockEntityPos);
        if (!(blockEntity instanceof BaseSittableBE<?> cast)){
            this.remove(RemovalReason.DISCARDED);
        }
        else if (cast.getBlockState() != cast.containerBlock || canAddPassenger(this)){
            cast.setRemoved();
        }
    }
    private int count;
    @Override
    public void baseTick() {
        super.baseTick();
        if (count ==50) {
            BlockEntity blockEntity = level().getBlockEntity(blockEntityPos);
            if (!(blockEntity instanceof BaseSittableBE<?> cast)){
                this.remove(RemovalReason.DISCARDED);
            }
            else if (cast.getBlockState() != cast.containerBlock || canAddPassenger(this)){
                cast.setRemoved();
            }
        } else {
            count++;
        }
    }
    @Override
    protected void readAdditionalSaveData(@NotNull CompoundTag pCompound) {this.remove(RemovalReason.DISCARDED);}
    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag pCompound) {this.remove(RemovalReason.DISCARDED);}

    @Override
    public void writeSpawnData(@NotNull RegistryFriendlyByteBuf buffer) {
        buffer.writeBlockPos(this.blockEntityPos);
    }
    @Override
    public void readSpawnData(@NotNull RegistryFriendlyByteBuf additionalData) {
        blockEntityPos = additionalData.readBlockPos();
    }
}
