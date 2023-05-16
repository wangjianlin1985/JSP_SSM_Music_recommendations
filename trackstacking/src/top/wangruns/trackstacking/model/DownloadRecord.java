// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.model;

public class DownloadRecord
{
    private int downloadId;
    private int userId;
    private int songId;
    
    public DownloadRecord() {
    }
    
    public DownloadRecord(final int userId, final int songId) {
        this.userId = userId;
        this.songId = songId;
    }
    
    public int getDownloadId() {
        return this.downloadId;
    }
    
    public void setDownloadId(final int downloadId) {
        this.downloadId = downloadId;
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
