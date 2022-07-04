package woodp1anks.liquidclient.config.configs.render;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import woodp1anks.liquidclient.LiquidClient;
import woodp1anks.liquidclient.config.Config;
import woodp1anks.liquidclient.mod.Mod;
import woodp1anks.liquidclient.mod.mods.render.AntiBlind;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class AntiBlindConfig extends Config {
    public AntiBlindConfig() {
        super("AntiBlind");
    }

    @Override
    public void syncStart() {
        AntiBlind antiBlind = (AntiBlind) LiquidClient.modManager.getMod("AntiBlind");
        antiBlind.setDisablePumpkin(Boolean.parseBoolean(get("disablepumpkin", String.valueOf(true))));
        antiBlind.setDisableBlind(Boolean.parseBoolean(get("disableblind", String.valueOf(true))));
        antiBlind.setNoContainerBg(Boolean.parseBoolean(get("nocontainerbg", String.valueOf(true))));
        antiBlind.setFireAlpha(Float.parseFloat(get("firealpha", String.valueOf(0.1F))));
    }

    @Override
    public void syncStop() {
        AntiBlind antiBlind = (AntiBlind) LiquidClient.modManager.getMod("AntiBlind");
        set("disablepumpkin", String.valueOf(antiBlind.isPumpkinDisabled()));
        set("disableblind", String.valueOf(antiBlind.isBlindDisabled()));
        set("nocontainerbg", String.valueOf(antiBlind.isContainerBgDisabled()));
        set("firealpha", String.valueOf(antiBlind.getFireAlpha()));
    }

}
