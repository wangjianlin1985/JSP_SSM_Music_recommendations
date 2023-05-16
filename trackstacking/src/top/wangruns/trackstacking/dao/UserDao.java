// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.dao;

import top.wangruns.trackstacking.model.Role;
import java.util.List;
import top.wangruns.trackstacking.model.User;

public interface UserDao
{
    User selectByUser(User p0);
    
    User selectByEmail(String p0);
    
    int insert(User p0);
    
    List<User> selectAll();
    
    List<Integer> selectAllUserId();
    
    void deleteByIds(int[] p0);
    
    Role selectRoleByUserId(int p0);
}
