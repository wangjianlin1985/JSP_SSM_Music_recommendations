// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.controller;

import com.alibaba.fastjson.JSONObject;
import top.wangruns.trackstacking.model.User;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import top.wangruns.trackstacking.utils.SendEmail;
import top.wangruns.trackstacking.utils.ReturnMsg;
import javax.servlet.http.HttpServletRequest;
import top.wangruns.trackstacking.service.PersonalRecService;
import org.springframework.beans.factory.annotation.Autowired;
import top.wangruns.trackstacking.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class RegisterController
{
    @Autowired
    private UserService userService;
    @Autowired
    private PersonalRecService personalRecService;
    
    @PostMapping(value = { "getValidateCode.do" }, produces = { "text/html;charset=UTF-8" })
    @ResponseBody
    public String getValidateCode(final HttpServletRequest request, final String email) {
        final boolean isExisted = this.userService.isEmailExisted(email);
        if (isExisted) {
            return ReturnMsg.msg(400, "\u8be5\u7528\u6237\u5df2\u5b58\u5728");
        }
        if (this.userService.tooQuickly(request, 1)) {
            return ReturnMsg.msg(400, "\u53d1\u9001\u9891\u7387\u592a\u5feb");
        }
        final String code = new StringBuilder(String.valueOf((int)(Math.random() * 10000.0))).toString();
        final String content = "Welcome to Track Stacking, your email verified code is\uff1a" + code + "\n\n" + "Sincerely,";
        final boolean isSuccessful = SendEmail.sendemail("Email Validation", content, email);
        if (isSuccessful) {
            request.getSession().setAttribute("code", (Object)code);
            return ReturnMsg.msg(200, "\u53d1\u9001\u6210\u529f");
        }
        return ReturnMsg.msg(400, "\u53d1\u9001\u5931\u8d25");
    }
    
    @PostMapping(value = { "register.do" }, produces = { "text/html;charset=UTF-8" })
    @ResponseBody
    public String register(final HttpServletRequest request, final User u) {
        final String code = (String)request.getSession().getAttribute("code");
        if (code == null || !code.equals(u.getValidateCode())) {
            return ReturnMsg.msg(400, "\u9a8c\u8bc1\u7801\u9519\u8bef");
        }
        final boolean isInserted = this.userService.insert(u);
        if (isInserted) {
            request.getSession().setAttribute("user", (Object)u);
            this.personalRecService.initializePersonalRecList(request);
            return ReturnMsg.msg(200, JSONObject.toJSON((Object)u).toString());
        }
        return ReturnMsg.msg(400, "\u6ce8\u518c\u5931\u8d25");
    }
}
