package woodp1anks.liquidclient.mod.mods.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import woodp1anks.liquidclient.LiquidClient;
import woodp1anks.liquidclient.mod.Category;
import woodp1anks.liquidclient.mod.Mod;

public class ArrayList extends Mod {

    private String startStr;
    private String middleStr;
    private String endStr;
    private int argsR;
    private int argsG;
    private int argsB;

    public ArrayList() {
        super("ArrayList", Category.RENDER);
    }

    public String getStartStr() {
        return startStr;
    }

    public String getMiddleStr() {
        return middleStr;
    }

    public String getEndStr() {
        return endStr;
    }

    public int getArgsR() {
        return argsR;
    }

    public int getArgsG() {
        return argsG;
    }

    public int getArgsB() {
        return argsB;
    }

    public void setStartStr(String startStr) {
        this.startStr = startStr;
    }

    public void setMiddleStr(String middleStr) {
        this.middleStr = middleStr;
    }

    public void setEndStr(String endStr) {
        this.endStr = endStr;
    }

    public void setArgsR(int argsR) {
        this.argsR = argsR;
    }

    public void setArgsG(int argsG) {
        this.argsG = argsG;
    }

    public void setArgsB(int argsB) {
        this.argsB = argsB;
    }

    @Override
    public void draw() {
        ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
        int width = scaledResolution.getScaledWidth();
        int height = scaledResolution.getScaledHeight();

        int y = 5;

        for (Mod mod : LiquidClient.modManager.getEnabledMods()) {
            FontRenderer font = Minecraft.getMinecraft().fontRendererObj;
            String textMod = mod.getName();

            font.drawStringWithShadow(textMod,width - font.getStringWidth(textMod) - 5,y,LiquidClient.rainbow.getColor().getRGB());

            y += font.FONT_HEIGHT + 1;
        }
    }
}
