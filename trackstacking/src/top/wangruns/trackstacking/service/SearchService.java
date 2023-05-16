// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.service;

import top.wangruns.trackstacking.model.User;
import top.wangruns.trackstacking.model.Review;
import top.wangruns.trackstacking.model.Song;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public interface SearchService
{
    List<Song> getSearchSongWithCollectionFlag(HttpServletRequest p0, String p1);
    
    List<Review> getSearchReview(String p0);
    
    List<User> getSearchUser(HttpServletRequest p0, String p1);
    
    List<Song> getSearchSong(String p0);
}
