// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.service;

import top.wangruns.trackstacking.model.Song;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public interface MyMusicService
{
    List<Song> getMyCollectionWithCollectionFlag(HttpServletRequest p0);
    
    List<Song> getMyRecentPlayListWithCollectionFlag(HttpServletRequest p0);
}
