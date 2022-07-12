package woodp1anks.liquidclient.mod.mods.combat;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C03PacketPlayer;
import woodp1anks.liquidclient.LiquidClient;
import woodp1anks.liquidclient.mod.Category;
import woodp1anks.liquidclient.mod.Mod;
import woodp1anks.liquidclient.utils.RotationUtil;

import java.util.Random;

public class KillAura extends Mod {
    private boolean antiBotPractice;
    private boolean serverSlideRotation;
    private int minCps;
    private int maxCps;

    private int ticks;

    public KillAura() {
        super("KillAura", Category.Combat);
    }

    @Override
    public void render() {
        int cps = minCps + new Random().nextInt(maxCps - minCps);

        int hitTime = 20 / cps;

        EntityLivingBase target = LiquidClient.targetManager.getTarget();



        if (serverSlideRotation && target != null) {
            Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C05PacketPlayerLook(RotationUtil.getRotationsYaw(target.posX, target.posZ),RotationUtil.getRotationsPitch(target.posX,target.posY,target.posZ),Minecraft.getMinecraft().thePlayer.onGround));
        } else {
            if (target != null) {
                Minecraft.getMinecraft().thePlayer.rotationYaw = RotationUtil.getRotationsYaw(target.posX, target.posZ);
                Minecraft.getMinecraft().thePlayer.rotationPitch = RotationUtil.getRotationsPitch(target.posX,target.posY,target.posZ);
            }
        }
        if (ticks >= hitTime && target != null) {
            Minecraft.getMinecraft().thePlayer.swingItem();
            Minecraft.getMinecraft().playerController.attackEntity(Minecraft.getMinecraft().thePlayer,target);
            ticks = 0;
        }

        ticks++;
    }

    public boolean isAntiBotPractice() {
        return antiBotPractice;
    }

    public boolean isServerSlideRotation() {
        return serverSlideRotation;
    }

    public int getMinCps() {
        return minCps;
    }

    public int getMaxCps() {
        return maxCps;
    }

    public void setAntiBotPractice(boolean antiBotPractice) {
        this.antiBotPractice = antiBotPractice;
    }

    public void setMinCps(int minCps) {
        this.minCps = minCps;
    }

    public void setMaxCps(int maxCps) {
        this.maxCps = maxCps;
    }

    public void setServerSlideRotation(boolean serverSlideRotation) {
        this.serverSlideRotation = serverSlideRotation;
    }
}
