// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.model;

public class Collection
{
    private int collectionId;
    private int userId;
    private int songId;
    
    public Collection() {
    }
    
    public Collection(final int userId, final int songId) {
        this.userId = userId;
        this.songId = songId;
    }
    
    public int getCollectionId() {
        return this.collectionId;
    }
    
    public void setCollectionId(final int collectionId) {
        this.collectionId = collectionId;
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
