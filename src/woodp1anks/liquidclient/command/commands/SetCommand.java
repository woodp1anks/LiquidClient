package woodp1anks.liquidclient.command.commands;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import woodp1anks.liquidclient.LiquidClient;
import woodp1anks.liquidclient.command.Command;
import woodp1anks.liquidclient.config.Config;
import woodp1anks.liquidclient.mod.Mod;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Locale;

public class SetCommand extends Command {
    public SetCommand() {
        super("Set", new String[]{"set","s"}, "change a model's settings", new String[]{"modName","key","arg"});
    }

    @Override
    public void run(String[] args) {
        LiquidClient.configManager.save();
        if (args.length == 3) {
            Config config = LiquidClient.configManager.getConfig(args[0]);
            if (config != null) {
                if (!(config.get(args[1],null) == null) && !args[1].equalsIgnoreCase("notFirstUse") && !args[1].equalsIgnoreCase("notFirstUse1")) {
                    config.set(args[1], args[2]);
                    Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§bLiquid§3Client §7>>§d§l " + args[1] + "§e was been set to§a§l " + args[2]));
                    config.syncStart();
                } else {
                    Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§bLiquid§3Client §7>>§c this key is not exist!"));
                }
            } else {
                Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§bLiquid§3Client §7>>§c you didn't need to set anything about this mod."));
            }
        } else {
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§bLiquid§3Client §7>>§c your must enter mod name,key,and arg."));
        }
    }
}
