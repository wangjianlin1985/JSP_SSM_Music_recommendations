// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.model;

public class Review
{
    private int reviewId;
    private int userId;
    private int songId;
    private String review;
    private String reviewTime;
    private int likeCoefficient;
    private String userName;
    private boolean whetherLiked;
    
    public int getLikeCoefficient() {
        return this.likeCoefficient;
    }
    
    public void setLikeCoefficient(final int likeCoefficient) {
        this.likeCoefficient = likeCoefficient;
    }
    
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(final String userName) {
        this.userName = userName;
    }
    
    public boolean isWhetherLiked() {
        return this.whetherLiked;
    }
    
    public void setWhetherLiked(final boolean whetherLiked) {
        this.whetherLiked = whetherLiked;
    }
    
    public Review(final int userId, final int songId, final String review) {
        this.userId = userId;
        this.songId = songId;
        this.review = review;
    }
    
    public String getReview() {
        return this.review;
    }
    
    public void setReview(final String review) {
        this.review = review;
    }
    
    public Review() {
    }
    
    public int getReviewId() {
        return this.reviewId;
    }
    
    public void setReviewId(final int reviewId) {
        this.reviewId = reviewId;
    }
    
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(final int userId) {
        this.userId = userId;
    }
    
    public int getSongId() {
        return this.songId;
    }
    
    public void setSongId(final int songId) {
        this.songId = songId;
    }
    
    public String getReviewTime() {
        return this.reviewTime;
    }
    
    public void setReviewTime(final String reviewTime) {
        this.reviewTime = reviewTime;
    }
}
