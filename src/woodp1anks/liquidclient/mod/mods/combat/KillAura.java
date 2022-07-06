package woodp1anks.liquidclient.mod.mods.combat;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.MathHelper;
import woodp1anks.liquidclient.mod.Category;
import woodp1anks.liquidclient.mod.Mod;
import woodp1anks.liquidclient.utils.RotationUtil;

public class KillAura extends Mod {
    public KillAura() {
        super("KillAura", Category.Combat);
    }

    @Override
    public void update() {
        for (Entity entity : Minecraft.getMinecraft().theWorld.loadedEntityList) {
            if (entity instanceof EntityLivingBase) {
                EntityLivingBase livingBase = (EntityLivingBase) entity;
                if (!(livingBase == Minecraft.getMinecraft().thePlayer) && !entity.isDead && entity.getDistanceToEntity(Minecraft.getMinecraft().thePlayer) <= 3 && livingBase.getHealth() > 0) {
                    Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C05PacketPlayerLook(RotationUtil.getRotationsYaw(livingBase.posX,livingBase.posY,livingBase.posZ),RotationUtil.getRotationsPitch(livingBase.posX,livingBase.posY,livingBase.posZ),Minecraft.getMinecraft().thePlayer.onGround));
                    Minecraft.getMinecraft().thePlayer.swingItem();
                    Minecraft.getMinecraft().playerController.attackEntity(Minecraft.getMinecraft().thePlayer,entity);
                    //Minecraft.getMinecraft().thePlayer.rotationYaw = getRotationsYaw(livingBase.posX,livingBase.posY,livingBase.posZ);
                    //Minecraft.getMinecraft().thePlayer.rotationPitch = livingBase.rayTrace(entity.getDistanceToEntity(Minecraft.getMinecraft().thePlayer),1.0F).getBlockPos().getY();
                }
            }
        }
    }
}
