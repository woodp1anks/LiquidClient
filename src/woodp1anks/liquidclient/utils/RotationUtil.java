package woodp1anks.liquidclient.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.MathHelper;

public class RotationUtil {
    public static float getRotationsYaw(double posX, double posZ) {
        EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
        double x = posX - player.posX;
        double z = posZ - player.posZ;
        return (float)(Math.atan2(z, x) * 180.0 / 3.141592653589793) - 90.0f;
    }

    public static float getRotationsPitch(double posX, double posY, double posZ) {
        EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
        double x = posX - player.posX;
        double y = posY - (player.posY + player.getEyeHeight() / 2);
        double z = posZ - player.posZ;
        double dist = MathHelper.sqrt_double(x * x + z * z);
        return (float)(-(Math.atan2(y, dist) * 180.0 / 3.141592653589793));
    }
}
