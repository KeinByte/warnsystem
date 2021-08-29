package eu.bytis.warnsystem;

import eu.bytis.warnsystem.commands.WarnAdminCommand;
import eu.bytis.warnsystem.commands.WarnCommand;
import eu.bytis.warnsystem.commands.WarnLogCommand;
import eu.bytis.warnsystem.mysql.DatabaseManager;
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

        registerConfig();
        registerDatabase();
        registerCommands();

    }

    @Override
    public void onDisable() {

        if(databaseManager.isConnected())
            databaseManager.deleteConnection();

    }

    private void registerCommands(){
        getCommand("warn").setExecutor(new WarnCommand());
        getCommand("warnlog").setExecutor(new WarnLogCommand());
        getCommand("wadmin").setExecutor(new WarnAdminCommand());
    }

    private void registerDatabase(){
        this.databaseManager = new DatabaseManager();
        databaseManager.createConnection();
    }

    private void registerConfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
        reloadConfig();
    }

    public static WarnSystem getInstance() {
        return instance;
    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }
}
