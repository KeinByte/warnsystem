package net.minesucht.warn.manager;

import java.util.UUID;

/**
 * @author KeinByte
 * @since 04.07.2021
 */

public class HistoryEntry {

    private int iD;
    private UUID player;
    private UUID creator;
    private String reason;
    private long timeCreated;

    public HistoryEntry(int iD, UUID player, UUID creator, String reason, long timeCreated) {
        this.iD = iD;
        this.player = player;
        this.creator = creator;
        this.reason = reason;
        this.timeCreated = timeCreated;
    }

    public int getiD() {
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
