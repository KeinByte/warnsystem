package net.minesucht.warn.manager;

import org.bukkit.command.CommandSender;

/**
 * @author KeinByte
 * @since 29.06.2021
 */

public class MessageManager {

    public static String PREFIX = "§8[§cWarn§8] §7";
    public static String WARN_PLAYER_SUCCESSFUL = PREFIX + "§7Du hast den Spieler {0} §cverwarnt§7.";
    public static String PLAYER_WAS_WARNED_CHAT_MESSAGE = "";
    public static String PLAYER_WAS_WARNED_TITLE_SCREEN_FIRST_LINE = "";
    public static String PLAYER_WAS_WARNED_TITLE_SCREEN_SECOND_LINE = "";

    public static void getHelpMessage(CommandSender commandSender){
        commandSender.sendMessage(PREFIX + "§e/warn §8<§eName§8> <§eGrund§8> §c➟ §7Verwarne einen Spieler.");
        commandSender.sendMessage(PREFIX + "§e/warnlog §8<§eName§8> §c➟ §7Erhalte Einblick in die bisherigen Verwarnungen des Spielers.");
    }

}
