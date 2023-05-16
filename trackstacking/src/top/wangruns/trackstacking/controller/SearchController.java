// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import top.wangruns.trackstacking.model.Review;
import top.wangruns.trackstacking.model.User;
import top.wangruns.trackstacking.model.Song;
import java.util.List;
import top.wangruns.trackstacking.utils.OneDayOneWord;
import top.wangruns.trackstacking.utils.Static;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import top.wangruns.trackstacking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import top.wangruns.trackstacking.service.SearchService;
import org.springframework.stereotype.Controller;

@Controller
public class SearchController
{
    @Autowired
    private SearchService searchService;
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = { "searchFrameLoad.do" }, method = { RequestMethod.GET })
    public ModelAndView searchFrameLoad(final HttpServletRequest request, final String keyword, final String mode) {
        final ModelAndView modelAndView = new ModelAndView();
        if (mode != null && this.userService.isHasPrivilege(request)) {
            final int modeInt = Integer.parseInt(mode);
            if (modeInt == 0) {
                modelAndView.setViewName("songManageSearchFrame");
                final List<Song> songManageSearchList = this.searchService.getSearchSong(keyword);
                modelAndView.addObject("songManageSearchList", (Object)songManageSearchList);
                if (songManageSearchList.size() == 0) {
                    modelAndView.addObject("oneDayOneWord", (Object)"\u4e0b\u843d\u4e0d\u660e");
                }
                else {
                    modelAndView.addObject("oneDayOneWord", (Object)OneDayOneWord.getOneDayOneWord(Static.SEARCH_WORD_ARRAY));
                }
            }
            else if (modeInt == 1) {
                modelAndView.setViewName("userManageSearchFrame");
                final List<User> userManageSearchList = this.searchService.getSearchUser(request, keyword);
                modelAndView.addObject("userManageSearchList", (Object)userManageSearchList);
                if (userManageSearchList.size() == 0) {
                    modelAndView.addObject("oneDayOneWord", (Object)"\u4e0b\u843d\u4e0d\u660e");
                }
                else {
                    modelAndView.addObject("oneDayOneWord", (Object)OneDayOneWord.getOneDayOneWord(Static.SEARCH_WORD_ARRAY));
                }
            }
            else {
                modelAndView.setViewName("reviewManageSearchFrame");
                final List<Review> reviewManageSearchList = this.searchService.getSearchReview(keyword);
                modelAndView.addObject("reviewManageSearchList", (Object)reviewManageSearchList);
                if (reviewManageSearchList.size() == 0) {
                    modelAndView.addObject("oneDayOneWord", (Object)"\u4e0b\u843d\u4e0d\u660e");
                }
                else {
                    modelAndView.addObject("oneDayOneWord", (Object)OneDayOneWord.getOneDayOneWord(Static.SEARCH_WORD_ARRAY));
                }
            }
        }
        else {
            modelAndView.setViewName("searchFrame");
            final List<Song> searchSongList = this.searchService.getSearchSongWithCollectionFlag(request, keyword);
            modelAndView.addObject("searchSongList", (Object)searchSongList);
            if (searchSongList.size() == 0) {
                modelAndView.addObject("oneDayOneWord", (Object)"\u4e0b\u843d\u4e0d\u660e");
            }
            else {
                modelAndView.addObject("oneDayOneWord", (Object)OneDayOneWord.getOneDayOneWord(Static.SEARCH_WORD_ARRAY));
            }
        }
        return modelAndView;
    }
}
