package woodp1anks.liquidclient.mod.mods.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import org.lwjgl.input.Keyboard;
import woodp1anks.liquidclient.LiquidClient;
import woodp1anks.liquidclient.mod.Category;
import woodp1anks.liquidclient.mod.Mod;

import java.awt.*;

public class TabGUI extends Mod {

    private int currentCategory = 0;
    private int currentMod;
    private boolean modTabVisible = false;

    public TabGUI() {
        super("TabGUI", Category.RENDER);
    }

    @Override
    public void draw() {
        drawTab(5,26);
    }

    @Override
    public void onKeyPressed(int key) {
        if (key == Keyboard.KEY_UP) {
            if (currentCategory > 0 && !modTabVisible) {
                currentCategory--;
            }
            if (modTabVisible) {
                if (currentMod > 0) {
                    currentMod--;
                }
            }
        } else if (key == Keyboard.KEY_DOWN) {
            if (currentCategory < Category.values().length - 1 && !modTabVisible) {
                currentCategory++;
            }
            if (modTabVisible) {
                if (currentMod < LiquidClient.modManager.getMods(Category.values()[currentCategory]).size() - 1) {
                    currentMod++;
                }
            }
        } else if (key == Keyboard.KEY_RETURN || key == Keyboard.KEY_RIGHT) {
            if (modTabVisible) {
                LiquidClient.modManager.getMods(Category.values()[currentCategory]).get(currentMod).setEnabled(!LiquidClient.modManager.getMods(Category.values()[currentCategory]).get(currentMod).isEnabled());
            }
            modTabVisible = true;
        } else if (key == Keyboard.KEY_LEFT) {
            modTabVisible = false;
            currentMod = 0;
        }
    }

    private void drawTab(int x, int y) {
        FontRenderer font = Minecraft.getMinecraft().fontRendererObj;
        String maxLengthCategoryName = "";
        for (Category category : Category.values()) {
            if (maxLengthCategoryName.length() < category.name().length()) {
                maxLengthCategoryName = category.name();
            }
        }
        Gui.drawRect(x,y,x + font.getStringWidth(maxLengthCategoryName),y + Category.values().length * font.FONT_HEIGHT,Color.LIGHT_GRAY.getRGB());
        int fontY = y;
        int i = 0;
        for (Category value : Category.values()) {
            if (i == currentCategory) {
                Gui.drawRect(x,fontY,x + font.getStringWidth(maxLengthCategoryName),y + (font.FONT_HEIGHT * currentCategory + 1) + font.FONT_HEIGHT,Color.GRAY.getRGB());
            }
            font.drawStringWithShadow(value.name(),x,fontY, LiquidClient.MAIN_COLOR.getRGB());
            fontY += font.FONT_HEIGHT;
            i++;
        }
        if (modTabVisible) {
            String maxLengthModName = "";
            for (Mod mod : LiquidClient.modManager.getMods(Category.values()[currentCategory])) {
                if (font.getStringWidth(maxLengthModName) < font.getStringWidth(mod.getName())) {
                    maxLengthModName = mod.getName();
                }
            }
            int fontY1 = y + (currentCategory) * font.FONT_HEIGHT;
            Gui.drawRect(x + font.getStringWidth(maxLengthCategoryName) + 3,fontY1,x + font.getStringWidth(maxLengthCategoryName) + 3 + font.getStringWidth(maxLengthModName),fontY1 + LiquidClient.modManager.getMods(Category.values()[currentCategory]).size() * font.FONT_HEIGHT,Color.LIGHT_GRAY.getRGB());
            int i1 = 0;
            for (Mod mod : LiquidClient.modManager.getMods(Category.values()[currentCategory])) {
                if (i1 == currentMod) {
                    Gui.drawRect(x + font.getStringWidth(maxLengthCategoryName) + 3,fontY1,x + font.getStringWidth(maxLengthCategoryName) + 3 + font.getStringWidth(maxLengthModName),fontY1 + font.FONT_HEIGHT,Color.GRAY.getRGB());
                }
                boolean enabled = mod.isEnabled();
                font.drawStringWithShadow(mod.getName(),x + font.getStringWidth(maxLengthCategoryName) + 3,fontY1,enabled ? new Color(140,255,140).getRGB() : new Color(255,80,80).getRGB());
                fontY1 += font.FONT_HEIGHT;
                i1++;
            }
        }
    }
}
