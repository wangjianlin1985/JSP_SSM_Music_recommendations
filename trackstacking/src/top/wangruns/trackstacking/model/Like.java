// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.model;

public class Like
{
    private int likeId;
    private int userId;
    private int reviewId;
    
    public Like() {
    }
    
    public Like(final int userId, final int reviewId) {
        this.userId = userId;
        this.reviewId = reviewId;
    }
    
    public int getLikeId() {
        return this.likeId;
    }
    
    public void setLikeId(final int likeId) {
        this.likeId = likeId;
    }
    
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(final int userId) {
        this.userId = userId;
    }
    
    public int getReviewId() {
        return this.reviewId;
    }
    
    public void setReviewId(final int reviewId) {
        this.reviewId = reviewId;
    }
}
