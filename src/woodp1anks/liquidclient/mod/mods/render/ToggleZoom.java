package woodp1anks.liquidclient.mod.mods.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;
import woodp1anks.liquidclient.mod.Category;
import woodp1anks.liquidclient.mod.Mod;

public class ToggleZoom extends Mod {

    private float defaultFov;
    private float zoomFov;
    private boolean isZoomed;

    public ToggleZoom() {
        super("ToggleZoom", Category.Render);
        setZoomFov(30);
        this.defaultFov = Minecraft.getMinecraft().gameSettings.fovSetting;
    }

    public float getZoomFov() {
        return this.zoomFov;
    }

    public void setZoomFov(float zoomFov) {
        this.zoomFov = zoomFov;
    }

    @Override
    public void draw() {
        if (Keyboard.isKeyDown(Keyboard.KEY_C)) {
            isZoomed = true;
            Minecraft.getMinecraft().gameSettings.fovSetting = zoomFov;
        } else if (!Keyboard.isKeyDown(Keyboard.KEY_C) && isZoomed) {
            isZoomed = false;
            Minecraft.getMinecraft().gameSettings.fovSetting = defaultFov;
        } else if (!isZoomed) {
            defaultFov = Minecraft.getMinecraft().gameSettings.fovSetting;
        }
    }
}
