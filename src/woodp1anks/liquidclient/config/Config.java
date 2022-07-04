package woodp1anks.liquidclient.config;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.client.Minecraft;
import woodp1anks.liquidclient.LiquidClient;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Config {
    private final String name;
    private Map<String,String> map = new HashMap<>();
    private boolean notFirstUse;

    public Config(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Path getPath() {
        return Paths.get(Minecraft.getMinecraft().mcDataDir.getAbsolutePath(), LiquidClient.NAME,"config",name + ".json");
    }

    public boolean isNotFirstUse() {
        return notFirstUse;
    }

    public void setNotFirstUse(boolean notFirstUse) {
        this.notFirstUse = notFirstUse;
    }

    public String toString(String startStr, String middleStr, String endStr) {
        StringBuilder string = new StringBuilder(startStr);
        int i = 0;
        for (Map.Entry<String, String> entry : getMap().entrySet()) {
            if (entry.getKey().equalsIgnoreCase("notFirstUse") || entry.getKey().equalsIgnoreCase("notFirstUse1")) {
                continue;
            }
            string.append(middleStr).append(entry.getValue());
            if (i == 0) {
                string = new StringBuilder(startStr).append(entry.getValue());
            }
            i++;
        }
        string.append(endStr);
        return string.toString();
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void add(String key,String arg) {
        map.put(key,arg);
    }

    public void set(String key,String arg) {
        boolean foundKey = false;
        for (Map.Entry<String,String> mapEntry : map.entrySet()) {
            if (mapEntry.getKey().equalsIgnoreCase(key)) {
                mapEntry.setValue(arg.toLowerCase(Locale.ROOT));
                foundKey = true;
            }
        }
        if (!foundKey) {
            if (arg == null) {
                arg = "";
            }
             add(key,arg.toLowerCase());
        }
    }

    public String get(String key,String def) {
        if (!isNotFirstUse()) {
            return def;
        }
        for (Map.Entry<String,String> mapEntry : map.entrySet()) {
            if (mapEntry.getKey().equalsIgnoreCase(key)) {
                return mapEntry.getValue();
            }
        }
        return def;
    }

    public void load() {
        JsonObject jsonObject = null;
        try {
            jsonObject = new Gson().fromJson(new String(Files.readAllBytes(getPath()), StandardCharsets.UTF_8), JsonObject.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (jsonObject == null) {
            jsonObject = new JsonObject();
        }
        if (jsonObject.has("notFirstUse")) {
            setNotFirstUse(true);
        }
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            map.put(entry.getKey(),entry.getValue().getAsString());
        }
        syncStart();

    }

    public void syncStart() {

    }

    public void syncStop() {

    }

    public void setDefault() {

    }

    public void save() {
        syncStop();
        JsonObject jsonObject = new JsonObject();
        try {
            jsonObject = new Gson().fromJson(new String(Files.readAllBytes(getPath()), StandardCharsets.UTF_8), JsonObject.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (jsonObject == null) {
            jsonObject = new JsonObject();
        }
        for (Map.Entry<String,String> mapEntry : getMap().entrySet()) {
            if (!jsonObject.has(mapEntry.getKey())) {
                jsonObject.addProperty(mapEntry.getKey(),mapEntry.getValue());
            }
            if (!jsonObject.get(mapEntry.getKey()).getAsString().equals(mapEntry.getValue())) {
                jsonObject.addProperty(mapEntry.getKey(),mapEntry.getValue());
            }
        }

        if (jsonObject.has("notFirstUse1")) {
            jsonObject.addProperty("notFirstUse",true);
        }
        jsonObject.addProperty("notFirstUse1",true);
        try {
            Files.write(getPath(),jsonObject.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        }
    }

