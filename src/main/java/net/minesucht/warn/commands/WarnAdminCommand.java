package net.minesucht.warn.commands;

import net.minesucht.warn.manager.MessageManager;
import net.minesucht.warn.manager.WarnEntry;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author KeinByte
 * @since 04.07.2021
 */

public class WarnAdminCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player){
            Player player = (Player) commandSender;
            if (command.getName().equalsIgnoreCase("wadmin")){
                if (player.hasPermission("network.command.warnadmin")){
                    if (strings.length == 2){
                        if(strings[0].equalsIgnoreCase("remove")) {
                            try {
                                int iD = Integer.parseInt(strings[1]);
                                if(WarnEntry.warnIDExists(iD)) {
                                    player.sendMessage(MessageManager.PREFIX + "§7Du hast den §cWarn §7mit der ID: §e" + iD + " §cgelöscht.");
                                    WarnEntry.removeWarn(iD);
                                }else{
                                    player.sendMessage(MessageManager.PREFIX + "§7Diese ID ist §cnicht §7vorhanden.");
                                }
                            }catch (NumberFormatException exception){
                                player.sendMessage(MessageManager.PREFIX + "§7Dies ist §ckeine §7gültige ID.");
                            }
                        }else{
                            MessageManager.getAdminHelp(player);
                        }
                    }else{
                        MessageManager.getAdminHelp(player);
                    }
                }else{
                    player.sendMessage(MessageManager.NO_PERMS);
                }
            }
        }else{
            commandSender.sendMessage(MessageManager.NO_CONSOLE);
        }

        return false;
    }
}
