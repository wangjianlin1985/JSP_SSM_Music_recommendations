// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.algorithm;

import java.util.function.Consumer;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class CollaborativeFiltering
{
    public static Map<Integer, Integer[]> userKNNBasedCF(final List<Integer> userIdList, final Map<Integer, Integer[]> userKNNMatrix, final Map<Integer, float[]> user2songRatingMatrix, final List<Integer> songIdList, final int n) {
        final Map<Integer, Integer[]> user2songRecMatrix = new HashMap<Integer, Integer[]>();
        userIdList.forEach(new Consumer<Integer>() {
            public void accept(final Integer curUserId) {
                final Integer[] knnIdArray = userKNNMatrix.get(curUserId);
                final float[] curUserRatings = user2songRatingMatrix.get(curUserId);
                final MininumHeap mininumHeap = new MininumHeap(n);
                for (int i = 0; i < curUserRatings.length; ++i) {
                    if (curUserRatings[i] < 0.01f) {
                        for (int knnIndex = 0; knnIndex < knnIdArray.length; ++knnIndex) {
                            final int knnId = knnIdArray[knnIndex];
                            final float[] knnUserRatings = user2songRatingMatrix.get(knnId);
                            final float[] array = curUserRatings;
                            final int n = i;
                            array[n] += knnUserRatings[i];
                        }
                        final float[] array2 = curUserRatings;
                        final int n2 = i;
                        array2[n2] /= knnIdArray.length;
                        final int curSongId = songIdList.get(i);
                        mininumHeap.addElement(new TreeNode(curSongId, curUserRatings[i]));
                    }
                }
                int trueNumber = n;
                if (mininumHeap.getCurHeapSize() < n) {
                    trueNumber = mininumHeap.getCurHeapSize();
                }
                final Integer[] curUserRecSongId = new Integer[trueNumber];
                for (int j = 0; j < trueNumber; ++j) {
                    final int recSongId = mininumHeap.getArray()[j].id;
                    curUserRecSongId[j] = recSongId;
                }
                user2songRecMatrix.put(curUserId, curUserRecSongId);
            }
        });
        return user2songRecMatrix;
    }
}
