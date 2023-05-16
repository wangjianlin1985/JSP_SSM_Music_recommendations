// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.dao;

import top.wangruns.trackstacking.model.User;
import top.wangruns.trackstacking.model.Review;
import top.wangruns.trackstacking.model.Song;
import java.util.List;

public interface SearchDao
{
    List<Song> selectSongLikeKeyword(String p0);
    
    List<Review> selectReviewLikeKeyword(String p0);
    
    List<User> selectUserLikeKeyword(String p0, int p1);
}
