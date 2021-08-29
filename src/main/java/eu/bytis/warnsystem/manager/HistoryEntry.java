package eu.bytis.warnsystem.manager;

import java.util.UUID;

/**
 * @author KeinByte
 * @since 04.07.2021
 */

public class HistoryEntry {

    private final int iD;
    private final UUID player;
    private final UUID creator;
    private final String reason;
    private final long timeCreated;

    public HistoryEntry(int iD, UUID player, UUID creator, String reason, long timeCreated) {
        this.iD = iD;
        this.player = player;
        this.creator = creator;
        this.reason = reason;
        this.timeCreated = timeCreated;
    }

    public int getId() {
        return iD;
    }

    public UUID getPlayer() {
        return player;
    }

    public UUID getCreator() {
        return creator;
    }

    public String getReason() {
        return reason;
    }

    public long getTimeCreated() {
        return timeCreated;
    }
}
