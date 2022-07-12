package woodp1anks.liquidclient.mod.mods.combat;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.network.play.client.C03PacketPlayer;
import woodp1anks.liquidclient.mod.Category;
import woodp1anks.liquidclient.mod.Mod;
import woodp1anks.liquidclient.utils.RotationUtil;

public class AntiFireball extends Mod {
    private boolean serverSlideRotation;

    public AntiFireball() {
        super("AntiFireball", Category.Combat);
    }

    @Override
    public void update() {
        for (Entity entity : Minecraft.getMinecraft().theWorld.loadedEntityList) {
            if (entity instanceof EntityFireball) {
                if (serverSlideRotation) {
                    Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C05PacketPlayerLook(RotationUtil.getRotationsYaw(entity.posX,entity.posZ),RotationUtil.getRotationsPitch(entity.posX,entity.posY,entity.posZ),Minecraft.getMinecraft().thePlayer.onGround));
                } else {
                    Minecraft.getMinecraft().thePlayer.rotationYaw = RotationUtil.getRotationsYaw(entity.posX,entity.posZ);
                    Minecraft.getMinecraft().thePlayer.rotationPitch = RotationUtil.getRotationsPitch(entity.posX,entity.posY,entity.posZ);
                }
                Minecraft.getMinecraft().thePlayer.swingItem();
                Minecraft.getMinecraft().playerController.attackEntity(Minecraft.getMinecraft().thePlayer,entity);
            }
        }
    }

    public boolean isRotationServerSlide() {
        return serverSlideRotation;
    }

    public void setServerSlideRotation(boolean serverSlideRotation) {
        this.serverSlideRotation = serverSlideRotation;
    }
}
