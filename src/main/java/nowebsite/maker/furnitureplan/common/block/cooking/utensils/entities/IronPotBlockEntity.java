package nowebsite.maker.furnitureplan.common.block.cooking.utensils.entities;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.Clearable;
import net.minecraft.world.Containers;
import net.minecraft.world.ItemStackWithSlot;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.util.Objects;

public class IronPotBlockEntity extends BlockEntity implements IFoodHolder, Clearable {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String STORAGE_NAME = "inventory";
    private ItemStack item = ItemStack.EMPTY;
    public IronPotBlockEntity(BlockPos pos, BlockState state) {
        super(FPBlockReg.IRON_POT_BE.get(), pos, state);
    }
    /**You can't change this*/
    public ItemStack getFoodStack() {
        return item.copy();
    }

    public void changeFood(@NotNull ItemStack stack) {
        item = stack;
    }

    public boolean placeFood(Entity entity, ItemStack stack) {
        if (!getFoodStack().isEmpty() || stack.is(Items.HONEY_BOTTLE)) return false;
        changeFood(stack.split(1));
        if (this.level != null) {
            this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of(entity, this.getBlockState()));
        }
        this.markUpdated();
        return true;
    }

    private void markUpdated() {
        this.setChanged();
        Objects.requireNonNull(this.getLevel()).sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }

    @Override
    protected void loadAdditional(@NotNull ValueInput input) {
        super.loadAdditional(input);
        clearContent();
        this.item = input.read(STORAGE_NAME, ItemStack.CODEC).orElse(ItemStack.EMPTY);
    }

    @Override
    protected void saveAdditional(@NotNull ValueOutput output) {
        super.saveAdditional(output);
        if (!getFoodStack().isEmpty()) output.store(STORAGE_NAME, ItemStack.CODEC, getFoodStack());
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }


    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.@NotNull Provider registries) {
        CompoundTag tag;
        try (ProblemReporter.ScopedCollector reporter = new ProblemReporter.ScopedCollector(this.problemPath(), LOGGER)) {
            TagValueOutput output = TagValueOutput.createWithContext(reporter, registries);
            ValueOutput.TypedOutputList<ItemStackWithSlot> itemsOutput = output.list("Items", ItemStackWithSlot.CODEC);
            if (!item.isEmpty()) {
                itemsOutput.add(new ItemStackWithSlot(0, item));
            }
            tag = output.buildResult();
        }
        return tag;
    }

    @Override
    public void preRemoveSideEffects(@NotNull BlockPos pos, @NotNull BlockState state) {
        if (this.getLevel() != null) drops();
    }

    @Override
    protected void applyImplicitComponents(@NotNull DataComponentGetter components) {
        super.applyImplicitComponents(components);
        item = components.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY).copyOne();
    }

    @Override
    protected void collectImplicitComponents(DataComponentMap.@NotNull Builder components) {
        super.collectImplicitComponents(components);
        components.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(NonNullList.of(item)));
    }

    @Override
    @SuppressWarnings("deprecation")
    public void removeComponentsFromTag(ValueOutput output) {
        output.discard(STORAGE_NAME);
    }

    public void drops(){
        SimpleContainer inventory = new SimpleContainer(1);
        inventory.setItem(0, getFoodStack());
        Containers.dropContents(Objects.requireNonNull(this.getLevel()), this.worldPosition, inventory);
        clearContent();
        markUpdated();
    }

    @Override
    public void clearContent() {
        this.item = ItemStack.EMPTY;
    }
}
