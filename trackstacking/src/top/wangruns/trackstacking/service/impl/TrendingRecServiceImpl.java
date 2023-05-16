// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.service.impl;

import java.util.Iterator;
import top.wangruns.trackstacking.model.User;
import top.wangruns.trackstacking.utils.Request;
import top.wangruns.trackstacking.model.Collection;
import java.util.ArrayList;
import top.wangruns.trackstacking.model.Song;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import top.wangruns.trackstacking.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import top.wangruns.trackstacking.dao.TrendingRecDao;
import org.springframework.stereotype.Service;
import top.wangruns.trackstacking.service.TrendingRecService;

@Service("trendingService")
public class TrendingRecServiceImpl implements TrendingRecService
{
    @Autowired
    private TrendingRecDao trendingRecDao;
    @Autowired
    private UserDao userDao;
    
    public List<Song> getSongWithCollectionFlag(final HttpServletRequest request) {
        List<Song> trendingRecList = new ArrayList<Song>();
        List<Collection> collectionList = new ArrayList<Collection>();
        final User user = this.userDao.selectByUser(Request.getUserFromHttpServletRequest(request));
        collectionList = this.trendingRecDao.getCollection(user);
        trendingRecList = this.trendingRecDao.getTrendingSong();
        if (collectionList != null && trendingRecList != null) {
            for (final Collection c : collectionList) {
                for (final Song t : trendingRecList) {
                    if (c.getSongId() == t.getSongId()) {
                        t.setWhetherCollected(true);
                    }
                }
            }
        }
        return trendingRecList;
    }
}
