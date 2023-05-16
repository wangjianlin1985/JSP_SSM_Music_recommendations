// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.dao;

import top.wangruns.trackstacking.model.Collection;
import top.wangruns.trackstacking.model.User;
import top.wangruns.trackstacking.model.Song;
import java.util.List;

public interface TrendingRecDao
{
    List<Song> getTrendingSong();
    
    List<Collection> getCollection(User p0);
}
