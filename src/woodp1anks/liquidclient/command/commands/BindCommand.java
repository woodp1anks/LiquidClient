package woodp1anks.liquidclient.command.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import org.lwjgl.input.Keyboard;
import woodp1anks.liquidclient.LiquidClient;
import woodp1anks.liquidclient.command.Command;
import woodp1anks.liquidclient.mod.Mod;

public class BindCommand extends Command {
    public BindCommand() {
        super("Bind", new String[]{"bind","b"}, "bind a mod to a key", new String[]{"modName","key"});
    }

    @Override
    public void run(String[] args) {
        if (args.length == 2) {
            Mod mod = LiquidClient.modManager.getMod(args[0]);
            if (mod != null) {
                if (Keyboard.getKeyIndex(args[1].toUpperCase()) != 0) {
                    mod.setKey(Keyboard.getKeyIndex(args[1].toUpperCase()));
                    Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§b§lLiquid§3Client §7>>§e mod §a§l" + mod.getName() + "§e was bind to §d§l" + args[1]));
                } else {
                    Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§bLiquid§3Client §7>>§c key you enter is wrong!"));
                }
            } else {
                Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§bLiquid§3Client §7>>§c this mod is not exist!"));
            }
        } else {
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§bLiquid§3Client §7>>§c please enter the mod name and key!"));
        }
    }
}
