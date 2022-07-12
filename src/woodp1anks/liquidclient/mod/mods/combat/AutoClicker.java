package woodp1anks.liquidclient.mod.mods.combat;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import woodp1anks.liquidclient.mod.Category;
import woodp1anks.liquidclient.mod.Mod;

import java.util.Random;

public class AutoClicker extends Mod {
    private int lMinCps;
    private int lMaxCps;
    private int rMinCps;
    private int rMaxCps;
    private int lTicks;
    private int rTicks;

    public AutoClicker() {
        super("AutoClicker", Category.Combat);

    }

    @Override
    public void update() {
        int lCps = lMinCps + new Random().nextInt(lMaxCps - lMinCps);
        int rCps = rMinCps + new Random().nextInt(rMaxCps - rMinCps);

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

    public int getlMinCps() {
        return lMinCps;
    }

    public int getlMaxCps() {
        return lMaxCps;
    }

    public int getrMinCps() {
        return rMinCps;
    }

    public int getrMaxCps() {
        return rMaxCps;
    }

    public void setlMinCps(int lMinCps) {
        this.lMinCps = lMinCps;
    }

    public void setlMaxCps(int lMaxCps) {
        this.lMaxCps = lMaxCps;
    }

    public void setrMinCps(int rMinCps) {
        this.rMinCps = rMinCps;
    }

    public void setrMaxCps(int rMaxCps) {
        this.rMaxCps = rMaxCps;
    }
}
