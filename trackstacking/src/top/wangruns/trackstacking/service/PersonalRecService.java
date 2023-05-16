// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.service;

import java.util.Map;
import top.wangruns.trackstacking.model.Song;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public interface PersonalRecService
{
    List<Song> getPersonalDailyRecWithCollectionFlag(HttpServletRequest p0);
    
    void initializePersonalRecList(HttpServletRequest p0);
    
    void updatePersonalRecIntoB(Map<Integer, Integer[]> p0);
    
    void updatePersonalRecIntoA(Map<Integer, Integer[]> p0);
    
    void addHybridRecIntoA(Map<Integer, Integer[]> p0);
    
    void addHybridRecIntoB(Map<Integer, Integer[]> p0);
}
