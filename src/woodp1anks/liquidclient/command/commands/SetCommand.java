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
            Mod mod = LiquidClient.modManager.getMod(args[0]);
            if (mod != null) {
                Config config = LiquidClient.configManager.getConfig(args[0]);
                if (config != null) {
                    JsonObject configJson;
                    try {
                        configJson = new Gson().fromJson(new String(Files.readAllBytes(config.getPath()), StandardCharsets.UTF_8), JsonObject.class);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    if (configJson.has(args[1].toLowerCase(Locale.ROOT))) {
                        configJson.addProperty(args[1].toLowerCase(),args[2]);
                        try {
                            Files.write(config.getPath(),configJson.toString().getBytes(StandardCharsets.UTF_8));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        LiquidClient.configManager.load();
                        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§bLiquid§3Client §7>> §d§l" + mod.getName() + "§e's §a§l" + args[1] + "§e was set to §b§l" + args[2]));
                    } else {
                        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§bLiquid§3Client §7>>§c this key is not exist!"));
                    }
                } else {
                    Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§bLiquid§3Client §7>>§c you didn't need to set anything about this mod."));
                }
            } else {
                Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§bLiquid§3Client §7>>§c this mod is not exist."));
            }
        } else {
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§bLiquid§3Client §7>>§c your must enter mod name,key,and arg."));
        }
    }
}
