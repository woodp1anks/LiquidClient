package woodp1anks.liquidclient.config.configs.combat;

import woodp1anks.liquidclient.LiquidClient;
import woodp1anks.liquidclient.config.Config;
import woodp1anks.liquidclient.mod.mods.combat.AimBot;

public class AimBotConfig extends Config {
    public AimBotConfig() {
        super("AimBot");
    }

    @Override
    public void syncStart() {
        AimBot aimBot = (AimBot) LiquidClient.modManager.getMod("AimBot");
        aimBot.setRange(Double.parseDouble(get("range", String.valueOf(6))));
        aimBot.setOnlyOnClick(Boolean.parseBoolean(get("onlyonclick", String.valueOf(true))));
        aimBot.setAntiBotPractice(Boolean.parseBoolean(get("antibotpractice", String.valueOf(false))));
    }

    @Override
    public void syncStop() {
        AimBot aimBot = (AimBot) LiquidClient.modManager.getMod("AimBot");
        set("range", String.valueOf(aimBot.getRange()));
        set("onlyonclick", String.valueOf(aimBot.isOnlyOnClick()));
        set("antibotpractice", String.valueOf(aimBot.isAntiBotPracticeEnabled()));
    }
}
