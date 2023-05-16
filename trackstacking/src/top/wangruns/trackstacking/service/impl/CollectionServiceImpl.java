// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.service.impl;

import java.util.List;
import top.wangruns.trackstacking.model.User;
import top.wangruns.trackstacking.model.Collection;
import top.wangruns.trackstacking.utils.Request;
import javax.servlet.http.HttpServletRequest;
import top.wangruns.trackstacking.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import top.wangruns.trackstacking.dao.CollectionDao;
import org.springframework.stereotype.Service;
import top.wangruns.trackstacking.service.CollectionService;

@Service("collectionService")
public class CollectionServiceImpl implements CollectionService
{
    @Autowired
    private CollectionDao collectionDao;
    @Autowired
    private UserDao userDao;
    
    public boolean collectionChange(final HttpServletRequest request, final int songId) {
        boolean isCurCollected = true;
        final User user = this.userDao.selectByUser(Request.getUserFromHttpServletRequest(request));
        final Collection collection = this.collectionDao.selectByCollection(new Collection(user.getUserId(), songId));
        if (collection == null) {
            isCurCollected = false;
            this.collectionDao.insert(new Collection(user.getUserId(), songId));
        }
        else {
            this.collectionDao.deleteById(collection.getCollectionId());
        }
        return !isCurCollected;
    }
    
    public List<Collection> getAllRecords() {
        return this.collectionDao.selectAll();
    }
}
