// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.algorithm;

public class Similarity
{
    public static float calculateSimilarity(final float[] curRating, final float[] otherRating) {
        float similarity = 0.0f;
        final int len = curRating.length;
        int cnt = 0;
        for (int i = 0; i < len; ++i) {
            if (curRating[i] > 0.01f) {
                similarity += (float)Math.pow(curRating[i] - otherRating[i], 2.0);
                ++cnt;
            }
        }
        similarity /= ((cnt > 0) ? cnt : 1);
        return similarity;
    }
}
