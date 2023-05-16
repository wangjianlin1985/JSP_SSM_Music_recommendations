// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import top.wangruns.trackstacking.model.Song;
import java.util.List;
import top.wangruns.trackstacking.utils.OneDayOneWord;
import top.wangruns.trackstacking.utils.Static;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import top.wangruns.trackstacking.service.RankingPageService;
import org.springframework.stereotype.Controller;

@Controller
public class RankingPageCotroller
{
    @Autowired
    private RankingPageService rankingPageService;
    
    @GetMapping({ "rankingFrameLoad.do" })
    public ModelAndView rankingFrameLoad(final HttpServletRequest request) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("rankingFrame");
        final List<Song> weekRankingList = this.rankingPageService.getRankWithCollectionFlag(request, 1);
        final List<Song> monthRankingList = this.rankingPageService.getRankWithCollectionFlag(request, 2);
        modelAndView.addObject("weekRankingList", (Object)weekRankingList);
        modelAndView.addObject("monthRankingList", (Object)monthRankingList);
        modelAndView.addObject("oneDayOneWord", (Object)OneDayOneWord.getOneDayOneWord(Static.RANKING_WORD_ARRAY));
        return modelAndView;
    }
}
