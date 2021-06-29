package net.minesucht.warn.commands;

import net.minesucht.warn.manager.MessageManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * @author KeinByte
 * @since 29.06.2021
 */

public class WarnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (command.getName().equalsIgnoreCase("warn")){
            if (commandSender.hasPermission("network.command.warn")){
                if (strings.length == 2){
                    
                }
            }
        }

        return false;
    }
}
