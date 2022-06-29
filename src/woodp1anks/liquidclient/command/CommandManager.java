package woodp1anks.liquidclient.command;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import woodp1anks.liquidclient.command.commands.*;

import java.util.*;

public class CommandManager {
    private final Map<String[],Command> commandMap = new HashMap<>();

    public void load() {
        HelpCommand helpCommand = new HelpCommand();
        ToggleCommand toggleCommand = new ToggleCommand();
        BindCommand bindCommand = new BindCommand();
        SetCommand setCommand = new SetCommand();
        ModListCommand modListCommand = new ModListCommand();

        commandMap.put(helpCommand.getKey(),helpCommand);
        commandMap.put(toggleCommand.getKey(),toggleCommand);
        commandMap.put(bindCommand.getKey(),bindCommand);
        commandMap.put(setCommand.getKey(),setCommand);
        commandMap.put(modListCommand.getKey(),modListCommand);
    }

    public boolean run(String message) {

        if ('~' == (message.charAt(0))) {

            String cmd = message.substring(1);

            // 从空格分割出所有参数
            String[] cmdArgs = cmd.split(" ");

            String key = cmdArgs[0];
            Command command = getCommand(key);

            if (command != null) {
                List<String> args = new ArrayList<>();
                Collections.addAll(args,cmdArgs);
                args.remove(0);
                command.run(args.toArray(new String[0]));
            } else {
                Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§bLiquid§3Client §7>>§c this command is not exist!use ~help to get help!"));
            }

            return true;
        }

        return false;
    }

    public Command getCommand(String key) {
        for (Map.Entry<String[],Command> commandEntry : commandMap.entrySet()) {
            for (String s : commandEntry.getKey()) {
                if (s.equalsIgnoreCase(key)) {
                    return commandEntry.getValue();
                }
            }
        }
        return null;
    }

    public Map<String[], Command> getCommandMap() {
        return commandMap;
    }

    public List<Command> getCommands() {
        List<Command> commands = new ArrayList<>();
        for (Map.Entry<String[],Command> commandEntry : commandMap.entrySet()) {
            commands.add(commandEntry.getValue());
        }
        return commands;
    }
}
