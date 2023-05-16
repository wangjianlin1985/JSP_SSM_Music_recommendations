// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.service;

import top.wangruns.trackstacking.model.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public interface CollectionService
{
    boolean collectionChange(HttpServletRequest p0, int p1);
    
    List<Collection> getAllRecords();
}
