package woodp1anks.liquidclient.mod.mods.render;

import woodp1anks.liquidclient.mod.Category;
import woodp1anks.liquidclient.mod.Mod;

public class AntiBlind extends Mod {

    private boolean disablePumpkin;
    private boolean disableBlind;
    private boolean noContainerBg;
    private float fireAlpha;

    public AntiBlind() {
        super("AntiBlind", Category.Render);
    }

    public boolean isPumpkinDisabled() {
        return disablePumpkin;
    }

    public boolean isBlindDisabled() {
        return disableBlind;
    }

    public float getFireAlpha() {
        return fireAlpha;
    }

    public boolean isContainerBgDisabled() {
        return noContainerBg;
    }

    public void setDisablePumpkin(boolean disablePumpkin) {
        this.disablePumpkin = disablePumpkin;
    }

    public void setDisableBlind(boolean disableBlind) {
        this.disableBlind = disableBlind;
    }

    public void setFireAlpha(float fireAlpha) {
        this.fireAlpha = fireAlpha;
    }

    public void setNoContainerBg(boolean noContainerBg) {
        this.noContainerBg = noContainerBg;
    }
}
