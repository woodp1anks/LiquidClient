package woodp1anks.liquidclient.config.configs.render;

import woodp1anks.liquidclient.LiquidClient;
import woodp1anks.liquidclient.config.Config;
import woodp1anks.liquidclient.mod.mods.render.KeyStrokes;

import java.awt.*;

public class KeyStrokesConfig extends Config {
    public KeyStrokesConfig() {
        super("KeyStrokes");
    }

    @Override
    public void syncStart() {
        KeyStrokes keyStrokes = (KeyStrokes) LiquidClient.modManager.getMod("KeyStrokes");
        keyStrokes.setBackgroundR(Integer.parseInt(get("backgroundr", String.valueOf(Color.LIGHT_GRAY.getRed()))));
        keyStrokes.setBackgroundG(Integer.parseInt(get("backgroundg", String.valueOf(Color.LIGHT_GRAY.getGreen()))));
        keyStrokes.setBackgroundB(Integer.parseInt(get("backgroundb", String.valueOf(Color.LIGHT_GRAY.getBlue()))));
        keyStrokes.setPressedBgR(Integer.parseInt(get("pressedbgr", String.valueOf(Color.GRAY.getRed()))));
        keyStrokes.setPressedBgG(Integer.parseInt(get("pressedbgg", String.valueOf(Color.GRAY.getGreen()))));
        keyStrokes.setPressedBgB(Integer.parseInt(get("pressedbgb", String.valueOf(Color.GRAY.getBlue()))));
        keyStrokes.setTextR(Integer.parseInt(get("textr", String.valueOf(Color.WHITE.getRed()))));
        keyStrokes.setTextG(Integer.parseInt(get("textg", String.valueOf(Color.WHITE.getGreen()))));
        keyStrokes.setTextB(Integer.parseInt(get("textb", String.valueOf(Color.WHITE.getBlue()))));
        keyStrokes.setPressedTextR(Integer.parseInt(get("pressedtextr", String.valueOf(Color.LIGHT_GRAY.getRed()))));
        keyStrokes.setPressedTextG(Integer.parseInt(get("pressedtextg", String.valueOf(Color.LIGHT_GRAY.getGreen()))));
        keyStrokes.setPressedTextB(Integer.parseInt(get("pressedtextb", String.valueOf(Color.LIGHT_GRAY.getBlue()))));
    }

    @Override
    public void syncStop() {
        KeyStrokes keyStrokes = (KeyStrokes) LiquidClient.modManager.getMod("KeyStrokes");
        set("backgroundr", String.valueOf(keyStrokes.getBackgroundR()));
        set("backgroundg", String.valueOf(keyStrokes.getBackgroundG()));
        set("backgroundb", String.valueOf(keyStrokes.getBackgroundB()));
        set("pressedbgr", String.valueOf(keyStrokes.getPressedBgR()));
        set("pressedbgg", String.valueOf(keyStrokes.getPressedBgG()));
        set("pressedbgb", String.valueOf(keyStrokes.getPressedBgB()));
        set("textr", String.valueOf(keyStrokes.getTextR()));
        set("textg", String.valueOf(keyStrokes.getTextG()));
        set("textb", String.valueOf(keyStrokes.getTextB()));
        set("pressedtextr", String.valueOf(keyStrokes.getPressedTextR()));
        set("pressedtextg", String.valueOf(keyStrokes.getPressedTextG()));
        set("pressedtextb", String.valueOf(keyStrokes.getPressedTextB()));
    }
}


