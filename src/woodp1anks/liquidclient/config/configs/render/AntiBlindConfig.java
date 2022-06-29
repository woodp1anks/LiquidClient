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
    public void load() {
        try {
            JsonObject jsonObject = new Gson().fromJson(new String(Files.readAllBytes(getPath()), StandardCharsets.UTF_8),JsonObject.class);
            AntiBlind antiBlind = (AntiBlind) LiquidClient.modManager.getMod("AntiBlind");
            if (jsonObject.has("disablepumpkin")) {
                antiBlind.setDisablePumpkin(jsonObject.get("disablepumpkin").getAsBoolean());
            }
            if (jsonObject.has("disableblind")) {
                antiBlind.setDisableBlind(jsonObject.get("disableblind").getAsBoolean());
            }
            if (jsonObject.has("nocontainerbg")) {
                antiBlind.setNoContainerBg(jsonObject.get("nocontainerbg").getAsBoolean());
            }
            if (jsonObject.has("firealpha")) {
                antiBlind.setFireAlpha(jsonObject.get("firealpha").getAsFloat());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save() {
        JsonObject jsonObject = new JsonObject();
        AntiBlind antiBlind = (AntiBlind) LiquidClient.modManager.getMod("AntiBlind");
        jsonObject.addProperty("disablepumpkin",antiBlind.isPumpkinDisabled());
        jsonObject.addProperty("disableblind",antiBlind.isBlindDisabled());
        jsonObject.addProperty("nocontainerbg",antiBlind.isContainerBgDisabled());
        jsonObject.addProperty("fireAlpha",antiBlind.getFireAlpha());
        try {
            Files.write(getPath(),jsonObject.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
