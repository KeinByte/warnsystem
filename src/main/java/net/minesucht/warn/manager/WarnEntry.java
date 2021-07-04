package net.minesucht.warn.manager;

import net.minesucht.warn.WarnSystem;
import net.pretronic.databasequery.api.query.result.QueryResultEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author KeinByte
 * @since 04.07.2021
 */

public class WarnEntry {

    public static void addWarn(String reason, UUID warned_player_uuid, UUID warn_teamler_uuid) {
        WarnSystem.getInstance().getDatabaseManager().getDatabaseCollection().insert()
                .set("warn_reason", reason)
                .set("warn_player_uuid", warned_player_uuid)
                .set("warn_teamler_uuid", warn_teamler_uuid)
                .set("warn_time_created", System.currentTimeMillis())
                .execute();
    }

    public static List<HistoryEntry> getWarns(UUID uuid) {
        List<HistoryEntry> arrayList = new ArrayList<>();
        for(QueryResultEntry resultEntry : WarnSystem.getInstance().getDatabaseManager().getDatabaseCollection().find().where("warn_player_uuid", uuid).execute().asList()) {
            arrayList.add(new HistoryEntry(resultEntry.getInt("warn_id"), resultEntry.getUniqueId("warn_player_uuid"), resultEntry.getUniqueId("warn_teamler_uuid"),
                    resultEntry.getString("warn_reason"), resultEntry.getLong("warn_time_created")));
        }
        return arrayList;
    }

    public static void removeWarn(int iD) {
        WarnSystem.getInstance().getDatabaseManager().getDatabaseCollection().delete()
                .where("warn_id", iD)
                .executeAsync();
    }

    public static boolean warnIDExists(int iD) {
        return !WarnSystem.getInstance().getDatabaseManager().getDatabaseCollection().find().where("warn_id", iD).execute().isEmpty();
    }

}
