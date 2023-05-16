// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import top.wangruns.trackstacking.utils.ReturnMsg;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import top.wangruns.trackstacking.model.Review;
import java.util.List;
import top.wangruns.trackstacking.model.Song;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import top.wangruns.trackstacking.service.UserService;
import top.wangruns.trackstacking.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import top.wangruns.trackstacking.service.SongService;
import org.springframework.stereotype.Controller;

@Controller
public class ReviewController
{
    @Autowired
    private SongService songService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = { "reviewFrameLoad.do" }, method = { RequestMethod.GET })
    public ModelAndView reviewFrameLoad(final HttpServletRequest request, final int songId) {
        final Song song = this.songService.getSongByIdWithCollectionFlag(request, songId);
        final List<Review> hotReviewList = this.reviewService.getHotReviewBySongIdWithLikeFlag(request, songId);
        final List<Review> newReviewList = this.reviewService.getNewReviewBySongIdWithLikeFlag(request, songId);
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("reviewFrame");
        modelAndView.addObject("song", (Object)song);
        modelAndView.addObject("hotReviewList", (Object)hotReviewList);
        modelAndView.addObject("newReviewList", (Object)newReviewList);
        return modelAndView;
    }
    
    @PostMapping({ "review.do" })
    @ResponseBody
    public String review(final HttpServletRequest request, final int songId, final String review) {
        final boolean isAdded = this.reviewService.addReview(request, songId, review);
        if (isAdded) {
            return ReturnMsg.msg(200, "\u8bc4\u8bba\u6210\u529f");
        }
        return ReturnMsg.msg(400, "\u8bc4\u8bba\u51fa\u9519");
    }
    
    @GetMapping(value = { "reviewLike.do" }, produces = { "text/html;charset=UTF-8" })
    @ResponseBody
    public String reviewLike(final HttpServletRequest request, final int reviewId) {
        final boolean isLiked = this.reviewService.reviewLikeChange(request, reviewId);
        return ReturnMsg.msg(200, new StringBuilder(String.valueOf(isLiked)).toString());
    }
    
    @RequestMapping(value = { "newReviewFrameLoad.do" }, method = { RequestMethod.GET })
    public ModelAndView newReviewFrameLoad(final HttpServletRequest request, final int songId) {
        final List<Review> newReviewList = this.reviewService.getNewReviewBySongIdWithLikeFlag(request, songId);
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("newReviewFrame");
        modelAndView.addObject("newReviewList", (Object)newReviewList);
        return modelAndView;
    }
    
    @RequestMapping(value = { "deleteReview.do" }, method = { RequestMethod.POST })
    public void deleteReview(final HttpServletRequest request, final int[] reviewIds) {
        if (this.userService.isHasPrivilege(request)) {
            this.reviewService.batchDeleteById(reviewIds);
        }
    }
}
