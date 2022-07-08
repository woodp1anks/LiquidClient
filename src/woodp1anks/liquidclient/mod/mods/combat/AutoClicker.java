package woodp1anks.liquidclient.mod.mods.combat;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import woodp1anks.liquidclient.mod.Category;
import woodp1anks.liquidclient.mod.Mod;

import java.awt.*;
import java.awt.event.InputEvent;

public class AutoClicker extends Mod {
    private int lCps;
    private int rCps;
    private int lTicks;
    private int rTicks;

    public AutoClicker() {
        super("AutoClicker", Category.Combat);

    }

    @Override
    public void update() {
        int lClickTime = 20 / lCps;
        int rClickTime = 20 / rCps;
        if (lTicks >= lClickTime && Minecraft.getMinecraft().gameSettings.keyBindAttack.isKeyDown()) {
            KeyBinding.onTick(Minecraft.getMinecraft().gameSettings.keyBindAttack.keyCode);
            Minecraft.getMinecraft().thePlayer.swingItem();
            lTicks = 0;
        }
        if (rTicks >= rClickTime && Minecraft.getMinecraft().gameSettings.keyBindUseItem.isKeyDown()) {
            KeyBinding.onTick(Minecraft.getMinecraft().gameSettings.keyBindUseItem.keyCode);
            rTicks = 0;
        }
        lTicks++;
        rTicks++;
    }

    public int getlCps() {
        return lCps;
    }

    public int getrCps() {
        return rCps;
    }

    public void setlCps(int lCps) {
        this.lCps = lCps;
    }

    public void setrCps(int rCps) {
        this.rCps = rCps;
    }
}
