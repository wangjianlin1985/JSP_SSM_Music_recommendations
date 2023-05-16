// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.dao;

import java.util.List;
import top.wangruns.trackstacking.model.PlayRecord;

public interface RecordPlayDao
{
    void insert(PlayRecord p0);
    
    List<PlayRecord> selectAll();
}
