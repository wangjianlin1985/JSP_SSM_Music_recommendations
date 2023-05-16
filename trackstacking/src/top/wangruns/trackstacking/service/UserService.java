// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import top.wangruns.trackstacking.model.User;

public interface UserService
{
    boolean findLogin(User p0);
    
    boolean isEmailExisted(String p0);
    
    boolean insert(User p0);
    
    List<User> getAllRecords();
    
    List<Integer> getAllUserIdRecords();
    
    boolean isHasPrivilege(HttpServletRequest p0);
    
    void batchDeleteById(int[] p0);
    
    boolean tooQuickly(HttpServletRequest p0, int p1);
}
