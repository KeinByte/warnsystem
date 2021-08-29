package eu.bytis.warnsystem.manager;

import org.bukkit.command.CommandSender;

/**
 * @author KeinByte
 * @since 29.06.2021
 */

public class MessageManager {

    public static String PREFIX = "§8[§cWarn§8] §7";
    public static String NO_PERMS = PREFIX + "§7Dazu hast du §ckeine Rechte§7.";
    public static String NO_CONSOLE = PREFIX + "§7Dies ist kein Konsolen Befel.";
    public static String WARN_PLAYER_SUCCESSFUL = PREFIX + "§7Du hast den Spieler {0} §cverwarnt§7.";
    public static String PLAYER_WAS_WARNED_CHAT_MESSAGE = PREFIX + "§7Du wurdest §cverwarnt§7. Grund§8: §7{Grund}";
    public static String PLAYER_WAS_WARNED_TITLE_SCREEN_FIRST_LINE = "§8» §cVerwarnung";
    public static String PLAYER_WAS_WARNED_TITLE_SCREEN_SECOND_LINE = "§7Grund§8: §7{Grund}";

    public static void getTeamHelpMessage(CommandSender commandSender){
        commandSender.sendMessage(PREFIX + "§e/warn §8<§eName§8> <§eGrund§8> §c➟ §7Verwarne einen Spieler.");
        commandSender.sendMessage(PREFIX + "§e/warnlog §8<§eName§8> §c➟ §7Erhalte Einblick in die bisherigen Verwarnungen des Spielers.");
    }

    public static void getAdminHelp(CommandSender commandSender){
        commandSender.sendMessage(PREFIX + "§e/wadmin §8remove <§eID§8> §c➟ §7Entferne einen Warn.");
    }

}
