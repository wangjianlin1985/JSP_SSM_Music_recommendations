// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.controller;

import top.wangruns.trackstacking.model.Song;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import top.wangruns.trackstacking.utils.OneDayOneWord;
import top.wangruns.trackstacking.utils.Static;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import top.wangruns.trackstacking.service.MyMusicService;
import org.springframework.stereotype.Controller;

@Controller
public class MyMusicPageController
{
    @Autowired
    private MyMusicService myMusicService;
    
    @GetMapping({ "myMusicFrameLoad.do" })
    public ModelAndView myMusicFrameLoad(final HttpServletRequest request) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("myMusicFrame");
        modelAndView.addObject("oneDayOneWord", (Object)OneDayOneWord.getOneDayOneWord(Static.MY_MUSIC_WORD_ARRAY));
        return modelAndView;
    }
    
    @GetMapping({ "recentFrameLoad.do" })
    public ModelAndView recentFrameLoad(final HttpServletRequest request) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("recentFrame");
        final List<Song> myRecentPlayList = this.myMusicService.getMyRecentPlayListWithCollectionFlag(request);
        modelAndView.addObject("myRecentPlayList", (Object)myRecentPlayList);
        modelAndView.addObject("oneDayOneWord", (Object)OneDayOneWord.getOneDayOneWord(Static.MY_MUSIC_WORD_ARRAY));
        return modelAndView;
    }
    
    @GetMapping({ "collectedFrameLoad.do" })
    public ModelAndView collectedFrameLoad(final HttpServletRequest request) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("collectedFrame");
        final List<Song> myCollectionList = this.myMusicService.getMyCollectionWithCollectionFlag(request);
        modelAndView.addObject("myCollectionList", (Object)myCollectionList);
        modelAndView.addObject("oneDayOneWord", (Object)OneDayOneWord.getOneDayOneWord(Static.MY_MUSIC_WORD_ARRAY));
        return modelAndView;
    }
}
