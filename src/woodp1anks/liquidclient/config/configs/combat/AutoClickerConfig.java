package woodp1anks.liquidclient.config.configs.combat;

import woodp1anks.liquidclient.LiquidClient;
import woodp1anks.liquidclient.config.Config;
import woodp1anks.liquidclient.mod.mods.combat.AutoClicker;

public class AutoClickerConfig extends Config {
    public AutoClickerConfig() {
        super("AutoClicker");
    }

    @Override
    public void syncStart() {
        AutoClicker autoClicker = (AutoClicker) LiquidClient.modManager.getMod("AutoClicker");
        autoClicker.setlCps(Integer.parseInt(get("lcps", String.valueOf(10))));
        autoClicker.setrCps(Integer.parseInt(get("rcps", String.valueOf(10))));
    }

    @Override
    public void syncStop() {
        AutoClicker autoClicker = (AutoClicker) LiquidClient.modManager.getMod("AutoClicker");
        set("lcps", String.valueOf(autoClicker.getlCps()));
        set("rcps", String.valueOf(autoClicker.getrCps()));
    }
}
