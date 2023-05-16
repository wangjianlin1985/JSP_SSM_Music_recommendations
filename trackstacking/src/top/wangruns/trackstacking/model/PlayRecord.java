// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.model;

public class PlayRecord
{
    private int playId;
    private int userId;
    private int songId;
    
    public PlayRecord() {
    }
    
    public PlayRecord(final int userId, final int songId) {
        this.userId = userId;
        this.songId = songId;
    }
    
    public int getPlayId() {
        return this.playId;
    }
    
    public void setPlayId(final int playId) {
        this.playId = playId;
    }
    
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(final int userId) {
        this.userId = userId;
    }
    
    public int getSongId() {
        return this.songId;
    }
    
    public void setSongId(final int songId) {
        this.songId = songId;
    }
}
