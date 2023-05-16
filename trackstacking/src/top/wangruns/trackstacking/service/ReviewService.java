// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.service;

import top.wangruns.trackstacking.model.Review;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public interface ReviewService
{
    boolean addReview(HttpServletRequest p0, int p1, String p2);
    
    List<Review> getHotReviewBySongIdWithLikeFlag(HttpServletRequest p0, int p1);
    
    boolean reviewLikeChange(HttpServletRequest p0, int p1);
    
    List<Review> getNewReviewBySongIdWithLikeFlag(HttpServletRequest p0, int p1);
    
    void batchDeleteById(int[] p0);
}
