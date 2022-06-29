package woodp1anks.liquidclient.command.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import org.lwjgl.input.Keyboard;
import woodp1anks.liquidclient.LiquidClient;
import woodp1anks.liquidclient.command.Command;
import woodp1anks.liquidclient.mod.Mod;

public class ModListCommand extends Command {
    public ModListCommand() {
        super("ModList", new String[]{"modList","mods","m","ml"}, "show all mods in liquid client.", new String[]{});
    }

    @Override
    public void run(String[] args) {
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§bLiquid§3Client §7-§e mod list §7>>"));
        for (Mod mod : LiquidClient.modManager.getMods()) {
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§7> §e" + mod.getName() + " §a" + Keyboard.getKeyName(mod.getKey())));
        }
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§7-------------------------------"));
    }
}
