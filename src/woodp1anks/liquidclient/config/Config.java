package woodp1anks.liquidclient.config;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.minecraft.client.Minecraft;
import woodp1anks.liquidclient.LiquidClient;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Config {
    private final String name;

    public Config(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Path getPath() {
        return Paths.get(Minecraft.getMinecraft().mcDataDir.getAbsolutePath(), LiquidClient.NAME,"config",name + ".json");
    }

    public String toString(String startStr,String middleStr,String endStr) {
        String string = null;
        try {
            JsonObject jsonObject = new Gson().fromJson(new String(Files.readAllBytes(getPath()), StandardCharsets.UTF_8),JsonObject.class);
            for (int i = 0;;) {
                if (i > jsonObject.getAsJsonArray().size()) {
                    break;
                }
                string = middleStr + jsonObject.getAsJsonArray().get(i).getAsString();
                if (i == 0) {
                    string = startStr + jsonObject.getAsJsonArray().get(i).getAsString();
                }
                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        string = string + endStr;
        return string;
    }

    public void load() {

    }

    public void save() {

    }
}
