package woodp1anks.liquidclient.config.configs.render;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.minecraft.client.Minecraft;
import woodp1anks.liquidclient.LiquidClient;
import woodp1anks.liquidclient.config.Config;
import woodp1anks.liquidclient.mod.mods.render.ArrayList;
import woodp1anks.liquidclient.mod.mods.render.ToggleZoom;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class ToggleZoomConfig extends Config {


    private Map<String,String> map;


    public ToggleZoomConfig() {
        super("ToggleZoom");
    }

    @Override
    public void syncStart() {
        ToggleZoom toggleZoom = (ToggleZoom) LiquidClient.modManager.getMod("ToggleZoom");
        toggleZoom.setZoomFov(Float.parseFloat(get("zoomfov","30")));
    }

    @Override
    public void syncStop() {
        ToggleZoom toggleZoom = (ToggleZoom) LiquidClient.modManager.getMod("ToggleZoom");
        set("zoomfov", String.valueOf(toggleZoom.getZoomFov()));
    }
}
