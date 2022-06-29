package woodp1anks.liquidclient.gui;

import net.minecraft.client.gui.*;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import woodp1anks.liquidclient.LiquidClient;

import java.awt.*;
import java.io.IOException;

public class MainMenuGui extends GuiScreen {

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 0)
        {
            this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
        }
        if (button.id == 4)
        {
            this.mc.shutdown();
        }
        if (button.id == 1)
        {
            this.mc.displayGuiScreen(new GuiSelectWorld(this));
        }

        if (button.id == 2)
        {
            this.mc.displayGuiScreen(new GuiMultiplayer(this));
        }
    }

    @Override
    public void initGui() {

        int j = this.height / 4 + 48;

        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, j + 72 + 12, 98, 20, I18n.format("menu.options", new Object[0])));
        this.buttonList.add(new GuiButton(4, this.width / 2 + 2, j + 72 + 12, 98, 20, I18n.format("menu.quit", new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, j, I18n.format("menu.singleplayer", new Object[0])));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 100, j + 24 * 1, I18n.format("menu.multiplayer", new Object[0])));

    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawBackground(0);

        mc.getTextureManager().bindTexture(new ResourceLocation("liquidclient/background.png"));
        Gui.drawModalRectWithCustomSizedTexture(0,0,0,0,width,height,width,height);

        String textName = LiquidClient.NAME;
        String textMinecraftVersion = "Minecraft 1.8.8";
        String textClientVersion = "LiquidClient v" + LiquidClient.VERSION;
        String textAuthor = "by woodp1anks";
        String textBg = "background from FDP";
        FontRenderer font = mc.fontRendererObj;

        font.drawStringWithShadow(textName,width / 2 - font.getStringWidth(textName) / 2,height / 4,LiquidClient.MAIN_COLOR.getRGB());

        font.drawStringWithShadow(textMinecraftVersion,0,height - font.FONT_HEIGHT * 2,Color.LIGHT_GRAY.getRGB());
        font.drawStringWithShadow(textClientVersion,0,height - font.FONT_HEIGHT,Color.LIGHT_GRAY.getRGB());
        font.drawStringWithShadow(textBg,width - font.getStringWidth(textBg),height - font.FONT_HEIGHT,Color.LIGHT_GRAY.getRGB());
        font.drawStringWithShadow(textAuthor,width - font.getStringWidth(textAuthor),height - font.FONT_HEIGHT * 2,Color.LIGHT_GRAY.getRGB());

        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
