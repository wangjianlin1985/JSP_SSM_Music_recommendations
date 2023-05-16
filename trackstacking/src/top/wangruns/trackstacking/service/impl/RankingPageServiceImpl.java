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
import top.wangruns.trackstacking.dao.RankingPageDao;
import org.springframework.stereotype.Service;
import top.wangruns.trackstacking.service.RankingPageService;

@Service("rankingPageService")
public class RankingPageServiceImpl implements RankingPageService
{
    @Autowired
    private RankingPageDao rankingPageDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private TrendingRecDao trendingRecDao;
    
    public List<Song> getRankWithCollectionFlag(final HttpServletRequest request, final int mode) {
        List<Song> rankingPageList = new ArrayList<Song>();
        List<Collection> collectionList = new ArrayList<Collection>();
        final User user = this.userDao.selectByUser(Request.getUserFromHttpServletRequest(request));
        collectionList = this.trendingRecDao.getCollection(user);
        if (mode == 1) {
            rankingPageList = this.rankingPageDao.selectRecentWeekRanking();
        }
        else if (mode == 2) {
            rankingPageList = this.rankingPageDao.selectRecentMonthRanking();
        }
        else {
            rankingPageList = this.rankingPageDao.selectRecentMonthRanking();
        }
        if (collectionList != null && rankingPageList != null) {
            for (final Collection c : collectionList) {
                for (final Song t : rankingPageList) {
                    if (c.getSongId() == t.getSongId()) {
                        t.setWhetherCollected(true);
                    }
                }
            }
        }
        return rankingPageList;
    }
}
