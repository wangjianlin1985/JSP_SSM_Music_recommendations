// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.dao;

import top.wangruns.trackstacking.model.Song;
import java.util.List;
import top.wangruns.trackstacking.model.User;

public interface PersonalRecDao
{
    List<Song> selectPersonalRecFromA(User p0);
    
    List<Song> selectPersonalRecFromB(User p0);
    
    void insertRecA(int p0, int p1);
    
    void insertRecB(int p0, int p1);
    
    void deleteBByUserId(int p0);
    
    void deleteAByUserId(int p0);
    
    void insertListIntoRecA(List<Song> p0, int p1);
    
    void insertListIntoRecB(List<Song> p0, int p1);
    
    void insertArrayIntoRecB(Integer[] p0, Integer p1);
    
    void insertArrayIntoRecA(Integer[] p0, Integer p1);
}
