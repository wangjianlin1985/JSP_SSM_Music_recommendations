// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.service;

import top.wangruns.trackstacking.model.PlayRecord;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public interface RecordPlayService
{
    void recordPlay(HttpServletRequest p0, int p1);
    
    List<PlayRecord> getAllRecords();
}
