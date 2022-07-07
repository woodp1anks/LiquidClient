package woodp1anks.liquidclient.mod.mods.combat;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.util.MathHelper;
import woodp1anks.liquidclient.mod.Category;
import woodp1anks.liquidclient.mod.Mod;
import woodp1anks.liquidclient.utils.RotationUtil;

public class KillAura extends Mod {
    private boolean antiBotPractice;
    private boolean swingVisual;
    private boolean serverSlideRotation;
    private int cps;

    private int ticks;
    private int hitTime;

    public KillAura() {
        super("KillAura", Category.Combat);
    }

    @Override
    public void update() {
        hitTime = 20 / cps;
        for (Entity entity : Minecraft.getMinecraft().theWorld.loadedEntityList) {
            if (entity instanceof EntityLivingBase) {
                EntityLivingBase livingBase = (EntityLivingBase) entity;
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

                    if (botBoots != selfBoots || botHelmet != selfHelmet || botLeggings != selfLeggings || botChestPlate != selfChestPlate) {
                        isTarget = false;
                    }
                }
                if (!(livingBase == Minecraft.getMinecraft().thePlayer) && !entity.isDead && entity.getDistanceToEntity(Minecraft.getMinecraft().thePlayer) <= 3 && livingBase.getHealth() > 0 && isTarget) {
                    if (serverSlideRotation) {
                        Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C05PacketPlayerLook(RotationUtil.getRotationsYaw(livingBase.posX,livingBase.posY,livingBase.posZ),RotationUtil.getRotationsPitch(livingBase.posX,livingBase.posY,livingBase.posZ),Minecraft.getMinecraft().thePlayer.onGround));
                    } else {
                        Minecraft.getMinecraft().thePlayer.rotationYaw = RotationUtil.getRotationsYaw(livingBase.posX,livingBase.posY,livingBase.posZ);
                        Minecraft.getMinecraft().thePlayer.rotationPitch = RotationUtil.getRotationsPitch(livingBase.posX,livingBase.posY,livingBase.posZ);
                    }
                    if (ticks >= hitTime) {
                        if (swingVisual) {
                            ((EntityLivingBase) Minecraft.getMinecraft().thePlayer).swingItem();
                        }
                        Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C0APacketAnimation());
                        Minecraft.getMinecraft().playerController.attackEntity(Minecraft.getMinecraft().thePlayer,entity);
                        ticks = 0;
                    }
                }
            }
        }
        ticks++;
    }

    public boolean isAntiBotPractice() {
        return antiBotPractice;
    }

    public boolean isSwingVisual() {
        return swingVisual;
    }

    public boolean isServerSlideRotation() {
        return serverSlideRotation;
    }

    public int getCps() {
        return cps;
    }

    public void setAntiBotPractice(boolean antiBotPractice) {
        this.antiBotPractice = antiBotPractice;
    }

    public void setSwingVisual(boolean swingVisual) {
        this.swingVisual = swingVisual;
    }

    public void setCps(int cps) {
        this.cps = cps;
    }

    public void setServerSlideRotation(boolean serverSlideRotation) {
        this.serverSlideRotation = serverSlideRotation;
    }
}
