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

    private int backgroundR;
    private int backgroundG;
    private int backgroundB;
    private int selectedBgR;
    private int selectedBgG;
    private int selectedBGB;
    private int disabledR;
    private int disabledG;
    private int disabledB;
    private int enabledR;
    private int enabledG;
    private int enabledB;
    private int categoryR;
    private int categoryG;
    private int categoryB;

    private int currentCategory = 0;
    private int currentMod;
    private boolean modTabVisible = false;

    public TabGUI() {
        super("TabGUI", Category.Render);
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
        Gui.drawRect(x,y,x + font.getStringWidth(maxLengthCategoryName),y + Category.values().length * font.FONT_HEIGHT,new Color(backgroundR,backgroundG,backgroundB).getRGB());
        int fontY = y;
        int i = 0;
        for (Category value : Category.values()) {
            if (i == currentCategory) {
                Gui.drawRect(x,fontY,x + font.getStringWidth(maxLengthCategoryName),fontY + font.FONT_HEIGHT,new Color(selectedBgR,selectedBgG,selectedBGB).getRGB());
            }
            font.drawStringWithShadow(value.name(),x,fontY,new Color(categoryR,categoryG,categoryB).getRGB());
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
            Gui.drawRect(x + font.getStringWidth(maxLengthCategoryName) + 3,fontY1,x + font.getStringWidth(maxLengthCategoryName) + 3 + font.getStringWidth(maxLengthModName),fontY1 + LiquidClient.modManager.getMods(Category.values()[currentCategory]).size() * font.FONT_HEIGHT,new Color(backgroundR,backgroundG,backgroundB).getRGB());
            int i1 = 0;
            for (Mod mod : LiquidClient.modManager.getMods(Category.values()[currentCategory])) {
                if (i1 == currentMod) {
                    Gui.drawRect(x + font.getStringWidth(maxLengthCategoryName) + 3,fontY1,x + font.getStringWidth(maxLengthCategoryName) + 3 + font.getStringWidth(maxLengthModName),fontY1 + font.FONT_HEIGHT,new Color(selectedBgR,selectedBgG,selectedBGB).getRGB());
                }
                boolean enabled = mod.isEnabled();
                font.drawStringWithShadow(mod.getName(),x + font.getStringWidth(maxLengthCategoryName) + 3,fontY1,enabled ? new Color(enabledR,enabledG,enabledB).getRGB() : new Color(disabledR,disabledG,disabledB).getRGB());
                fontY1 += font.FONT_HEIGHT;
                i1++;
            }
        }
    }

    public int getBackgroundB() {
        return backgroundB;
    }

    public int getBackgroundR() {
        return backgroundR;
    }

    public int getBackgroundG() {
        return backgroundG;
    }

    public int getCurrentCategory() {
        return currentCategory;
    }

    public int getCurrentMod() {
        return currentMod;
    }

    public int getDisabledB() {
        return disabledB;
    }

    public int getDisabledG() {
        return disabledG;
    }

    public int getDisabledR() {
        return disabledR;
    }

    public int getEnabledB() {
        return enabledB;
    }

    public int getEnabledG() {
        return enabledG;
    }

    public int getEnabledR() {
        return enabledR;
    }

    public int getSelectedBGB() {
        return selectedBGB;
    }

    public int getSelectedBgG() {
        return selectedBgG;
    }

    public int getSelectedBgR() {
        return selectedBgR;
    }

    public int getCategoryR() {
        return categoryR;
    }

    public int getCategoryB() {
        return categoryB;
    }

    public int getCategoryG() {
        return categoryG;
    }

    public void setDisabledG(int disabledG) {
        this.disabledG = disabledG;
    }

    public void setBackgroundB(int backgroundB) {
        this.backgroundB = backgroundB;
    }

    public void setBackgroundG(int backgroundG) {
        this.backgroundG = backgroundG;
    }

    public void setBackgroundR(int backgroundR) {
        this.backgroundR = backgroundR;
    }

    public void setDisabledB(int disabledB) {
        this.disabledB = disabledB;
    }

    public void setDisabledR(int disabledR) {
        this.disabledR = disabledR;
    }

    public void setEnabledB(int enabledB) {
        this.enabledB = enabledB;
    }

    public void setEnabledG(int enabledG) {
        this.enabledG = enabledG;
    }

    public void setEnabledR(int enabledR) {
        this.enabledR = enabledR;
    }

    public void setSelectedBgR(int selectedBgR) {
        this.selectedBgR = selectedBgR;
    }

    public void setSelectedBgG(int selectedBgG) {
        this.selectedBgG = selectedBgG;
    }

    public void setSelectedBGB(int selectedBGB) {
        this.selectedBGB = selectedBGB;
    }

    public void setCategoryR(int categoryR) {
        this.categoryR = categoryR;
    }

    public void setCategoryG(int categoryG) {
        this.categoryG = categoryG;
    }

    public void setCategoryB(int categoryB) {
        this.categoryB = categoryB;
    }
}
