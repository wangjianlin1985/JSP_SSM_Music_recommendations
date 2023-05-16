// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class IndexController
{
    @RequestMapping({ "index.do" })
    public String index() {
        return "index";
    }
    
    @RequestMapping({ "logout.do" })
    public String logout(final HttpServletRequest request) {
        request.getSession().invalidate();
        System.out.println("logout success");
        return "redirect:index.do";
    }
    
    @RequestMapping(value = { "headerFrameLoad.do" }, method = { RequestMethod.GET })
    public ModelAndView headerFrameLoad(final HttpServletRequest request) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("headerFrame");
        return modelAndView;
    }
}
