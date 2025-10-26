package com.leclowndu93150.rpg_potions.entity;

import com.leclowndu93150.rpg_potions.init.ModEntities;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import java.util.UUID;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DecoyEntity extends PathfinderMob {
    private static final EntityDataAccessor<String> PLAYER_NAME = SynchedEntityData.defineId(DecoyEntity.class, EntityDataSerializers.STRING);
    private static final EntityDataAccessor<String> PLAYER_SKIN = SynchedEntityData.defineId(DecoyEntity.class, EntityDataSerializers.STRING);
    private static final EntityDataAccessor<String> PLAYER_UUID = SynchedEntityData.defineId(DecoyEntity.class, EntityDataSerializers.STRING);
    private int lifeTicks = 0;
    private final NonNullList<ItemStack> armorItems = NonNullList.withSize(4, ItemStack.EMPTY);
    private final NonNullList<ItemStack> handItems = NonNullList.withSize(2, ItemStack.EMPTY);
    private final NonNullList<ItemStack> inventoryItems = NonNullList.withSize(41, ItemStack.EMPTY);
    
    public DecoyEntity(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
    }
    
    public DecoyEntity(Level level, Player player) {
        super(ModEntities.DECOY.get(), level);
        this.entityData.set(PLAYER_NAME, player.getName().getString());
        this.entityData.set(PLAYER_SKIN, player.getGameProfile().getName());
        this.entityData.set(PLAYER_UUID, player.getUUID().toString());
        this.setCustomName(player.getName());
        this.setCustomNameVisible(false);
        
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            ItemStack item = player.getItemBySlot(slot).copy();
            if (slot.getType() == EquipmentSlot.Type.HAND) {
                this.handItems.set(slot.getIndex(), item);
            } else if (slot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR) {
                this.armorItems.set(slot.getIndex(), item);
            }
        }
        
        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            this.inventoryItems.set(i, player.getInventory().getItem(i).copy());
        }
    }
    
    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(PLAYER_NAME, "");
        builder.define(PLAYER_SKIN, "");
        builder.define(PLAYER_UUID, "");
    }
    
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1.0));
    }
    
    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0)
                .add(Attributes.MOVEMENT_SPEED, 0.25)
                .add(Attributes.ARMOR, 0.0)
                .add(Attributes.FOLLOW_RANGE, 16.0);
    }
    
    @Override
    public void tick() {
        super.tick();
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("LifeTicks", lifeTicks);
        compound.putString("PlayerName", this.entityData.get(PLAYER_NAME));
        compound.putString("PlayerSkin", this.entityData.get(PLAYER_SKIN));
        compound.putString("PlayerUUID", this.entityData.get(PLAYER_UUID));
        
        ListTag armorList = new ListTag();
        for (ItemStack stack : this.armorItems) {
            if (!stack.isEmpty()) {
                armorList.add(stack.save(this.registryAccess()));
            } else {
                armorList.add(new CompoundTag());
            }
        }
        compound.put("ArmorItems", armorList);
        
        ListTag handList = new ListTag();
        for (ItemStack stack : this.handItems) {
            if (!stack.isEmpty()) {
                handList.add(stack.save(this.registryAccess()));
            } else {
                handList.add(new CompoundTag());
            }
        }
        compound.put("HandItems", handList);
        
        ListTag inventoryList = new ListTag();
        for (ItemStack stack : this.inventoryItems) {
            if (!stack.isEmpty()) {
                inventoryList.add(stack.save(this.registryAccess()));
            } else {
                inventoryList.add(new CompoundTag());
            }
        }
        compound.put("InventoryItems", inventoryList);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        lifeTicks = compound.getInt("LifeTicks");
        this.entityData.set(PLAYER_NAME, compound.getString("PlayerName"));
        this.entityData.set(PLAYER_SKIN, compound.getString("PlayerSkin"));
        this.entityData.set(PLAYER_UUID, compound.getString("PlayerUUID"));
        
        if (compound.contains("ArmorItems", 9)) {
            ListTag armorList = compound.getList("ArmorItems", 10);
            for (int i = 0; i < armorList.size() && i < this.armorItems.size(); i++) {
                this.armorItems.set(i, ItemStack.parse(this.registryAccess(), armorList.getCompound(i)).orElse(ItemStack.EMPTY));
            }
        }
        
        if (compound.contains("HandItems", 9)) {
            ListTag handList = compound.getList("HandItems", 10);
            for (int i = 0; i < handList.size() && i < this.handItems.size(); i++) {
                this.handItems.set(i, ItemStack.parse(this.registryAccess(), handList.getCompound(i)).orElse(ItemStack.EMPTY));
            }
        }
        
        if (compound.contains("InventoryItems", 9)) {
            ListTag inventoryList = compound.getList("InventoryItems", 10);
            for (int i = 0; i < inventoryList.size() && i < this.inventoryItems.size(); i++) {
                this.inventoryItems.set(i, ItemStack.parse(this.registryAccess(), inventoryList.getCompound(i)).orElse(ItemStack.EMPTY));
            }
        }
    }
    
    public String getPlayerName() {
        return this.entityData.get(PLAYER_NAME);
    }
    
    public String getPlayerSkin() {
        return this.entityData.get(PLAYER_SKIN);
    }
    
    public UUID getPlayerUUID() {
        String uuidStr = this.entityData.get(PLAYER_UUID);
        if (uuidStr == null || uuidStr.isEmpty()) {
            return null;
        }
        try {
            return UUID.fromString(uuidStr);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
    
    @Override
    public ItemStack getItemBySlot(EquipmentSlot slot) {
        if (slot.getType() == EquipmentSlot.Type.HAND) {
            return this.handItems.get(slot.getIndex());
        } else if (slot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR) {
            return this.armorItems.get(slot.getIndex());
        }
        return ItemStack.EMPTY;
    }
    
    @Override
    public void setItemSlot(EquipmentSlot slot, ItemStack stack) {
        if (slot.getType() == EquipmentSlot.Type.HAND) {
            this.handItems.set(slot.getIndex(), stack);
        } else if (slot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR) {
            this.armorItems.set(slot.getIndex(), stack);
        }
    }
    
    public NonNullList<ItemStack> getArmorItems() {
        return this.armorItems;
    }
    
    public NonNullList<ItemStack> getHandItems() {
        return this.handItems;
    }
    
    public NonNullList<ItemStack> getInventoryItems() {
        return this.inventoryItems;
    }
}
