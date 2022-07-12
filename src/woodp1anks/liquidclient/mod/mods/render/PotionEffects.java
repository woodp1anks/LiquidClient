package woodp1anks.liquidclient.mod.mods.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import woodp1anks.liquidclient.mod.Category;
import woodp1anks.liquidclient.mod.Mod;
import woodp1anks.liquidclient.utils.TimeUtil;

import java.awt.*;
import java.sql.Time;

public class PotionEffects extends Mod {

    private int startY;
    private int x;
    private int nameR;
    private int nameG;
    private int nameB;
    private int durationR;
    private int durationG;
    private int durationB;

    public PotionEffects() {
        super("PotionEffects", Category.Render);
    }

    @Override
    public void draw() {
        int y = startY;

        for (PotionEffect potionEffect : Minecraft.getMinecraft().thePlayer.getActivePotionEffects()) {
            FontRenderer font = Minecraft.getMinecraft().fontRendererObj;

            Minecraft.getMinecraft().getTextureManager().bindTexture(GuiContainer.inventoryBackground);

            String durationText = TimeUtil.getAsMinute(potionEffect.getDuration()) + ":" + TimeUtil.getAsSecond(potionEffect.getDuration());

            font.drawStringWithShadow(potionEffect.getEffectName() + " " + potionEffect.getAmplifier(),x,y,new Color(nameR,nameG,nameB).getRGB());

            y+= font.FONT_HEIGHT + 1;

            font.drawStringWithShadow(durationText,x,y,new Color(durationR,durationG,durationB).getRGB());

            y+= font.FONT_HEIGHT + 7;


        }
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setDurationB(int durationB) {
        this.durationB = durationB;
    }

    public void setDurationG(int durationG) {
        this.durationG = durationG;
    }

    public void setDurationR(int durationR) {
        this.durationR = durationR;
    }

    public void setNameB(int nameB) {
        this.nameB = nameB;
    }

    public void setNameG(int nameG) {
        this.nameG = nameG;
    }

    public void setNameR(int nameR) {
        this.nameR = nameR;
    }

    public int getStartY() {
        return startY;
    }

    public int getX() {
        return x;
    }

    public int getDurationB() {
        return durationB;
    }

    public int getDurationG() {
        return durationG;
    }

    public int getDurationR() {
        return durationR;
    }

    public int getNameB() {
        return nameB;
    }

    public int getNameG() {
        return nameG;
    }

    public int getNameR() {
        return nameR;
    }

}

