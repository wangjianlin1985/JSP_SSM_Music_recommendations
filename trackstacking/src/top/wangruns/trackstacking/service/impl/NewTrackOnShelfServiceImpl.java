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
import top.wangruns.trackstacking.dao.TrendingRecDao;
import top.wangruns.trackstacking.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import top.wangruns.trackstacking.dao.NewTrackOnShelfDao;
import org.springframework.stereotype.Service;
import top.wangruns.trackstacking.service.NewTrackOnShelfService;

@Service("newTrackOnShelfService")
public class NewTrackOnShelfServiceImpl implements NewTrackOnShelfService
{
    @Autowired
    private NewTrackOnShelfDao newTrackOnShelfDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private TrendingRecDao trendingRecDao;
    
    public List<Song> getNewTrackWithCollectionFlag(final HttpServletRequest request) {
        List<Song> newTackOnShelList = new ArrayList<Song>();
        List<Collection> collectionList = new ArrayList<Collection>();
        final User user = this.userDao.selectByUser(Request.getUserFromHttpServletRequest(request));
        collectionList = this.trendingRecDao.getCollection(user);
        newTackOnShelList = this.newTrackOnShelfDao.selecNewSong();
        if (collectionList != null && newTackOnShelList != null) {
            for (final Collection c : collectionList) {
                for (final Song t : newTackOnShelList) {
                    if (c.getSongId() == t.getSongId()) {
                        t.setWhetherCollected(true);
                    }
                }
            }
        }
        return newTackOnShelList;
    }
}
