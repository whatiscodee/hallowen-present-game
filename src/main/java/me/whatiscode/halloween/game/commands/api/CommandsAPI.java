package me.whatiscode.halloween.game.commands.api;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.whatiscode.halloween.game.HallowenPlugin;
import me.whatiscode.halloween.game.commands.iterfaces.IArenaCommandHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CommandsAPI {

    Map<String, IArenaCommandHandler> COMMANDS_MAP = new HashMap<>();
    CommandMap commandMap;

    public CommandsAPI(CommandMap commandMap) {
        this.commandMap = commandMap;
    }

    public void registerCommand(String name, IArenaCommandHandler handler) {
        Command command = new BukkitCommand(name) {
            @Override
            public boolean execute(CommandSender sender, String label, String[] args) {
                IArenaCommandHandler handler = COMMANDS_MAP.get(label.toLowerCase());

                if (handler != null) {
                    return handler.onCommand(sender, args);
                }

                return false;
            }
        };

        commandMap.register(HallowenPlugin.getInstance().getName(), command);
    }

    private CommandMap getCommandMap() {
        try {
            Field field = Bukkit.
                    getServer()
                    .getClass()
                    .getDeclaredField("commandMap");
            field.setAccessible(true);

            return (CommandMap) field.get(Bukkit.getServer());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
