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

    private int pressedBgR;
    private int pressedBgG;
    private int pressedBgB;
    private int backgroundR;
    private int backgroundG;
    private int backgroundB;
    private int textR;
    private int textG;
    private int textB;
    private int pressedTextR;
    private int pressedTextG;
    private int pressedTextB;

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

        int backgroundColor = new Color(backgroundR,backgroundG,backgroundB).getRGB();
        int pressedBgColor = new Color(pressedBgR,pressedBgG,pressedBgB).getRGB();
        int textColor = new Color(textR,textG,textB).getRGB();
        int pressedTextColor = new Color(pressedTextR,pressedTextG,pressedTextB).getRGB();

        String forwardText = Keyboard.getKeyName(Minecraft.getMinecraft().gameSettings.keyBindForward.getKeyCode());
        String backwardText = Keyboard.getKeyName(Minecraft.getMinecraft().gameSettings.keyBindBack.getKeyCode());
        String leftText = Keyboard.getKeyName(Minecraft.getMinecraft().gameSettings.keyBindLeft.getKeyCode());
        String rightText = Keyboard.getKeyName(Minecraft.getMinecraft().gameSettings.keyBindRight.getKeyCode());

        Gui.drawRect(forwardX,forwardY,forwardX + 20,forwardY + 20,forwardPressed ? pressedBgColor : backgroundColor);
        Gui.drawRect(leftX,leftY,leftX + 20,leftY + 20,leftPressed ? pressedBgColor : backgroundColor);
        Gui.drawRect(backwardX,backwardY,backwardX + 20,backwardY + 20,backwardPressed ? pressedBgColor : backgroundColor);
        Gui.drawRect(rightX,rightY,rightX + 20,rightY + 20,rightPressed ? pressedBgColor : backgroundColor);
        Gui.drawRect(LMBx,LMBy,LMBx + 32,LMBy + 20,LMBPressed ? pressedBgColor : backgroundColor);
        Gui.drawRect(RMBx,RMBy,RMBx + 32,RMBy + 20,RMBPressed ? pressedBgColor : backgroundColor);

        font.drawStringWithShadow(forwardText,forwardX + 10 - font.getStringWidth(forwardText) / 2,forwardY + 10 - font.FONT_HEIGHT / 2,forwardPressed ? pressedTextColor : textColor);
        font.drawStringWithShadow(leftText,leftX + 10 - font.getStringWidth(leftText) / 2,leftY + 10 - font.FONT_HEIGHT / 2,leftPressed ? pressedTextColor : textColor);
        font.drawStringWithShadow(backwardText,backwardX + 10 - font.getStringWidth(backwardText) / 2,backwardY + 10 - font.FONT_HEIGHT / 2,backwardPressed ? pressedTextColor : textColor);
        font.drawStringWithShadow(rightText,rightX + 10 - font.getStringWidth(rightText) / 2,rightY + 10 - font.FONT_HEIGHT / 2,rightPressed ? pressedTextColor : textColor);
        font.drawStringWithShadow("LMB",LMBx + 15 - font.getStringWidth("LMB") / 2,RMBy + 10 - font.FONT_HEIGHT / 2,LMBPressed ? pressedTextColor : textColor);
        font.drawStringWithShadow("RMB",RMBx + 15 - font.getStringWidth("RMB") / 2, RMBy + 10 - font.FONT_HEIGHT / 2,RMBPressed ? pressedTextColor : textColor);

    }

    public void setBackgroundR(int backgroundR) {
        this.backgroundR = backgroundR;
    }

    public void setBackgroundG(int backgroundG) {
        this.backgroundG = backgroundG;
    }

    public void setBackgroundB(int backgroundB) {
        this.backgroundB = backgroundB;
    }

    public int getPressedBgR() {
        return pressedBgR;
    }

    public int getPressedBgG() {
        return pressedBgG;
    }

    public int getPressedBgB() {
        return pressedBgB;
    }

    public void setPressedBgR(int pressedBgR) {
        this.pressedBgR = pressedBgR;
    }

    public void setPressedBgG(int pressedBgG) {
        this.pressedBgG = pressedBgG;
    }

    public void setPressedBgB(int pressedBgB) {
        this.pressedBgB = pressedBgB;
    }

    public int getBackgroundR() {
        return backgroundR;
    }

    public int getBackgroundG() {
        return backgroundG;
    }

    public int getBackgroundB() {
        return backgroundB;
    }

    public int getTextR() {
        return textR;
    }

    public int getPressedTextG() {
        return pressedTextG;
    }

    public int getPressedTextB() {
        return pressedTextB;
    }

    public void setTextR(int textR) {
        this.textR = textR;
    }

    public int getPressedTextR() {
        return pressedTextR;
    }

    public void setPressedTextR(int pressedTextR) {
        this.pressedTextR = pressedTextR;
    }

    public int getTextG() {
        return textG;
    }

    public int getTextB() {
        return textB;
    }

    public void setPressedTextG(int pressedTextG) {
        this.pressedTextG = pressedTextG;
    }

    public void setTextG(int textG) {
        this.textG = textG;
    }

    public void setPressedTextB(int pressedTextB) {
        this.pressedTextB = pressedTextB;
    }

    public void setTextB(int textB) {
        this.textB = textB;
    }
}
