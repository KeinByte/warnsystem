package eu.bytis.warnsystem.mysql;

import com.zaxxer.hikari.HikariDataSource;
import eu.bytis.warnsystem.WarnSystem;
import net.pretronic.databasequery.api.Database;
import net.pretronic.databasequery.api.collection.DatabaseCollection;
import net.pretronic.databasequery.api.collection.field.FieldOption;
import net.pretronic.databasequery.api.datatype.DataType;
import net.pretronic.databasequery.api.driver.DatabaseDriver;
import net.pretronic.databasequery.api.driver.DatabaseDriverFactory;
import net.pretronic.databasequery.sql.dialect.Dialect;
import net.pretronic.databasequery.sql.driver.config.SQLDatabaseDriverConfigBuilder;
import org.bukkit.Bukkit;

import java.net.InetSocketAddress;

/**
 * @author KeinByte
 * @since 04.07.2021
 */

public class DatabaseManager {



    private DatabaseDriver databaseDriver;
    private Database database;
    private DatabaseCollection databaseCollection;

    public void createConnection() {
        Bukkit.getLogger();
        databaseDriver = DatabaseDriverFactory.create(WarnSystem.getInstance().getConfig().getString("database"), new SQLDatabaseDriverConfigBuilder()
                .setDialect(Dialect.MYSQL)
                .setAddress(new InetSocketAddress(WarnSystem.getInstance().getConfig().getString("hostname"), WarnSystem.getInstance().getConfig().getInt("port")))
                .setDataSourceClassName(HikariDataSource.class.getName())
                .setUsername(WarnSystem.getInstance().getConfig().getString("username"))
                .setPassword(WarnSystem.getInstance().getConfig().getString("password"))
                .build());
        databaseDriver.connect();
        database = databaseDriver.getDatabase(WarnSystem.getInstance().getConfig().getString("database"));

        createCollection();
    }

    public void createCollection() {
        databaseCollection = database.createCollection("warn")
                .field("warn_id", DataType.INTEGER, FieldOption.PRIMARY_KEY, FieldOption.AUTO_INCREMENT)
                .field("warn_reason", DataType.STRING)
                .field("warn_player_uuid", DataType.UUID)
                .field("warn_teamler_uuid", DataType.UUID)
                .field("warn_time_created", DataType.LONG)
                .create();

    }

    public boolean isConnected() {
        return databaseDriver.isConnected();
    }

    public void deleteConnection() {
        databaseDriver.disconnect();
    }

    public DatabaseCollection getDatabaseCollection() {
        return databaseCollection;
    }

}
