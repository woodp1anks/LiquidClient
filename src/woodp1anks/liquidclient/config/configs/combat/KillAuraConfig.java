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
        killAura.setServerSlideRotation(Boolean.parseBoolean(get("serversliderotation", String.valueOf(false))));
        killAura.setMinCps(Integer.parseInt(get("mincps", String.valueOf(10))));
        killAura.setMaxCps(Integer.parseInt(get("maxcps", String.valueOf(15))));
    }

    @Override
    public void syncStop() {
        KillAura killAura = (KillAura) LiquidClient.modManager.getMod("KillAura");
        set("antibotpractice", String.valueOf(killAura.isAntiBotPractice()));
        set("serversliderotation", String.valueOf(killAura.isServerSlideRotation()));
        set("mincps", String.valueOf(killAura.getMinCps()));
        set("maxcps", String.valueOf(killAura.getMaxCps()));
    }
}
