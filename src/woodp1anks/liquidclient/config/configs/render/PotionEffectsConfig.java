package woodp1anks.liquidclient.config.configs.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import woodp1anks.liquidclient.LiquidClient;
import woodp1anks.liquidclient.config.Config;
import woodp1anks.liquidclient.mod.mods.render.PotionEffects;

import java.awt.*;

public class PotionEffectsConfig extends Config {
    public PotionEffectsConfig() {
        super("PotionEffects");
    }

    @Override
    public void syncStart() {
        ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
        int height = scaledResolution.getScaledHeight();

        PotionEffects potionEffects = (PotionEffects) LiquidClient.modManager.getMod("PotionEffects");
        potionEffects.setX(Integer.parseInt(get("x", String.valueOf(5))));
        potionEffects.setStartY(Integer.parseInt(get("starty", String.valueOf(height / 2 - 15))));
        potionEffects.setDurationR(Integer.parseInt(get("durationr", String.valueOf(80))));
        potionEffects.setDurationG(Integer.parseInt(get("durationg", String.valueOf(190))));
        potionEffects.setDurationB(Integer.parseInt(get("durationb", String.valueOf(255))));
        potionEffects.setNameR(Integer.parseInt(get("namer", String.valueOf(0))));
        potionEffects.setNameG(Integer.parseInt(get("nameg", String.valueOf(230))));
        potionEffects.setNameB(Integer.parseInt(get("nameb", String.valueOf(255))));
    }

    @Override
    public void syncStop() {
        PotionEffects potionEffects = (PotionEffects) LiquidClient.modManager.getMod("PotionEffects");
        set("x", String.valueOf(potionEffects.getX()));
        set("startY", String.valueOf(potionEffects.getStartY()));
        set("durationr", String.valueOf(potionEffects.getDurationR()));
        set("durationg", String.valueOf(potionEffects.getDurationG()));
        set("durationb", String.valueOf(potionEffects.getDurationB()));
        set("namer", String.valueOf(potionEffects.getNameR()));
        set("nameg", String.valueOf(potionEffects.getNameG()));
        set("nameb", String.valueOf(potionEffects.getNameB()));
    }
}
