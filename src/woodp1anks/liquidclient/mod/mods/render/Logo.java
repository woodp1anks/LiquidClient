package woodp1anks.liquidclient.mod.mods.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import woodp1anks.liquidclient.LiquidClient;
import woodp1anks.liquidclient.mod.Category;
import woodp1anks.liquidclient.mod.Mod;

public class Logo extends Mod {
    public Logo() {
        super("Logo", Category.Render);
    }

    @Override
    public void draw() {
        FontRenderer font = Minecraft.getMinecraft().fontRendererObj;
        String textName = LiquidClient.NAME;
        String textVersion = "(ver" + LiquidClient.VERSION + ")";

        font.drawStringWithShadow(textName,5,5,LiquidClient.rainbow.getColor().getRGB());
        font.drawStringWithShadow(textVersion,5,5 + font.FONT_HEIGHT + 1,LiquidClient.rainbow.getColor().getRGB());
    }
}
