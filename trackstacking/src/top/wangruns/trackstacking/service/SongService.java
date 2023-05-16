// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.service;

import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import top.wangruns.trackstacking.model.Song;
import java.util.List;

public interface SongService
{
    List<Integer> getAllSongIdRecords();
    
    Song getSongById(int p0);
    
    Song getSongByIdWithCollectionFlag(HttpServletRequest p0, int p1);
    
    void batchDeleteById(HttpServletRequest p0, int[] p1);
    
    boolean checkFormat(MultipartFile p0, MultipartFile p1);
    
    boolean addSong(HttpServletRequest p0, MultipartFile p1, MultipartFile p2);
    
    List<Song> getAllSongRecordsWithLyric();
}
