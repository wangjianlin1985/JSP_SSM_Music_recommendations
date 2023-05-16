// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.service.impl;

import java.io.InputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.Iterator;
import top.wangruns.trackstacking.model.User;
import top.wangruns.trackstacking.utils.Request;
import top.wangruns.trackstacking.model.Collection;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import top.wangruns.trackstacking.model.Song;
import java.util.List;
import top.wangruns.trackstacking.dao.TrendingRecDao;
import top.wangruns.trackstacking.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import top.wangruns.trackstacking.dao.SongDao;
import org.springframework.stereotype.Service;
import top.wangruns.trackstacking.service.SongService;

@Service("songService")
public class SongServiceImpl implements SongService
{
    @Autowired
    private SongDao songDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private TrendingRecDao trendingRecDao;
    
    public List<Integer> getAllSongIdRecords() {
        return this.songDao.selectAllSongId();
    }
    
    public Song getSongById(final int songId) {
        return this.songDao.selectSongById(songId);
    }
    
    public Song getSongByIdWithCollectionFlag(final HttpServletRequest request, final int songId) {
        final Song song = this.songDao.selectSongById(songId);
        if (song == null) {
            return null;
        }
        final int trendingCoefficient = this.songDao.selectCoefficientById(songId);
        song.setTrendingCoefficient(trendingCoefficient);
        List<Collection> collectionList = new ArrayList<Collection>();
        final User user = this.userDao.selectByUser(Request.getUserFromHttpServletRequest(request));
        collectionList = this.trendingRecDao.getCollection(user);
        if (collectionList != null) {
            for (final Collection c : collectionList) {
                if (c.getSongId() == songId) {
                    song.setWhetherCollected(true);
                    break;
                }
            }
        }
        return song;
    }
    
    public void batchDeleteById(final HttpServletRequest request, final int[] songIds) {
        if (songIds == null) {
            return;
        }
        for (final int id : songIds) {
            final Song song = this.songDao.selectSongById(id);
            if (song != null) {
                final String realSongPath = request.getServletContext().getRealPath(song.getSongAddress());
                final File fileSong = new File(realSongPath);
                fileSong.delete();
                if (song.getLyricAddress() != null) {
                    final String realLyricPath = request.getServletContext().getRealPath(song.getLyricAddress());
                    final File fileLyric = new File(realLyricPath);
                    fileLyric.delete();
                }
            }
        }
        this.songDao.deleteByIds(songIds);
    }
    
    public boolean checkFormat(final MultipartFile song, final MultipartFile lyric) {
        return true;
    }
    
    public boolean addSong(final HttpServletRequest request, final MultipartFile song, final MultipartFile lyric) {
        final String name = song.getOriginalFilename();
        final String songName = name.substring(0, name.lastIndexOf("."));
        final String songAddress = "track/song/" + name;
        boolean isInsertSuccessful = false;
        int affectedRows = -1;
        if (lyric.isEmpty()) {
            affectedRows = this.songDao.insertOnlySong(new Song(songName, songAddress));
            this.saveFile(song, request.getServletContext().getRealPath(songAddress));
        }
        else {
            final String lyricName = lyric.getOriginalFilename();
            final String lyricAddress = "track/lyric/" + lyricName;
            affectedRows = this.songDao.insertSongWithLyric(new Song(songName, songAddress, lyricName, lyricAddress));
            this.saveFile(song, request.getServletContext().getRealPath(songAddress));
            this.saveFile(lyric, request.getServletContext().getRealPath(lyricAddress));
        }
        if (affectedRows > 0) {
            isInsertSuccessful = true;
        }
        return isInsertSuccessful;
    }
    
    private void saveFile(final MultipartFile multipartFile, final String realFilePath) {
        try {
            final InputStream inputStream = multipartFile.getInputStream();
            final FileOutputStream fileOutputStream = new FileOutputStream(realFilePath);
            try {
                int b = 0;
                while ((b = inputStream.read()) != -1) {
                    fileOutputStream.write(b);
                }
            }
            finally {
                inputStream.close();
                fileOutputStream.close();
            }
            inputStream.close();
            fileOutputStream.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Song> getAllSongRecordsWithLyric() {
        return this.songDao.selectAllSongsWithLyric();
    }
}
