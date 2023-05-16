// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.service.impl;

import top.wangruns.trackstacking.model.Collection;
import java.util.Iterator;
import top.wangruns.trackstacking.model.User;
import top.wangruns.trackstacking.utils.Request;
import java.util.ArrayList;
import top.wangruns.trackstacking.model.Song;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import top.wangruns.trackstacking.dao.TrendingRecDao;
import top.wangruns.trackstacking.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import top.wangruns.trackstacking.dao.MyMusicDao;
import org.springframework.stereotype.Service;
import top.wangruns.trackstacking.service.MyMusicService;

@Service("myMusicService")
public class MyMusicServiceImpl implements MyMusicService
{
    @Autowired
    private MyMusicDao myMusicDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private TrendingRecDao trendingRecDao;
    
    public List<Song> getMyCollectionWithCollectionFlag(final HttpServletRequest request) {
        List<Song> myCollectionList = new ArrayList<Song>();
        final User user = this.userDao.selectByUser(Request.getUserFromHttpServletRequest(request));
        myCollectionList = this.myMusicDao.selectCollectedSong(user);
        if (myCollectionList != null) {
            for (final Song t : myCollectionList) {
                t.setWhetherCollected(true);
            }
        }
        return myCollectionList;
    }
    
    public List<Song> getMyRecentPlayListWithCollectionFlag(final HttpServletRequest request) {
        List<Song> myRecentPalyList = new ArrayList<Song>();
        List<Collection> collectionList = new ArrayList<Collection>();
        final User user = this.userDao.selectByUser(Request.getUserFromHttpServletRequest(request));
        myRecentPalyList = this.myMusicDao.selectMyRecentSong(user);
        collectionList = this.trendingRecDao.getCollection(user);
        if (collectionList != null && myRecentPalyList != null) {
            for (final Collection c : collectionList) {
                for (final Song t : myRecentPalyList) {
                    if (c.getSongId() == t.getSongId()) {
                        t.setWhetherCollected(true);
                    }
                }
            }
        }
        return myRecentPalyList;
    }
}
