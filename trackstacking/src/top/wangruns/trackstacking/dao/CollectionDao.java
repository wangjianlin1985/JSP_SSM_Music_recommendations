// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.dao;

import java.util.List;
import top.wangruns.trackstacking.model.Collection;

public interface CollectionDao
{
    Collection selectByCollection(Collection p0);
    
    void deleteById(int p0);
    
    void insert(Collection p0);
    
    List<Collection> selectAll();
}
