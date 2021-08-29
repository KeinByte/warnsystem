package eu.bytis.warnsystem.commands;

import eu.bytis.warnsystem.manager.MessageManager;
import eu.bytis.warnsystem.manager.WarnEntry;
import eu.bytis.warnsystem.manager.HistoryEntry;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;

/**
 * @author KeinByte
 * @since 29.06.2021
 */

public class WarnLogCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player){
            Player player = (Player) commandSender;

            if (command.getName().equalsIgnoreCase("warnlog")){
                if (commandSender.hasPermission("network.command.warnlog")){
                    if (strings.length == 1){
                        Player targetPlayer = Bukkit.getPlayer(strings[0]);
                        if(targetPlayer != null) {
                            if(WarnEntry.getWarns(targetPlayer.getUniqueId()).size() >= 1) {
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                                for (HistoryEntry historyEntry : WarnEntry.getWarns(targetPlayer.getUniqueId())) {
                                    player.sendMessage("§8§m---------------------------------------------§r");
                                    Player creator = Bukkit.getPlayer(historyEntry.getCreator());
                                    if (creator != null) {
                                        player.sendMessage("§7Verwarnung §8#§e" + historyEntry.getId() + "\n" +
                                                "§7Datum§8: §e" + simpleDateFormat.format(historyEntry.getTimeCreated()) + "\n" +
                                                "§7Ersteller§8: §e" + creator.getName() + "\n" +
                                                "§7Grund§8: §e" + historyEntry.getReason());
                                    } else {
                                        OfflinePlayer offlineCreator = Bukkit.getOfflinePlayer(historyEntry.getCreator());
                                        player.sendMessage("§7Verwarnung §8#§e" + historyEntry.getId() + "\n" +
                                                "§7Datum§8: §e" + simpleDateFormat.format(historyEntry.getTimeCreated()) + "\n" +
                                                "§7Ersteller§8: §e" + offlineCreator.getName() + "\n" +
                                                "§7Grund§8: §e" + historyEntry.getReason());
                                    }
                                    player.sendMessage("§8§m---------------------------------------------§r");
                                }
                            } else {
                                player.sendMessage(MessageManager.PREFIX + "§7Der Spieler wurde noch §cnie §7verwarnt.");
                            }
                        } else {
                            OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(strings[0]);
                            if(WarnEntry.getWarns(offlinePlayer.getUniqueId()).size() >= 1) {
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                                for (HistoryEntry historyEntry : WarnEntry.getWarns(offlinePlayer.getUniqueId())) {
                                    player.sendMessage("§8§m---------------------------------------------§r");
                                    Player creator = Bukkit.getPlayer(historyEntry.getCreator());
                                    if (creator != null) {
                                        player.sendMessage("§7Verwarnung §8#§e" + historyEntry.getId() + "\n" +
                                                "§7Datum§8: §e" + simpleDateFormat.format(historyEntry.getTimeCreated()) + "\n" +
                                                "§7Ersteller§8: §e" + creator.getName() + "\n" +
                                                "§7Grund§8: §e" + historyEntry.getReason());
                                    } else {
                                        OfflinePlayer offlineCreator = Bukkit.getOfflinePlayer(historyEntry.getCreator());
                                        player.sendMessage("§7Verwarnung §8#§e" + historyEntry.getId() + "\n" +
                                                "§7Datum§8: §e" + simpleDateFormat.format(historyEntry.getTimeCreated()) + "\n" +
                                                "§7Ersteller§8: §e" + offlineCreator.getName() + "\n" +
                                                "§7Grund§8: §e" + historyEntry.getReason());
                                    }
                                    player.sendMessage("§8§m---------------------------------------------§r");
                                }
                            } else {
                                player.sendMessage(MessageManager.PREFIX + "§7Der Spieler wurde noch §cnie §7verwarnt.");
                            }
                        }
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
