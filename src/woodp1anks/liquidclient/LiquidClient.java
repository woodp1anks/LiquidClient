package woodp1anks.liquidclient;

import org.lwjgl.opengl.Display;
import woodp1anks.liquidclient.command.CommandManager;
import woodp1anks.liquidclient.misc.Rainbow;
import woodp1anks.liquidclient.config.ConfigManager;
import woodp1anks.liquidclient.mod.ModManager;

import java.awt.*;

public class LiquidClient {
    public static final String NAME = "LiquidClient";
    public static final String VERSION = "0.1.0";
    public static final Color MAIN_COLOR = new Color(64, 198, 245);
    public static final Color NOT_MAIN_COLOR = new Color(75,150,255);
    public static Rainbow rainbow;
    public static ModManager modManager;
    public static ConfigManager configManager;
    public static CommandManager commandManager;

    public static void start() {
        modManager = new ModManager();
        configManager = new ConfigManager();
        commandManager = new CommandManager();

        modManager.load();
        configManager.load();
        commandManager.load();

        rainbow = new Rainbow(160,160,160,255,255,255,5);

        Display.setTitle(NAME + " | " + VERSION);
    }

    public static void stop() {
        System.out.println("[LiquidClient]Stopping LiquidClient,please wait...");

        configManager.save();
    }
}
