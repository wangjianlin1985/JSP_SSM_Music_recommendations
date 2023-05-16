// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.service.impl;

import java.util.List;
import top.wangruns.trackstacking.model.User;
import top.wangruns.trackstacking.model.DownloadRecord;
import top.wangruns.trackstacking.utils.Request;
import javax.servlet.http.HttpServletRequest;
import top.wangruns.trackstacking.dao.RecordDownloadDao;
import org.springframework.beans.factory.annotation.Autowired;
import top.wangruns.trackstacking.dao.UserDao;
import org.springframework.stereotype.Service;
import top.wangruns.trackstacking.service.RecordDownloadService;

@Service("recordDownloadService")
public class RecordDownloadServiceImpl implements RecordDownloadService
{
    @Autowired
    private UserDao userDao;
    @Autowired
    private RecordDownloadDao recordDownloadDao;
    
    public void recordDownload(final HttpServletRequest request, final int songId) {
        User user = Request.getUserFromHttpServletRequest(request);
        if (user == null) {
            return;
        }
        user = this.userDao.selectByUser(user);
        this.recordDownloadDao.insert(new DownloadRecord(user.getUserId(), songId));
    }
    
    public List<DownloadRecord> getAllRecords() {
        return this.recordDownloadDao.selectAll();
    }
}
