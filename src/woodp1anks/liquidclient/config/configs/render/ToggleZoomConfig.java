package woodp1anks.liquidclient.config.configs.render;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import woodp1anks.liquidclient.LiquidClient;
import woodp1anks.liquidclient.config.Config;
import woodp1anks.liquidclient.mod.mods.render.ArrayList;
import woodp1anks.liquidclient.mod.mods.render.ToggleZoom;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class ToggleZoomConfig extends Config {
    public ToggleZoomConfig() {
        super("ToggleZoom");
    }

    @Override
    public void load() {
        ToggleZoom toggleZoom = (ToggleZoom) LiquidClient.modManager.getMod("ToggleZoom");
        try {
            JsonObject jsonObject = new Gson().fromJson(new String(Files.readAllBytes(getPath()), StandardCharsets.UTF_8),JsonObject.class);
            if (jsonObject.has("zoomfov")) {
                toggleZoom.setZoomFov(jsonObject.get("zoomfov").getAsInt());
            } else {toggleZoom.setZoomFov(30);}
        } catch (UnsupportedOperationException ex) {
            toggleZoom.setZoomFov(30);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void save() {
        JsonObject jsonObject = new JsonObject();
        ToggleZoom toggleZoom = (ToggleZoom) LiquidClient.modManager.getMod("ToggleZoom");
        jsonObject.addProperty("zoomfov",toggleZoom.getZoomFov());
        try {
            Files.write(getPath(),jsonObject.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
