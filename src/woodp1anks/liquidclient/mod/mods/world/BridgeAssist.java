package woodp1anks.liquidclient.mod.mods.world;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.world.World;
import woodp1anks.liquidclient.mod.Category;
import woodp1anks.liquidclient.mod.Mod;

public class BridgeAssist extends Mod {
    public BridgeAssist() {
        super("BridgeAssist", Category.World);
    }

    @Override
    public void update() {
        KeyBinding.onTick(Minecraft.getMinecraft().gameSettings.keyBindUseItem.keyCode);
        Math.round(Minecraft.getMinecraft().thePlayer.posX);
    }
}
