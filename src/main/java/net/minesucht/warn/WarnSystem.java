package net.minesucht.warn;

import net.minesucht.warn.commands.WarnAdminCommand;
import net.minesucht.warn.commands.WarnCommand;
import net.minesucht.warn.commands.WarnLogCommand;
import net.minesucht.warn.mysql.DatabaseManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author KeinByte
 * @since 28.06.2021
 */

public class WarnSystem extends JavaPlugin {

    private static WarnSystem instance;

    private DatabaseManager databaseManager;

    @Override
    public void onEnable() {
        instance = this;

        this.databaseManager = new DatabaseManager();
        databaseManager.createConnection();

        getCommand("warn").setExecutor(new WarnCommand());
        getCommand("warnlog").setExecutor(new WarnLogCommand());
        getCommand("wadmin").setExecutor(new WarnAdminCommand());

    }

    @Override
    public void onDisable() {

        if(databaseManager.isConnected())
            databaseManager.deleteConnection();

    }

    public static WarnSystem getInstance() {
        return instance;
    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }
}
