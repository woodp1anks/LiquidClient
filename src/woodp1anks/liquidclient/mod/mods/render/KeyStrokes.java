package woodp1anks.liquidclient.mod.mods.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Keyboard;
import woodp1anks.liquidclient.mod.Category;
import woodp1anks.liquidclient.mod.Mod;

import java.awt.*;

public class KeyStrokes extends Mod {

    private boolean forwardPressed;
    private boolean backwardPressed;
    private boolean leftPressed;
    private boolean rightPressed;
    private boolean LMBPressed;
    private boolean RMBPressed;

    private int forwardX;
    private int forwardY;
    private int backwardX;
    private int backwardY;
    private int leftX;
    private int leftY;
    private int rightX;
    private int rightY;
    private int LMBx;
    private int LMBy;
    private int RMBx;
    private int RMBy;

    public KeyStrokes() {
        super("KeyStrokes", Category.Render);
    }

    @Override
    public void draw() {

        if (Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown()) {
            forwardPressed = true;
        } else {forwardPressed = false;}
        if (Minecraft.getMinecraft().gameSettings.keyBindBack.isKeyDown()) {
            backwardPressed = true;
        } else {backwardPressed = false;}
        if (Minecraft.getMinecraft().gameSettings.keyBindLeft.isKeyDown()) {
            leftPressed = true;
        } else {leftPressed = false;}
        if (Minecraft.getMinecraft().gameSettings.keyBindRight.isKeyDown()) {
            rightPressed = true;
        } else {rightPressed = false;}
        LMBPressed = Minecraft.getMinecraft().gameSettings.keyBindAttack.isKeyDown();
        if (Minecraft.getMinecraft().gameSettings.keyBindUseItem.isKeyDown()) {
            RMBPressed = true;
        } else {RMBPressed = false;}

        ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
        int width = scaledResolution.getScaledWidth();
        int height = scaledResolution.getScaledHeight();

        FontRenderer font = Minecraft.getMinecraft().fontRendererObj;

        forwardX = backwardX;
        forwardY = height - 68;
        leftX = width / 2 - 159;
        leftY = height - 45;
        backwardX = width / 2 - 136;
        backwardY = height - 45;
        rightX = width / 2 - 113;
        rightY = height - 45;
        LMBx = width / 2 - 159;
        LMBy = height - 22;
        RMBx = width / 2 - 125;
        RMBy = height - 22;

        String forwardText = Keyboard.getKeyName(Minecraft.getMinecraft().gameSettings.keyBindForward.getKeyCode());
        String backwardText = Keyboard.getKeyName(Minecraft.getMinecraft().gameSettings.keyBindBack.getKeyCode());
        String leftText = Keyboard.getKeyName(Minecraft.getMinecraft().gameSettings.keyBindLeft.getKeyCode());
        String rightText = Keyboard.getKeyName(Minecraft.getMinecraft().gameSettings.keyBindRight.getKeyCode());

        Gui.drawRect(forwardX,forwardY,forwardX + 20,forwardY + 20,forwardPressed ? Color.GRAY.getRGB() : Color.LIGHT_GRAY.getRGB());
        Gui.drawRect(leftX,leftY,leftX + 20,leftY + 20,leftPressed ? Color.GRAY.getRGB() : Color.LIGHT_GRAY.getRGB());
        Gui.drawRect(backwardX,backwardY,backwardX + 20,backwardY + 20,backwardPressed ? Color.GRAY.getRGB() : Color.LIGHT_GRAY.getRGB());
        Gui.drawRect(rightX,rightY,rightX + 20,rightY + 20,rightPressed ? Color.GRAY.getRGB() : Color.LIGHT_GRAY.getRGB());
        Gui.drawRect(LMBx,LMBy,LMBx + 32,LMBy + 20,LMBPressed ? Color.GRAY.getRGB() : Color.LIGHT_GRAY.getRGB());
        Gui.drawRect(RMBx,RMBy,RMBx + 32,RMBy + 20,RMBPressed ? Color.GRAY.getRGB() : Color.LIGHT_GRAY.getRGB());

        font.drawStringWithShadow(forwardText,forwardX + 10 - font.getStringWidth(forwardText) / 2,forwardY + 10 - font.FONT_HEIGHT / 2,forwardPressed ? Color.LIGHT_GRAY.getRGB() : Color.WHITE.getRGB());
        font.drawStringWithShadow(leftText,leftX + 10 - font.getStringWidth(leftText) / 2,leftY + 10 - font.FONT_HEIGHT / 2,leftPressed ? Color.LIGHT_GRAY.getRGB() : Color.WHITE.getRGB());
        font.drawStringWithShadow(backwardText,backwardX + 10 - font.getStringWidth(backwardText) / 2,backwardY + 10 - font.FONT_HEIGHT / 2,backwardPressed ? Color.LIGHT_GRAY.getRGB() : Color.WHITE.getRGB());
        font.drawStringWithShadow(rightText,rightX + 10 - font.getStringWidth(rightText) / 2,rightY + 10 - font.FONT_HEIGHT / 2,rightPressed ? Color.LIGHT_GRAY.getRGB() : Color.WHITE.getRGB());
        font.drawStringWithShadow("LMB",LMBx + 15 - font.getStringWidth("LMB") / 2,RMBy + 10 - font.FONT_HEIGHT / 2,LMBPressed ? Color.LIGHT_GRAY.getRGB() : Color.WHITE.getRGB());
        font.drawStringWithShadow("RMB",RMBx + 15 - font.getStringWidth("RMB") / 2, RMBy + 10 - font.FONT_HEIGHT / 2,RMBPressed ? Color.LIGHT_GRAY.getRGB() : Color.WHITE.getRGB());

    }
}
