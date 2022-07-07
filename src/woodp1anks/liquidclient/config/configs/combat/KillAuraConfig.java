package woodp1anks.liquidclient.config.configs.combat;

import woodp1anks.liquidclient.LiquidClient;
import woodp1anks.liquidclient.config.Config;
import woodp1anks.liquidclient.mod.mods.combat.KillAura;

public class KillAuraConfig extends Config {
    public KillAuraConfig() {
        super("KillAura");
    }

    @Override
    public void syncStart() {
        KillAura killAura = (KillAura) LiquidClient.modManager.getMod("KillAura");
        killAura.setAntiBotPractice(Boolean.parseBoolean(get("antibotpractice", String.valueOf(false))));
        killAura.setSwingVisual(Boolean.parseBoolean(get("swingvisual", String.valueOf(false))));
        killAura.setServerSlideRotation(Boolean.parseBoolean(get("serversliderotation", String.valueOf(false))));
        killAura.setCps(Integer.parseInt(get("cps", String.valueOf(10))));
    }

    @Override
    public void syncStop() {
        KillAura killAura = (KillAura) LiquidClient.modManager.getMod("KillAura");
        set("antibotpractice", String.valueOf(killAura.isAntiBotPractice()));
        set("swingvisual", String.valueOf(killAura.isSwingVisual()));
        set("serversliderotation", String.valueOf(killAura.isServerSlideRotation()));
        set("cps", String.valueOf(killAura.getCps()));
    }
}
