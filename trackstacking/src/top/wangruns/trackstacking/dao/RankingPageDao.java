// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.dao;

import top.wangruns.trackstacking.model.Song;
import java.util.List;

public interface RankingPageDao
{
    List<Song> selectRecentWeekRanking();
    
    List<Song> selectRecentMonthRanking();
}
