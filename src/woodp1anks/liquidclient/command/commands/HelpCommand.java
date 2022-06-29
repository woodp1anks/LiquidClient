package woodp1anks.liquidclient.command.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import woodp1anks.liquidclient.LiquidClient;
import woodp1anks.liquidclient.command.Command;

import java.util.Arrays;
import java.util.List;

public class HelpCommand extends Command {
    public HelpCommand() {
        super("Help",new String[]{"help","h"},"list all the commands.", new String[]{});
    }

    @Override
    public void run(String[] args) {
        List<Command> commands = LiquidClient.commandManager.getCommands();
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§bLiquid§3Client §7-§e help(command list) §7>>"));
        for (Command command : commands) {
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§7> §a" + command.getName() + " §e" + Arrays.toString(command.getKey()) + " §b" + Arrays.toString(command.getArgNames()) + " §7" + command.getDescription()));
        }
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§7-------------------------------"));
    }
}
