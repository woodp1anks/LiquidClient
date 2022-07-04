package woodp1anks.liquidclient.config.configs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.lwjgl.input.Keyboard;
import woodp1anks.liquidclient.LiquidClient;
import woodp1anks.liquidclient.config.Config;
import woodp1anks.liquidclient.mod.Mod;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Map;

public class ModsConfig extends Config {
    public ModsConfig() {
        super("Mods");
    }

    @Override
    public void syncStart() {
        for (Mod mod : LiquidClient.modManager.getMods()) {
            mod.setEnabled(Boolean.parseBoolean(get(mod.getName() + "-enabled","false")));
            mod.setKey(Integer.parseInt(get(mod.getName() + "-key","0")));
        }
    }

    @Override
    public void syncStop() {
        for (Mod mod : LiquidClient.modManager.getMods()) {
            set(mod.getName() + "-enabled", String.valueOf(mod.isEnabled()));
            set(mod.getName() + "-key", String.valueOf(mod.getKey()));
        }
    }
}
