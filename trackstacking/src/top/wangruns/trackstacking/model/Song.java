// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.model;

public class Song
{
    private int songId;
    private String songName;
    private String songAddress;
    private String songCoverAddress;
    private String songType;
    private int songLength;
    private String lyricName;
    private String lyricAddress;
    private int trendingCoefficient;
    private boolean whetherCollected;
    
    public Song(final String songName, final String songAddress) {
        this.songName = songName;
        this.songAddress = songAddress;
    }
    
    public Song(final String songName, final String songAddress, final String lyricName, final String lyricAddress) {
        this.songName = songName;
        this.songAddress = songAddress;
        this.lyricName = lyricName;
        this.lyricAddress = lyricAddress;
    }
    
    public Song() {
    }
    
    public int getTrendingCoefficient() {
        return this.trendingCoefficient;
    }
    
    public void setTrendingCoefficient(final int trendingCoefficient) {
        this.trendingCoefficient = trendingCoefficient;
    }
    
    public boolean isWhetherCollected() {
        return this.whetherCollected;
    }
    
    public void setWhetherCollected(final boolean whetherCollected) {
        this.whetherCollected = whetherCollected;
    }
    
    public String getLyricName() {
        return this.lyricName;
    }
    
    public void setLyricName(final String lyricName) {
        this.lyricName = lyricName;
    }
    
    public String getLyricAddress() {
        return this.lyricAddress;
    }
    
    public void setLyricAddress(final String lyricAddress) {
        this.lyricAddress = lyricAddress;
    }
    
    public String getSongCoverAddress() {
        return this.songCoverAddress;
    }
    
    public void setSongCoverAddress(final String songCoverAddress) {
        this.songCoverAddress = songCoverAddress;
    }
    
    public String getSongType() {
        return this.songType;
    }
    
    public void setSongType(final String songType) {
        this.songType = songType;
    }
    
    public int getSongLength() {
        return this.songLength;
    }
    
    public void setSongLength(final int songLength) {
        this.songLength = songLength;
    }
    
    public int getSongId() {
        return this.songId;
    }
    
    public void setSongId(final int songId) {
        this.songId = songId;
    }
    
    public String getSongName() {
        return this.songName;
    }
    
    public void setSongName(final String songName) {
        this.songName = songName;
    }
    
    public String getSongAddress() {
        return this.songAddress;
    }
    
    public void setSongAddress(final String songAddress) {
        this.songAddress = songAddress;
    }
}
