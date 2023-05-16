// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.controller;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import com.alibaba.fastjson.JSONObject;
import top.wangruns.trackstacking.utils.ReturnMsg;
import top.wangruns.trackstacking.model.User;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import top.wangruns.trackstacking.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController
{
    @Autowired
    private UserService userService;
    
    @PostMapping(value = { "login.do" }, produces = { "text/html;charset=UTF-8" })
    @ResponseBody
    public String login(final HttpServletRequest request, final User u) {
        final boolean isUserExisted = this.userService.findLogin(u);
        if (!isUserExisted) {
            return ReturnMsg.msg(400, "\u5e10\u53f7\u6216\u5bc6\u7801\u9519\u8bef");
        }
        request.getSession().setAttribute("user", (Object)u);
        request.getSession().setAttribute("isHasPrivilege", (Object)this.userService.isHasPrivilege(request));
        return ReturnMsg.msg(200, JSONObject.toJSON((Object)u).toString());
    }
}
