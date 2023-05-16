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
import top.wangruns.trackstacking.service.NewTrackOnShelfService;
import org.springframework.stereotype.Controller;

@Controller
public class NewTrackOnShelfController
{
    @Autowired
    private NewTrackOnShelfService newTrackOnShelfService;
    
    @RequestMapping(value = { "newTrackOnShelfFrameLoad.do" }, method = { RequestMethod.GET })
    public ModelAndView newTrackOnShelfFrameLoad(final HttpServletRequest request) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("newTrackOnShelfFrame");
        final List<Song> newTrackSongList = this.newTrackOnShelfService.getNewTrackWithCollectionFlag(request);
        modelAndView.addObject("newTrackSongList", (Object)newTrackSongList);
        modelAndView.addObject("test", (Object)"Name");
        return modelAndView;
    }
}
