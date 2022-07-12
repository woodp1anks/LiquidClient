package woodp1anks.liquidclient.mod.mods.combat;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import woodp1anks.liquidclient.LiquidClient;
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
    public void render() {
        EntityLivingBase target = LiquidClient.targetManager.getTarget();

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
