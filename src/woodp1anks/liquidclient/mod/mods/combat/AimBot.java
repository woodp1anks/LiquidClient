package woodp1anks.liquidclient.mod.mods.combat;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import woodp1anks.liquidclient.mod.Category;
import woodp1anks.liquidclient.mod.Mod;
import woodp1anks.liquidclient.utils.RotationUtil;

public class AimBot extends Mod {
    private double range;
    private boolean onlyOnClick;
    private boolean antiBotPractice;

    public AimBot() {
        super("AimBot", Category.Combat);
    }

    @Override
    public void update() {
        EntityLivingBase target = null;

        for (Entity entity : Minecraft.getMinecraft().theWorld.loadedEntityList) {
            if (entity instanceof EntityLivingBase) {
                EntityLivingBase livingBase = (EntityLivingBase) entity;
                if (livingBase != Minecraft.getMinecraft().thePlayer && !entity.isDead && Minecraft.getMinecraft().thePlayer.getDistanceToEntity(livingBase) <= range && livingBase.getHealth() > 0) {
                    boolean isTarget = true;
                    if (antiBotPractice) {
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

                    if (target == null) {
                        target = livingBase;
                    }

                    if (isTarget && Minecraft.getMinecraft().thePlayer.getDistanceToEntity(livingBase) < Minecraft.getMinecraft().thePlayer.getDistanceToEntity(target)) {
                        target = livingBase;
                    }
                }
            }
        }

        if (onlyOnClick && Minecraft.getMinecraft().gameSettings.keyBindAttack.isKeyDown() && target != null) {
            Minecraft.getMinecraft().thePlayer.rotationYaw = RotationUtil.getRotationsYaw(target.posX, target.posZ);
            Minecraft.getMinecraft().thePlayer.rotationPitch = RotationUtil.getRotationsPitch(target.posX,target.posY,target.posZ);
        } else if (!onlyOnClick && target != null){
            Minecraft.getMinecraft().thePlayer.rotationYaw = RotationUtil.getRotationsYaw(target.posX, target.posZ);
            Minecraft.getMinecraft().thePlayer.rotationPitch = RotationUtil.getRotationsPitch(target.posX,target.posY,target.posZ);

        }
    }

    public double getRange() {
        return range;
    }

    public boolean isOnlyOnClick() {
        return onlyOnClick;
    }

    public boolean isAntiBotPracticeEnabled() {
        return antiBotPractice;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public void setOnlyOnClick(boolean onlyOnClick) {
        this.onlyOnClick = onlyOnClick;
    }

    public void setAntiBotPractice(boolean antiBotPractice) {
        this.antiBotPractice = antiBotPractice;
    }
}
