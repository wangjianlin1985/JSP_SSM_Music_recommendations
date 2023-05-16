// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.service.impl;

import java.util.Date;
import java.text.SimpleDateFormat;
import top.wangruns.trackstacking.model.Role;
import top.wangruns.trackstacking.utils.Request;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import top.wangruns.trackstacking.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import top.wangruns.trackstacking.dao.UserDao;
import org.springframework.stereotype.Service;
import top.wangruns.trackstacking.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDao userDao;
    
    public boolean findLogin(final User u) {
        boolean isUserExisted = false;
        final User result = this.userDao.selectByUser(u);
        if (result != null) {
            isUserExisted = true;
        }
        return isUserExisted;
    }
    
    public boolean isEmailExisted(final String email) {
        boolean isEmailExisted = false;
        final User result = this.userDao.selectByEmail(email);
        if (result != null) {
            isEmailExisted = true;
        }
        return isEmailExisted;
    }
    
    public boolean insert(final User u) {
        boolean isInsertSuccessful = false;
        final int affectedRows = this.userDao.insert(u);
        if (affectedRows > 0) {
            isInsertSuccessful = true;
        }
        return isInsertSuccessful;
    }
    
    public List<User> getAllRecords() {
        return this.userDao.selectAll();
    }
    
    public List<Integer> getAllUserIdRecords() {
        return this.userDao.selectAllUserId();
    }
    
    public boolean isHasPrivilege(final HttpServletRequest request) {
        boolean isHasPrivilege = false;
        final User user = this.userDao.selectByUser(Request.getUserFromHttpServletRequest(request));
        if (user == null) {
            return isHasPrivilege;
        }
        final Role role = this.userDao.selectRoleByUserId(user.getUserId());
        if (role != null) {
            isHasPrivilege = true;
        }
        return isHasPrivilege;
    }
    
    public void batchDeleteById(final int[] userIds) {
        if (userIds == null) {
            return;
        }
        this.userDao.deleteByIds(userIds);
    }
    
    public boolean tooQuickly(final HttpServletRequest request, final int minutes) {
        if (request.getSession().getAttribute("lastTime") == null) {
            request.getSession().setAttribute("lastTime", (Object)new SimpleDateFormat("mm").format(new Date()));
            return false;
        }
        final String lastMinute = (String)request.getSession().getAttribute("lastTime");
        final String curMinute = new SimpleDateFormat("mm").format(new Date());
        if (Math.abs(Integer.valueOf(curMinute) - Integer.valueOf(lastMinute)) <= minutes) {
            return true;
        }
        request.getSession().setAttribute("lastTime", (Object)curMinute);
        return false;
    }
}
