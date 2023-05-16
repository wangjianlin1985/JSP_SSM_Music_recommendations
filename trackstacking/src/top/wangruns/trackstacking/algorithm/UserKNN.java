// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.algorithm;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class UserKNN
{
    public static Map<Integer, Integer[]> getKNN(final List<Integer> userIdList, final Map<Integer, float[]> user2songRatingMatrix, final int k) {
        final Map<Integer, Integer[]> userKNNMatrix = new HashMap<Integer, Integer[]>();
        userIdList.forEach(new Consumer<Integer>() {
            public void accept(final Integer curUserId) {
                final Integer[] knnId = new Integer[k];
                final MininumHeap mininumHeap = new MininumHeap(k);
                user2songRatingMatrix.forEach(new BiConsumer<Integer, float[]>() {
                    public void accept(final Integer otherUserId, final float[] userRatingArray) {
                        if (otherUserId != curUserId) {
                            final float similarity = Similarity.calculateSimilarity(user2songRatingMatrix.get(curUserId), user2songRatingMatrix.get(otherUserId));
                            mininumHeap.addElement(new TreeNode(otherUserId, similarity));
                        }
                    }
                });
                for (int i = 0; i < k; ++i) {
                    knnId[i] = mininumHeap.getArray()[i].id;
                }
                userKNNMatrix.put(curUserId, knnId);
            }
        });
        return userKNNMatrix;
    }
}
