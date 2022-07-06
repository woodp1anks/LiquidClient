package woodp1anks.liquidclient.mod;

import woodp1anks.liquidclient.mod.mods.combat.KillAura;
import woodp1anks.liquidclient.mod.mods.movement.ToggleSprint;
import woodp1anks.liquidclient.mod.mods.render.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModManager {

    private final List<Mod> mods = new ArrayList<>();

    public List<Mod> getMods() {
        return mods;
    }

    public List<Mod> getMods(Category category) {
        List<Mod> mods1 = new ArrayList<>();
        for (Mod mod : getMods()) {
            if (mod.getCategory() == category) {
                mods1.add(mod);
            }
        }
        return mods1;
    }

    public List<Mod> getEnabledMods() {
        return mods.stream().filter(Mod::isEnabled).collect(Collectors.toList());
    }

    public Mod getMod(Mod mod) {
        for (Mod mod1 : getMods()) {
            if (mod1.getName().equals(mod.getName())) {
                return mod1;
            }
        }
        return null;
    }

    public Mod getMod(String name) {
        for (Mod mod1 : getMods()) {
            if (mod1.getName().equalsIgnoreCase(name)) {
                return mod1;
            }
        }
        return null;
    }

    public Mod getEnableMod(Mod mod) {
        for (Mod mod1 : getEnabledMods()) {
            if (mod1.getName().equals(mod.getName())) {
                return mod1;
            }
        }
        return null;
    }

    public Mod getEnableMod(String name) {
        boolean isNotNull = false;
        Mod returnMod = null;
        for (Mod mod1 : getEnabledMods()) {
            if (mod1.getName().equalsIgnoreCase(name)) {
                return mod1;
            }
        }
        return null;
    }

    public void load() {
        mods.add(new Logo());
        mods.add(new ToggleSprint());
        mods.add(new AntiBlind());
        mods.add(new FullBright());
        mods.add(new ToggleZoom());
        mods.add(new woodp1anks.liquidclient.mod.mods.render.ArrayList());
        mods.add(new HitBox());
        mods.add(new TabGUI());
        mods.add(new KeyStrokes());
        mods.add(new PotionEffects());
        mods.add(new KillAura());
    }

    public void onKeyPressed(int key) {
        for (Mod mod : getMods()) {
            if (mod.getKey() == key) {
                mod.setEnabled(!mod.isEnabled());
            }
        }
    }

}
