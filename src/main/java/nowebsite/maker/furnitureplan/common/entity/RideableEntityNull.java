package nowebsite.maker.furnitureplan.common.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.VehicleEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.entity.IEntityWithComplexSpawn;
import nowebsite.maker.furnitureplan.common.block.abstraction.be.BaseSittableBE;
import org.jetbrains.annotations.NotNull;

/**
 * 一个仅用来乘坐的实体，与{@link BaseSittableBE}相互作用以确保自身在无乘客时卸载。<p>
 * 当对应方块实体存在，应通过方块实体卸载本实体。<p>
 * 当对应方块实体脱离访问范围，实体应卸载自己。
 */
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
    protected Item getDropItem() {
        return Items.AIR;
    }
    @Override
    public void tick() {
        super.tick();
        BlockEntity blockEntity = level().getBlockEntity(blockEntityPos);
        if (!(blockEntity instanceof BaseSittableBE<?> cast)){
            this.remove(RemovalReason.DISCARDED);
        } else {
            if (canAddPassenger(this)) cast.cleanSeat();
        }
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {}

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {}

    @Override
    public void writeSpawnData(@NotNull RegistryFriendlyByteBuf buffer) {
        buffer.writeBlockPos(this.blockEntityPos);
    }
    @Override
    public void readSpawnData(@NotNull RegistryFriendlyByteBuf additionalData) {
        blockEntityPos = additionalData.readBlockPos();
    }
}
