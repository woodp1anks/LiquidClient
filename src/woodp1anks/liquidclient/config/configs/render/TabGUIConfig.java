package woodp1anks.liquidclient.config.configs.render;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import woodp1anks.liquidclient.LiquidClient;
import woodp1anks.liquidclient.config.Config;
import woodp1anks.liquidclient.mod.mods.render.TabGUI;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Locale;

public class TabGUIConfig extends Config {
    public TabGUIConfig() {
        super("TabGUI");
    }

    @Override
    public void syncStart() {
        TabGUI tabGUI = (TabGUI) LiquidClient.modManager.getMod("TabGUI");
        tabGUI.setBackgroundR(Integer.parseInt(get("backgroundr", String.valueOf(Color.LIGHT_GRAY.getRed()))));
        tabGUI.setBackgroundG(Integer.parseInt(get("backgroundg", String.valueOf(Color.LIGHT_GRAY.getGreen()))));
        tabGUI.setBackgroundB(Integer.parseInt(get("backgroundb", String.valueOf(Color.LIGHT_GRAY.getGreen()))));
        tabGUI.setSelectedBgR(Integer.parseInt(get("selectedbgr", String.valueOf(Color.GRAY.getRed()))));
        tabGUI.setSelectedBgG(Integer.parseInt(get("selectedbgg", String.valueOf(Color.GRAY.getGreen()))));
        tabGUI.setSelectedBGB(Integer.parseInt(get("selectedbgb", String.valueOf(Color.GRAY.getBlue()))));
        tabGUI.setCategoryR(Integer.parseInt(get("categoryr", String.valueOf(LiquidClient.MAIN_COLOR.getRed()))));
        tabGUI.setCategoryG(Integer.parseInt(get("categoryg", String.valueOf(LiquidClient.MAIN_COLOR.getGreen()))));
        tabGUI.setCategoryB(Integer.parseInt(get("categoryb", String.valueOf(LiquidClient.MAIN_COLOR.getBlue()))));
        tabGUI.setDisabledR(Integer.parseInt(get("disabledr", String.valueOf(255))));
        tabGUI.setDisabledG(Integer.parseInt(get("disabledg", String.valueOf(80))));
        tabGUI.setDisabledB(Integer.parseInt(get("disabledb", String.valueOf(80))));
        tabGUI.setEnabledR(Integer.parseInt(get("enabledr", String.valueOf(140))));
        tabGUI.setEnabledG(Integer.parseInt(get("enabledg", String.valueOf(255))));
        tabGUI.setEnabledB(Integer.parseInt(get("enabledb", String.valueOf(140))));
    }

    @Override
    public void syncStop() {
        TabGUI tabGUI = (TabGUI) LiquidClient.modManager.getMod("TabGUI");
        set("backgroundr", String.valueOf(tabGUI.getBackgroundR()));
        set("backgroundg", String.valueOf(tabGUI.getBackgroundG()));
        set("backgroundb", String.valueOf(tabGUI.getBackgroundB()));
        set("selectedbgr", String.valueOf(tabGUI.getSelectedBgR()));
        set("selectedbgg", String.valueOf(tabGUI.getSelectedBgG()));
        set("selectedbgb", String.valueOf(tabGUI.getSelectedBGB()));
        set("categoryr", String.valueOf(tabGUI.getCategoryR()));
        set("categoryg", String.valueOf(tabGUI.getCategoryG()));
        set("categoryb", String.valueOf(tabGUI.getCategoryB()));
        set("disabledr", String.valueOf(tabGUI.getDisabledR()));
        set("disabledg", String.valueOf(tabGUI.getDisabledG()));
        set("disabledb", String.valueOf(tabGUI.getDisabledB()));
        set("enabledr", String.valueOf(tabGUI.getEnabledR()));
        set("enabledg", String.valueOf(tabGUI.getEnabledG()));
        set("enabledb", String.valueOf(tabGUI.getEnabledB()));
    }
}
