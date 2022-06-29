package woodp1anks.liquidclient.command.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import woodp1anks.liquidclient.LiquidClient;
import woodp1anks.liquidclient.command.Command;
import woodp1anks.liquidclient.mod.Mod;

public class ToggleCommand extends Command {
    public ToggleCommand() {
        super("Toggle",new String[]{"t","toggle"},"toggle a mod on/off.", new String[]{"modName"});
    }

    @Override
    public void run(String[] args) {
        if (args.length == 1) {
            Mod mod = LiquidClient.modManager.getMod(args[0]);
            String enabledText = "";
            if (mod != null) {
                mod.setEnabled(!mod.isEnabled());
                if (mod.isEnabled()) {enabledText = "§a§lon";} else {enabledText = "§c§loff";}
                Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§bLiquid§3Client §7>>§e mod §d§l" + mod.getName() + "§e is toggled " + enabledText));
            } else {
                Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§bLiquid§3Client §7>>§c this mod is not exist!"));
            }
        } else {
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§bLiquid§3Client §7>>§c please enter the mod name!"));
        }
    }
}
