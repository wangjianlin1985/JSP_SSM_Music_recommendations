// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.dao;

import top.wangruns.trackstacking.model.Song;
import java.util.List;
import top.wangruns.trackstacking.model.User;

public interface MyMusicDao
{
    List<Song> selectCollectedSong(User p0);
    
    List<Song> selectMyRecentSong(User p0);
}
