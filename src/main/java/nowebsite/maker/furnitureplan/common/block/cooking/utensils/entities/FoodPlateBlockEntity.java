package nowebsite.maker.furnitureplan.common.block.cooking.utensils.entities;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.ticks.ContainerSingleItem;
import nowebsite.maker.furnitureplan.common.block.cooking.utensils.FoodPlateBlock;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import nowebsite.maker.furnitureplan.common.item.GlassBBlockItem;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.util.Objects;

public class FoodPlateBlockEntity extends BlockEntity implements HasPlateEntity, HasGlassEntity, ContainerSingleItem.BlockContainerSingleItem {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String STORAGE_NAME = "inventory";
    private ItemStack foodItem = ItemStack.EMPTY;
    private ItemStack potionItem = ItemStack.EMPTY;
    
    
    public FoodPlateBlockEntity(BlockPos pos, BlockState state) {
        super(FPBlockReg.FOOD_PLATE_BLOCK_ENTITY.get(), pos, state);
    }

    /**You can't change this*/
    public ItemStack getFoodStack() {
        return foodItem.copy();
    }

    /**You can't change this*/
    public ItemStack getPotionStack(){
        if (this.getBlockState().getValue(FoodPlateBlock.SHAPE_DEF).hasGlass()) {
            return potionItem.copy();
        } else return ItemStack.EMPTY;
    }

    public void changeFood(ItemStack stack) {
        foodItem = stack;
        this.markUpdated();
    }

    public void changePotion(ItemStack stack){
        potionItem = stack;
        this.markUpdated();
    }

    public boolean placeFood(Entity entity, ItemStack stack) {
        if (!getFoodStack().isEmpty() || stack.is(Items.HONEY_BOTTLE)) return false;
        if (this.level != null) {
            this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of(entity, this.getBlockState()));
        }
        changeFood(stack.split(1));
        return true;
    }

    public boolean fillPotion(Entity entity, ItemStack stack) {
        if (!getPotionStack().isEmpty() || !this.getBlockState().getValue(FoodPlateBlock.SHAPE_DEF).hasGlass()) return false;
        if (this.level != null) {
            this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of(entity, this.getBlockState()));
        }
        this.changePotion(stack.split(1));
        if (entity instanceof Player player && !player.getAbilities().instabuild) {
            if (player.getInventory().getFreeSlot() != -1) {
                player.getInventory().add(new ItemStack(Items.GLASS_BOTTLE, 1));
                player.getInventory().setChanged();
            }
            else player.drop(new ItemStack(Items.GLASS_BOTTLE, 1), false,false);
        }
        return true;
    }

    public boolean usePotion(Player player){
        if (getPotionStack().isEmpty() || !this.getBlockState().getValue(FoodPlateBlock.SHAPE_DEF).hasGlass()) return false;
        PotionContents potioncontents = getPotionStack().getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
        potioncontents.forEachEffect(effect -> {
            if (level instanceof ServerLevel serverLevel && effect.getEffect().value().isInstantenous()) {
                effect.getEffect().value().applyInstantenousEffect(serverLevel, null, null, player, effect.getAmplifier(), 1.0);
            } else {
                player.addEffect(effect);
            }
        }, 1.2f);
        if (this.level != null) {
            this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of(player, this.getBlockState()));
        }
        changePotion(ItemStack.EMPTY);
        return true;
    }

    public boolean restorePotion(Player player, @NotNull ItemStack stack){
        if (!stack.is(Items.GLASS_BOTTLE) || getPotionStack().isEmpty() || !this.getBlockState().getValue(FoodPlateBlock.SHAPE_DEF).hasGlass()) return false;
        stack.shrink(1);
        if (player.getInventory().getFreeSlot() != -1) {
            player.getInventory().add(getPotionStack());
            player.getInventory().setChanged();
        }
        else player.drop(getPotionStack(), false,false);
        if (this.level != null) {
            this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of(player, this.getBlockState()));
        }
        changePotion(ItemStack.EMPTY);
        return true;
    }

    @Override
    public void preRemoveSideEffects(BlockPos pos, BlockState state) {
        SimpleContainer inventory = new SimpleContainer(2);
        ItemStack stack = Items.AIR.getDefaultInstance();
        if (state.getValue(FoodPlateBlock.SHAPE_DEF).hasCutlery()) stack = new ItemStack(FPBlockReg.CUTLERY_ITEM.get(), 1);
        if (state.getValue(FoodPlateBlock.SHAPE_DEF).hasGlass()) this.dropBottle();
        this.popFood();
        inventory.setItem(0, stack);
        inventory.setItem(1, FPBlockReg.FOOD_PLATE_BLOCK_ITEM.get().getDefaultInstance());
        if (level != null) Containers.dropContents(level, pos, inventory);
    }

    private void markUpdated() {
        this.setChanged();
        Objects.requireNonNull(this.getLevel()).sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }

    public void popFood(){
        SimpleContainer inventory = new SimpleContainer(1);
        inventory.setItem(0, getFoodStack());
        Containers.dropContents(Objects.requireNonNull(this.getLevel()), this.worldPosition, inventory);
        changeFood(ItemStack.EMPTY);
        markUpdated();
    }

    public void dropBottle(){
        SimpleContainer inventory = new SimpleContainer(1);
        ItemStack stack = new ItemStack(FPBlockReg.GLASS_B_BLOCK_ITEM.get(),1);
        if (level == null) return;
        GlassBBlockItem.saveDataToItem(stack, level.registryAccess(), this);
        inventory.setItem(0, stack);
        Containers.dropContents(Objects.requireNonNull(this.getLevel()), this.worldPosition, inventory);
        changePotion(ItemStack.EMPTY);
        markUpdated();
    }

    @Override
    protected void loadAdditional(@NotNull ValueInput input) {
        super.loadAdditional(input);
        clearContent();
        this.foodItem = input.read(STORAGE_NAME+ "_food", ItemStack.CODEC).orElse(ItemStack.EMPTY);
        this.potionItem = input.read(STORAGE_NAME+ "_potion", ItemStack.CODEC).orElse(ItemStack.EMPTY);
    }

    @Override
    protected void saveAdditional(@NotNull ValueOutput output) {
        super.saveAdditional(output);
        if (!getFoodStack().isEmpty()) output.store(STORAGE_NAME + "_food", ItemStack.CODEC, getFoodStack());
        if (!getPotionStack().isEmpty()) output.store(STORAGE_NAME + "_potion", ItemStack.CODEC, getPotionStack());
    }

    @Override
    public ItemStack getTheItem() {
        return foodItem;
    }

    @Override
    public void setTheItem(ItemStack itemStack) {
        changeFood(itemStack);
    }

    @Override
    public void clearContent() {
        this.foodItem = ItemStack.EMPTY;
        this.potionItem = ItemStack.EMPTY;
    }

    @Override
    public Packet<@NotNull ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.@NotNull Provider registries) {
        CompoundTag tag;
        try (ProblemReporter.ScopedCollector reporter = new ProblemReporter.ScopedCollector(this.problemPath(), LOGGER)) {
            TagValueOutput output = TagValueOutput.createWithContext(reporter, registries);
            if (!getFoodStack().isEmpty()) output.store(STORAGE_NAME + "_food", ItemStack.CODEC, getFoodStack());
            if (!getPotionStack().isEmpty()) output.store(STORAGE_NAME + "_potion", ItemStack.CODEC, getPotionStack());
            tag = output.buildResult();
        }
        return tag;
    }

    @Override
    public BlockEntity getContainerBlockEntity() {
        return this;
    }
}
