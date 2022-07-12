package woodp1anks.liquidclient.target;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class TargetManager {
    private EntityLivingBase target;

    private boolean disablePracticeBot;

    public void update() {
        if (target != null) {
            if ((target.getHealth() < 0) || target.isDead || Minecraft.getMinecraft().thePlayer.getDistanceToEntity(target) > 3) {
                target = null;
            }
        }
        for (Entity entity : Minecraft.getMinecraft().theWorld.loadedEntityList) {
            if (entity instanceof EntityLivingBase) {
                EntityLivingBase livingBase = (EntityLivingBase) entity;
                if (livingBase != Minecraft.getMinecraft().thePlayer && !(livingBase.getHealth() < 0) && !livingBase.isDead && Minecraft.getMinecraft().thePlayer.getDistanceToEntity(entity) < 3) {
                    boolean isTarget = true;
                    if (disablePracticeBot) {
                        EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;

                        ItemStack botHelmet = livingBase.getCurrentArmor(3);
                        ItemStack selfHelmet = player.getCurrentArmor(3);

                        ItemStack botChestPlate = livingBase.getCurrentArmor(2);
                        ItemStack selfChestPlate = player.getCurrentArmor(2);

                        ItemStack botLeggings = livingBase.getCurrentArmor(1);
                        ItemStack selfLeggings = player.getCurrentArmor(1);

                        ItemStack botBoots = livingBase.getCurrentArmor(0);
                        ItemStack selfBoots = player.getCurrentArmor(0);

                        int botHelmetID = botHelmet == null ? 0 : Item.getIdFromItem(botHelmet.getItem());
                        int selfHelmetID = selfHelmet == null ? 0 : Item.getIdFromItem(selfHelmet.getItem());

                        int botChestPlateID = botChestPlate == null ? 0 : Item.getIdFromItem(botChestPlate.getItem());
                        int selfChestPlateID = selfChestPlate == null ? 0 : Item.getIdFromItem(selfChestPlate.getItem());

                        int botLeggingsID = botLeggings == null ? 0 : Item.getIdFromItem(botLeggings.getItem());
                        int selfLeggingsID = selfLeggings == null ? 0 : Item.getIdFromItem(selfLeggings.getItem());

                        int botBootsID = botBoots == null ? 0 : Item.getIdFromItem(botBoots.getItem());
                        int selfBootsID = selfBoots == null ? 0 : Item.getIdFromItem(selfBoots.getItem());

                        if (botHelmetID != selfHelmetID || botChestPlateID != selfChestPlateID || botLeggingsID != selfLeggingsID || botBootsID != selfBootsID) {
                            isTarget = false;
                        }
                    }

                    if (target != null) {
                        if (isTarget && Minecraft.getMinecraft().thePlayer.getDistanceToEntity(livingBase) < Minecraft.getMinecraft().thePlayer.getDistanceToEntity(target)) {
                            target = livingBase;
                        }
                    } else {
                        if (isTarget) {
                            target = livingBase;
                        }
                    }
                    if (!isTarget) {
                        target = null;
                    }
                }
            }
        }
    }

    public EntityLivingBase getTarget() {
        return target;
    }

    public boolean isDisablePracticeBot() {
        return disablePracticeBot;
    }

    public void setDisablePracticeBot(boolean disablePracticeBot) {
        this.disablePracticeBot = disablePracticeBot;
    }
}
