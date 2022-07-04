package woodp1anks.liquidclient.config;

import com.google.gson.JsonObject;
import woodp1anks.liquidclient.config.configs.MiscsConfig;
import woodp1anks.liquidclient.config.configs.ModsConfig;
import woodp1anks.liquidclient.config.configs.render.AntiBlindConfig;
import woodp1anks.liquidclient.config.configs.render.ArrayListConfig;
import woodp1anks.liquidclient.config.configs.render.TabGUIConfig;
import woodp1anks.liquidclient.config.configs.render.ToggleZoomConfig;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConfigManager {
    private final List<Config> configs = new ArrayList<Config>() {
        {
            add(new ModsConfig());
            add(new AntiBlindConfig());
            add(new ArrayListConfig());
            add(new ToggleZoomConfig());
            add(new TabGUIConfig());
            add(new MiscsConfig());
        }
    };

    public List<Config> getConfigs() {
        return configs;
    }

    public Config getConfig(String name) {
        for (Config config : getConfigs()) {
            if (config.getName().equalsIgnoreCase(name)) {
                return config;
            }
        }
        return null;
    }

    public void load() {
        for (Config config : configs) {
            if (config.getPath().toFile().exists()) {
                config.load();
            }
        }
    }

    public void save() {
        for (Config config : configs) {
            if (!config.getPath().toFile().exists()) {
                try {
                    Files.createDirectories(config.getPath().getParent());
                    config.getPath().toFile().createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            config.save();
        }
    }
}
