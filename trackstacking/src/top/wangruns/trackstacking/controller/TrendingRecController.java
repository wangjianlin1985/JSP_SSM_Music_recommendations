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
import top.wangruns.trackstacking.service.TrendingRecService;
import org.springframework.stereotype.Controller;

@Controller
public class TrendingRecController
{
    @Autowired
    private TrendingRecService trendingRecService;
    
    @RequestMapping(value = { "trendingRecFrameLoad.do" }, method = { RequestMethod.GET })
    public ModelAndView trendingRecFrameLoad(final HttpServletRequest request) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("trendingRecFrame");
        final List<Song> trendingSongList = this.trendingRecService.getSongWithCollectionFlag(request);
        modelAndView.addObject("trendingSongList", (Object)trendingSongList);
        modelAndView.addObject("test", (Object)"Name");
        return modelAndView;
    }
}
