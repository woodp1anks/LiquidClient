package woodp1anks.liquidclient.config.configs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import woodp1anks.liquidclient.LiquidClient;
import woodp1anks.liquidclient.config.Config;
import woodp1anks.liquidclient.mod.Mod;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class ModsConfig extends Config {
    public ModsConfig() {
        super("Mods");
    }

    @Override
    public void load() {
        try {
            JsonObject jsonObject = new Gson().fromJson(new String(Files.readAllBytes(getPath()),StandardCharsets.UTF_8),JsonObject.class);
            for (Mod mod : LiquidClient.modManager.getMods()) {
                if (jsonObject.has(mod.getName())) {
                    JsonObject modJsonObject = jsonObject.get(mod.getName()).getAsJsonObject();
                    if (modJsonObject.has("enabled")) {
                        mod.setEnabled(modJsonObject.get("enabled").getAsBoolean());
                    }
                    if (modJsonObject.has("key")) {
                        mod.setKey(modJsonObject.get("key").getAsInt());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save() {
        JsonObject jsonObject = new JsonObject();
        for (Mod mod : LiquidClient.modManager.getMods()) {
            JsonObject modJsonObject = new JsonObject();
            modJsonObject.addProperty("enabled",mod.isEnabled());
            modJsonObject.addProperty("key",mod.getKey());
            jsonObject.add(mod.getName(),modJsonObject);
        }
        try {
            Files.write(getPath(),jsonObject.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
