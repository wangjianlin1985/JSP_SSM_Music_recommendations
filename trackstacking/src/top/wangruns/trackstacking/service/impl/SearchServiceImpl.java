// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.service.impl;

import top.wangruns.trackstacking.model.Review;
import java.util.Iterator;
import top.wangruns.trackstacking.model.User;
import top.wangruns.trackstacking.utils.Request;
import top.wangruns.trackstacking.model.Collection;
import java.util.ArrayList;
import top.wangruns.trackstacking.model.Song;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import top.wangruns.trackstacking.dao.TrendingRecDao;
import top.wangruns.trackstacking.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import top.wangruns.trackstacking.dao.SearchDao;
import org.springframework.stereotype.Service;
import top.wangruns.trackstacking.service.SearchService;

@Service("searchService")
public class SearchServiceImpl implements SearchService
{
    @Autowired
    private SearchDao searchDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private TrendingRecDao trendingRecDao;
    
    public List<Song> getSearchSongWithCollectionFlag(final HttpServletRequest request, final String keyword) {
        List<Song> searchSongList = new ArrayList<Song>();
        List<Collection> collectionList = new ArrayList<Collection>();
        final User user = this.userDao.selectByUser(Request.getUserFromHttpServletRequest(request));
        collectionList = this.trendingRecDao.getCollection(user);
        searchSongList = this.searchDao.selectSongLikeKeyword(keyword);
        if (collectionList != null && searchSongList != null) {
            for (final Collection c : collectionList) {
                for (final Song t : searchSongList) {
                    if (c.getSongId() == t.getSongId()) {
                        t.setWhetherCollected(true);
                    }
                }
            }
        }
        return searchSongList;
    }
    
    public List<Review> getSearchReview(final String keyword) {
        List<Review> searchReviewList = new ArrayList<Review>();
        searchReviewList = this.searchDao.selectReviewLikeKeyword(keyword);
        return searchReviewList;
    }
    
    public List<User> getSearchUser(final HttpServletRequest request, final String keyword) {
        final User user = this.userDao.selectByUser(Request.getUserFromHttpServletRequest(request));
        List<User> searchUserList = new ArrayList<User>();
        searchUserList = this.searchDao.selectUserLikeKeyword(keyword, user.getUserId());
        return searchUserList;
    }
    
    public List<Song> getSearchSong(final String keyword) {
        List<Song> searchSongList = new ArrayList<Song>();
        searchSongList = this.searchDao.selectSongLikeKeyword(keyword);
        return searchSongList;
    }
}
