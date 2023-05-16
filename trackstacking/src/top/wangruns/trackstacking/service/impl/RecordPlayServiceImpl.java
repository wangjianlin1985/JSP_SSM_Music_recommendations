// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.service.impl;

import java.util.List;
import top.wangruns.trackstacking.model.User;
import top.wangruns.trackstacking.model.PlayRecord;
import top.wangruns.trackstacking.utils.Request;
import javax.servlet.http.HttpServletRequest;
import top.wangruns.trackstacking.dao.RecordPlayDao;
import org.springframework.beans.factory.annotation.Autowired;
import top.wangruns.trackstacking.dao.UserDao;
import org.springframework.stereotype.Service;
import top.wangruns.trackstacking.service.RecordPlayService;

@Service("recordPlayService")
public class RecordPlayServiceImpl implements RecordPlayService
{
    @Autowired
    private UserDao userDao;
    @Autowired
    private RecordPlayDao recordPlayDao;
    
    public void recordPlay(final HttpServletRequest request, final int songId) {
        final User user = this.userDao.selectByUser(Request.getUserFromHttpServletRequest(request));
        this.recordPlayDao.insert(new PlayRecord(user.getUserId(), songId));
    }
    
    public List<PlayRecord> getAllRecords() {
        return this.recordPlayDao.selectAll();
    }
}
