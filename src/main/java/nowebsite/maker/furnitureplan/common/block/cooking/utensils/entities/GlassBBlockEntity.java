package nowebsite.maker.furnitureplan.common.block.cooking.utensils.entities;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
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
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import nowebsite.maker.furnitureplan.common.item.GlassBBlockItem;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.util.Objects;

public class GlassBBlockEntity extends BlockEntity implements HasGlassEntity {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String STORAGE_NAME = "inventory";
    private ItemStack item = ItemStack.EMPTY;
    
    public GlassBBlockEntity(BlockPos pos, BlockState state) {
        super(FPBlockReg.GLASS_B_BLOCK_ENTITY.get(), pos, state);
    }

    /**You can't change this*/
    public ItemStack getPotionStack(){
        return item.copy();
    }

    public boolean usePotion(Player player){
        if (getPotionStack().isEmpty()) return false;
        PotionContents potioncontents = getPotionStack().getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
        potioncontents.forEachEffect(effect -> {
            if (level instanceof ServerLevel serverLevel && effect.getEffect().value().isInstantenous()) {
                effect.getEffect().value().applyInstantenousEffect(serverLevel, null, null, player, effect.getAmplifier(), 1.0);
            } else {
                player.addEffect(effect);
            }
        }, 1.2f);
        changePotion(ItemStack.EMPTY);
        if (this.level != null) {
            this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of(player, this.getBlockState()));
        }
        markUpdated();
        return true;
    }

    public boolean restorePotion(Player player, @NotNull ItemStack stack){
        if (!stack.is(Items.GLASS_BOTTLE) || getPotionStack().isEmpty()) return false;
        stack.shrink(1);
        if (player.getInventory().getFreeSlot() != -1) player.getInventory().add(getPotionStack());
        else player.drop(getPotionStack(), false,false);
        changePotion(ItemStack.EMPTY);
        if (this.level != null) {
            this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of(player, this.getBlockState()));
        }
        markUpdated();
        return true;
    }

    public boolean fillPotion(Entity entity, ItemStack stack) {
        if (!getPotionStack().isEmpty()) return false;
        this.changePotion(stack.split(1));
        if (entity instanceof Player player && !player.getAbilities().instabuild) {
            if (player.getInventory().getFreeSlot() != -1) {
                player.getInventory().add(new ItemStack(Items.GLASS_BOTTLE));
                player.getInventory().setChanged();
            }
            else player.drop(new ItemStack(Items.GLASS_BOTTLE), false,false);
        }
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

    public void changePotion(ItemStack stack){
        item = stack;
    }

    @Override
    public void preRemoveSideEffects(BlockPos pos, BlockState state) {
        this.dropBottle();
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
        this.item = input.read(STORAGE_NAME, ItemStack.CODEC).orElse(ItemStack.EMPTY);
    }

    @Override
    protected void saveAdditional(@NotNull ValueOutput output) {
        super.saveAdditional(output);
        if (!getPotionStack().isEmpty()) output.store(STORAGE_NAME, ItemStack.CODEC, getPotionStack());
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public void clearContent() {
        this.item = ItemStack.EMPTY;
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.@NotNull Provider registries) {
        CompoundTag tag;
        try (ProblemReporter.ScopedCollector reporter = new ProblemReporter.ScopedCollector(this.problemPath(), LOGGER)) {
            TagValueOutput output = TagValueOutput.createWithContext(reporter, registries);
            if (!getPotionStack().isEmpty()) {
                output.store(STORAGE_NAME, ItemStack.CODEC, getPotionStack());
            }
            tag = output.buildResult();
        }
        return tag;
    }

}
