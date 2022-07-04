package woodp1anks.liquidclient.mod.mods.movement;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import woodp1anks.liquidclient.LiquidClient;
import woodp1anks.liquidclient.mod.Category;
import woodp1anks.liquidclient.mod.Mod;

public class ToggleSprint extends Mod {

    public static final String toggledText = "Sprint : ON";
    private static boolean toggledSprint;

    public ToggleSprint() {
        super("ToggleSprint", Category.Movement);
    }

    @Override
    public void update() {
        if (Minecraft.getMinecraft().gameSettings.keyBindSprint.isKeyDown()) {
            toggledSprint = !toggledSprint;
        }

        if (Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown() && toggledSprint) {
            Minecraft.getMinecraft().thePlayer.setSprinting(true);
        }
    }

    @Override
    public void draw() {
        if (toggledSprint) {
            ScaledResolution scaledresolution = new ScaledResolution(Minecraft.getMinecraft());
            int height = scaledresolution.getScaledHeight();

            FontRenderer font = Minecraft.getMinecraft().fontRendererObj;

            font.drawStringWithShadow(toggledText,1,height - font.FONT_HEIGHT - 16, LiquidClient.rainbow.getColor().getRGB());
        }
    }
}
