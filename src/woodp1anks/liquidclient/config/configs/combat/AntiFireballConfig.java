package woodp1anks.liquidclient.config.configs.combat;

import net.minecraft.client.gui.inventory.GuiInventory;
import woodp1anks.liquidclient.LiquidClient;
import woodp1anks.liquidclient.config.Config;
import woodp1anks.liquidclient.mod.mods.combat.AntiFireball;

public class AntiFireballConfig extends Config {
    public AntiFireballConfig() {
        super("AntiFireball");
    }

    @Override
    public void syncStart() {
        AntiFireball antiFireball = (AntiFireball) LiquidClient.modManager.getMod("AntiFireball");
        antiFireball.setServerSlideRotation(Boolean.parseBoolean(get("serversliderotation", String.valueOf(true))));
    }

    @Override
    public void syncStop() {
        AntiFireball antiFireball = (AntiFireball) LiquidClient.modManager.getMod("AntiFireball");
        set("serversliderotation", String.valueOf(antiFireball.isRotationServerSlide()));
    }
}
