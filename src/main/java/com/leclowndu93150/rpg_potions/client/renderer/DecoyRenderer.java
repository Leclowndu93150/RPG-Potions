package com.leclowndu93150.rpg_potions.client.renderer;

import com.leclowndu93150.rpg_potions.entity.DecoyEntity;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class DecoyRenderer extends MobRenderer<DecoyEntity, PlayerModel<DecoyEntity>> {
    private final Map<String, ResourceLocation> skinCache = new ConcurrentHashMap<>();
    
    public DecoyRenderer(EntityRendererProvider.Context context) {
        super(context, new PlayerModel<>(context.bakeLayer(ModelLayers.PLAYER), false), 0.5F);
        this.addLayer(new HumanoidArmorLayer<>(this, 
            new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
            new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)),
            context.getModelManager()));
        this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
    }
    
    @Override
    public ResourceLocation getTextureLocation(DecoyEntity entity) {
        UUID playerUUID = entity.getPlayerUUID();
        String playerName = entity.getPlayerSkin();
        
        if (playerUUID == null || playerName == null || playerName.isEmpty()) {
            return new ResourceLocation("minecraft", "textures/entity/player/wide/steve.png");
        }
        
        String cacheKey = playerUUID.toString();
        return skinCache.computeIfAbsent(cacheKey, uuid -> {
            try {
                GameProfile profile = new GameProfile(playerUUID, playerName);
                Minecraft mc = Minecraft.getInstance();
                mc.getSkinManager().registerSkins(profile, (type, location, texture) -> {
                    if (type == MinecraftProfileTexture.Type.SKIN) {
                        skinCache.put(cacheKey, location);
                    }
                }, true);
                
                ResourceLocation cached = skinCache.get(cacheKey);
                if (cached != null) {
                    return cached;
                }
                
                return new ResourceLocation("minecraft", "textures/entity/player/wide/steve.png");
            } catch (Exception e) {
                return new ResourceLocation("minecraft", "textures/entity/player/wide/steve.png");
            }
        });
    }
    
    @Override
    public void render(DecoyEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
