// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.service;

import top.wangruns.trackstacking.model.Song;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public interface TrendingRecService
{
    List<Song> getSongWithCollectionFlag(HttpServletRequest p0);
}
