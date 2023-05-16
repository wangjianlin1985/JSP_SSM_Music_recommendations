// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import top.wangruns.trackstacking.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController
{
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = { "deleteUser.do" }, method = { RequestMethod.POST })
    public void deleteUser(final HttpServletRequest request, final int[] userIds) {
        if (this.userService.isHasPrivilege(request)) {
            this.userService.batchDeleteById(userIds);
        }
    }
}
