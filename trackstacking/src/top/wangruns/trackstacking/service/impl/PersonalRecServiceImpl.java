// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.service.impl;

import java.util.function.BiConsumer;
import java.util.Map;
import java.util.Random;
import top.wangruns.trackstacking.utils.Static;
import java.util.Iterator;
import top.wangruns.trackstacking.model.User;
import top.wangruns.trackstacking.utils.Request;
import top.wangruns.trackstacking.model.Collection;
import java.util.ArrayList;
import top.wangruns.trackstacking.model.Song;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import top.wangruns.trackstacking.dao.NewTrackOnShelfDao;
import top.wangruns.trackstacking.dao.TrendingRecDao;
import top.wangruns.trackstacking.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import top.wangruns.trackstacking.dao.PersonalRecDao;
import org.springframework.stereotype.Service;
import top.wangruns.trackstacking.service.PersonalRecService;

@Service("personalRecService")
public class PersonalRecServiceImpl implements PersonalRecService
{
    @Autowired
    private PersonalRecDao personalRecDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private TrendingRecDao trendingRecDao;
    @Autowired
    private NewTrackOnShelfDao newTrackOnShelfDao;
    
    public List<Song> getPersonalDailyRecWithCollectionFlag(final HttpServletRequest request) {
        List<Song> personalRecList = new ArrayList<Song>();
        List<Collection> collectionList = new ArrayList<Collection>();
        final User user = this.userDao.selectByUser(Request.getUserFromHttpServletRequest(request));
        collectionList = this.trendingRecDao.getCollection(user);
        personalRecList = this.selectPersonalRec(user);
        if (collectionList != null && personalRecList != null) {
            for (final Collection c : collectionList) {
                for (final Song t : personalRecList) {
                    if (c.getSongId() == t.getSongId()) {
                        t.setWhetherCollected(true);
                    }
                }
            }
        }
        return personalRecList;
    }
    
    private List<Song> selectPersonalRec(final User user) {
        if (user == null) {
            return null;
        }
        List<Song> personalRecList = new ArrayList<Song>();
        if (Static.isFromA) {
            personalRecList = this.personalRecDao.selectPersonalRecFromA(user);
        }
        else {
            personalRecList = this.personalRecDao.selectPersonalRecFromB(user);
        }
        return personalRecList;
    }
    
    public void initializePersonalRecList(final HttpServletRequest request) {
        final User user = this.userDao.selectByUser(Request.getUserFromHttpServletRequest(request));
        List<Song> initialRecListA = new ArrayList<Song>();
        final List<Song> initialRecListB = new ArrayList<Song>();
        initialRecListA = this.newTrackOnShelfDao.selecNewSong();
        for (int i = 0; i < 40; ++i) {
            final int len = initialRecListA.size();
            final Random random = new Random();
            final int index = random.nextInt(len);
            if (i < 10) {
                initialRecListB.add(initialRecListA.get((index + 1) % len));
            }
            initialRecListA.remove(index);
        }
        if (Static.isFromA) {
            this.personalRecDao.insertListIntoRecA(initialRecListA, user.getUserId());
        }
        else {
            this.personalRecDao.insertListIntoRecB(initialRecListB, user.getUserId());
        }
    }
    
    public void updatePersonalRecIntoB(final Map<Integer, Integer[]> user2song) {
        user2song.forEach(new BiConsumer<Integer, Integer[]>() {
            public void accept(final Integer userId, final Integer[] recSongIds) {
                PersonalRecServiceImpl.this.personalRecDao.deleteBByUserId(userId);
                PersonalRecServiceImpl.this.personalRecDao.insertArrayIntoRecB(recSongIds, userId);
            }
        });
    }
    
    public void updatePersonalRecIntoA(final Map<Integer, Integer[]> user2song) {
        user2song.forEach(new BiConsumer<Integer, Integer[]>() {
            public void accept(final Integer userId, final Integer[] recSongIds) {
                PersonalRecServiceImpl.this.personalRecDao.deleteAByUserId(userId);
                PersonalRecServiceImpl.this.personalRecDao.insertArrayIntoRecA(recSongIds, userId);
            }
        });
    }
    
    public void addHybridRecIntoA(final Map<Integer, Integer[]> user2song) {
        user2song.forEach(new BiConsumer<Integer, Integer[]>() {
            public void accept(final Integer userId, final Integer[] recSongIds) {
                PersonalRecServiceImpl.this.personalRecDao.insertArrayIntoRecA(recSongIds, userId);
            }
        });
    }
    
    public void addHybridRecIntoB(final Map<Integer, Integer[]> user2song) {
        user2song.forEach(new BiConsumer<Integer, Integer[]>() {
            public void accept(final Integer userId, final Integer[] recSongIds) {
                PersonalRecServiceImpl.this.personalRecDao.insertArrayIntoRecB(recSongIds, userId);
            }
        });
    }
}
