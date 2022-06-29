package woodp1anks.liquidclient.mod.mods.render;

import net.minecraft.client.Minecraft;
import woodp1anks.liquidclient.mod.Category;
import woodp1anks.liquidclient.mod.Mod;

public class FullBright extends Mod {
    public FullBright() {
        super("FullBright", Category.RENDER);
    }

    @Override
    public void draw() {
        Minecraft.getMinecraft().gameSettings.gammaSetting = 100;
    }
}
