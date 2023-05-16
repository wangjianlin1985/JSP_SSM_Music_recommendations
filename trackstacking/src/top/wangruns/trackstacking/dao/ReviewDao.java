// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.dao;

import top.wangruns.trackstacking.model.Like;
import java.util.List;
import top.wangruns.trackstacking.model.Review;

public interface ReviewDao
{
    int insert(Review p0);
    
    List<Like> selectLikeByUserId(int p0);
    
    List<Review> selectHotReviewWithLikeNumber(int p0);
    
    Like selectByLike(Like p0);
    
    void insertLikeRecord(Like p0);
    
    void deleteLikeRecordById(int p0);
    
    List<Review> selectNewReviewWithLikeNumber(int p0);
    
    void deleteByIds(int[] p0);
}
