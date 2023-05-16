// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import top.wangruns.trackstacking.model.Song;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import top.wangruns.trackstacking.service.PersonalRecService;
import org.springframework.stereotype.Controller;

@Controller
public class PersonalRecController
{
    @Autowired
    private PersonalRecService personalRecService;
    
    @RequestMapping(value = { "personalizedRecFrameLoad.do" }, method = { RequestMethod.GET })
    public ModelAndView personalizedRecFrameLoad(final HttpServletRequest request) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("personalizedRecFrame");
        final List<Song> personalRecSongList = this.personalRecService.getPersonalDailyRecWithCollectionFlag(request);
        modelAndView.addObject("personalRecSongList", (Object)personalRecSongList);
        if (personalRecSongList == null) {
            modelAndView.addObject("oneDayOneWord", (Object)"\u767b\u5f55\u5373\u4eab\u2014\u2014\u9047\u89c1\u4e0d\u4e00\u6837\u7684\u81ea\u5df1");
        }
        else {
            modelAndView.addObject("oneDayOneWord", (Object)"\u66f4\u61c2\u4f60\u7684\u5fc3");
        }
        return modelAndView;
    }
}
