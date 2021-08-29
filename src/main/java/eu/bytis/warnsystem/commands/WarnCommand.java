package eu.bytis.warnsystem.commands;

import eu.bytis.warnsystem.manager.MessageManager;
import eu.bytis.warnsystem.manager.WarnEntry;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author KeinByte
 * @since 29.06.2021
 */

public class WarnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player){
            Player player = (Player) commandSender;

            if (command.getName().equalsIgnoreCase("warn")){
                if (commandSender.hasPermission("network.command.warn")){
                    if (strings.length >= 2){

                        String reasons = "";
                        StringBuilder reason = new StringBuilder();
                        for (int i = 1; i < strings.length; i++) {
                            reason.append(" ").append(strings[i]);
                        }
                        reasons = reason + "";
                        Player targetPlayer = Bukkit.getPlayer(strings[0]);

                        if (targetPlayer != null){

                            player.sendMessage(MessageManager.WARN_PLAYER_SUCCESSFUL.replace("{0}", targetPlayer.getName()));
                            targetPlayer.sendTitle(MessageManager.PLAYER_WAS_WARNED_TITLE_SCREEN_FIRST_LINE, MessageManager.PLAYER_WAS_WARNED_TITLE_SCREEN_SECOND_LINE.replace("{Grund}", reasons));
                            targetPlayer.sendMessage(MessageManager.PLAYER_WAS_WARNED_CHAT_MESSAGE.replace("{Grund}", reasons));
                            WarnEntry.addWarn(reasons, targetPlayer.getUniqueId(), player.getUniqueId());

                        }else{
                            player.sendMessage("OFFLINE");
                        }

                    }else{
                        MessageManager.getTeamHelpMessage(commandSender);
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
