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
        autoClicker.setlMinCps(Integer.parseInt(get("lmincps", String.valueOf(10))));
        autoClicker.setlMaxCps(Integer.parseInt(get("lmaxcps", String.valueOf(15))));
        autoClicker.setrMinCps(Integer.parseInt(get("rmincps", String.valueOf(10))));
        autoClicker.setrMaxCps(Integer.parseInt(get("rmaxcps", String.valueOf(15))));
    }

    @Override
    public void syncStop() {
        AutoClicker autoClicker = (AutoClicker) LiquidClient.modManager.getMod("AutoClicker");
        set("lmincps", String.valueOf(autoClicker.getlMinCps()));
        set("lmaxcps", String.valueOf(autoClicker.getlMaxCps()));
        set("rmincps", String.valueOf(autoClicker.getrMinCps()));
        set("rmaxcps", String.valueOf(autoClicker.getrMaxCps()));
    }
}
