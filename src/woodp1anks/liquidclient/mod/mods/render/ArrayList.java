package woodp1anks.liquidclient.mod.mods.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import woodp1anks.liquidclient.LiquidClient;
import woodp1anks.liquidclient.mod.Category;
import woodp1anks.liquidclient.mod.Mod;

import java.awt.*;

public class ArrayList extends Mod {

    private String startStr;
    private String middleStr;
    private String endStr;
    private int argsR;
    private int argsG;
    private int argsB;

    public ArrayList() {
        super("ArrayList", Category.Render);
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
            String textArgs = "";
            if (!(LiquidClient.configManager.getConfig(mod.getName()) == null)) {
                textArgs = LiquidClient.configManager.getConfig(mod.getName()).toString(startStr,middleStr,endStr);
            }

            font.drawStringWithShadow(textMod,width - font.getStringWidth(textMod) - 5 - font.getStringWidth(textArgs),y,LiquidClient.rainbow.getColor().getRGB());
            font.drawStringWithShadow(textArgs,width - font.getStringWidth(textArgs) - 5,y,new Color(argsR,argsG,argsB).getRGB());

            y += font.FONT_HEIGHT + 1;
        }
    }
}
