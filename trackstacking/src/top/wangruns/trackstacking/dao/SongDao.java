// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.dao;

import top.wangruns.trackstacking.model.Song;
import java.util.List;

public interface SongDao
{
    List<Integer> selectAllSongId();
    
    Song selectSongById(int p0);
    
    int selectCoefficientById(int p0);
    
    void deleteByIds(int[] p0);
    
    int insertOnlySong(Song p0);
    
    int insertSongWithLyric(Song p0);
    
    List<Song> selectAllSongsWithLyric();
}
