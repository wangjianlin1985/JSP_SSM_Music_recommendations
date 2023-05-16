// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.service.impl;

import java.util.Iterator;
import top.wangruns.trackstacking.model.Like;
import java.util.List;
import top.wangruns.trackstacking.model.User;
import top.wangruns.trackstacking.model.Review;
import top.wangruns.trackstacking.utils.Request;
import javax.servlet.http.HttpServletRequest;
import top.wangruns.trackstacking.dao.ReviewDao;
import org.springframework.beans.factory.annotation.Autowired;
import top.wangruns.trackstacking.dao.UserDao;
import org.springframework.stereotype.Service;
import top.wangruns.trackstacking.service.ReviewService;

@Service("reviewServiceImpl")
public class ReviewServiceImpl implements ReviewService
{
    @Autowired
    private UserDao userDao;
    @Autowired
    private ReviewDao reviewDao;
    
    public boolean addReview(final HttpServletRequest request, final int songId, final String content) {
        boolean isInsertSuccessful = false;
        final User user = this.userDao.selectByUser(Request.getUserFromHttpServletRequest(request));
        if (user == null) {
            return isInsertSuccessful;
        }
        final Review review = new Review(user.getUserId(), songId, content);
        final int affectedRows = this.reviewDao.insert(review);
        if (affectedRows > 0) {
            isInsertSuccessful = true;
        }
        return isInsertSuccessful;
    }
    
    public List<Review> getHotReviewBySongIdWithLikeFlag(final HttpServletRequest request, final int songId) {
        final User user = this.userDao.selectByUser(Request.getUserFromHttpServletRequest(request));
        List<Like> likeList = null;
        if (user != null) {
            likeList = this.reviewDao.selectLikeByUserId(user.getUserId());
        }
        final List<Review> hotReviewList = this.reviewDao.selectHotReviewWithLikeNumber(songId);
        if (hotReviewList != null && likeList != null) {
            for (final Like like : likeList) {
                for (final Review review : hotReviewList) {
                    if (like.getReviewId() == review.getReviewId()) {
                        review.setWhetherLiked(true);
                    }
                }
            }
        }
        return hotReviewList;
    }
    
    public boolean reviewLikeChange(final HttpServletRequest request, final int reviewId) {
        boolean isLiked = true;
        final User user = this.userDao.selectByUser(Request.getUserFromHttpServletRequest(request));
        final Like like = this.reviewDao.selectByLike(new Like(user.getUserId(), reviewId));
        if (like == null) {
            isLiked = false;
            this.reviewDao.insertLikeRecord(new Like(user.getUserId(), reviewId));
        }
        else {
            this.reviewDao.deleteLikeRecordById(like.getLikeId());
        }
        return !isLiked;
    }
    
    public List<Review> getNewReviewBySongIdWithLikeFlag(final HttpServletRequest request, final int songId) {
        final User user = this.userDao.selectByUser(Request.getUserFromHttpServletRequest(request));
        List<Like> likeList = null;
        if (user != null) {
            likeList = this.reviewDao.selectLikeByUserId(user.getUserId());
        }
        final List<Review> newReviewList = this.reviewDao.selectNewReviewWithLikeNumber(songId);
        if (newReviewList != null && likeList != null) {
            for (final Like like : likeList) {
                for (final Review review : newReviewList) {
                    if (like.getReviewId() == review.getReviewId()) {
                        review.setWhetherLiked(true);
                    }
                }
            }
        }
        return newReviewList;
    }
    
    public void batchDeleteById(final int[] reviewIds) {
        if (reviewIds == null) {
            return;
        }
        this.reviewDao.deleteByIds(reviewIds);
    }
}
