package woodp1anks.liquidclient.mod.mods.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import woodp1anks.liquidclient.mod.Category;
import woodp1anks.liquidclient.mod.Mod;

public class HitBox extends Mod {
    public HitBox() {
        super("HitBox", Category.Render);
    }

    @Override
    public void render() {
        for (Entity entity : Minecraft.getMinecraft().theWorld.loadedEntityList) {

            double renderPosX = Minecraft.getMinecraft().getRenderManager().renderPosX;
            double renderPosY = Minecraft.getMinecraft().getRenderManager().renderPosY;
            double renderPosZ = Minecraft.getMinecraft().getRenderManager().renderPosZ;

            if (!(entity.getName().equals(Minecraft.getMinecraft().thePlayer.getName()))) {
                AxisAlignedBB entityBoundingBox = entity.getEntityBoundingBox();
                RenderGlobal.func_181563_a(new AxisAlignedBB(
                        entityBoundingBox.minX - renderPosX,
                        entityBoundingBox.minY - renderPosY,
                        entityBoundingBox.minZ - renderPosZ,
                        entityBoundingBox.maxX - renderPosX,
                        entityBoundingBox.maxY - renderPosY,
                        entityBoundingBox.maxZ - renderPosZ
                ),255,255,255,255);
            }
        }
    }
}
