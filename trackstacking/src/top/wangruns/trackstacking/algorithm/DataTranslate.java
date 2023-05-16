// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.algorithm;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;
import java.util.HashMap;
import java.util.Map;
import top.wangruns.trackstacking.model.Collection;
import top.wangruns.trackstacking.model.PlayRecord;
import top.wangruns.trackstacking.model.DownloadRecord;
import java.util.List;

public class DataTranslate
{
    private static final float PLAY_SCORE = 1.0f;
    private static final float DOWNLOAD_SCORE = 2.0f;
    private static final float COLLECTION_SCORE = 5.0f;
    private static final float MAX_SCORE = 10.0f;
    private static final int SONG_ID_SET_KEY = 0;
    
    public static Map<Integer, float[]> getFrequencyMatrix(final List<Integer> userIdList, final List<Integer> songIdList, final List<DownloadRecord> downloadList, final List<PlayRecord> playList, final List<Collection> collectionList) {
        final Map<Integer, float[]> user2songRatingMatrix = new HashMap<Integer, float[]>();
        final int songLen = songIdList.size();
        final Map<Integer, Map<Integer, Set<Integer>>> userId2songIdDownloadMap = getUserId2songIdRecordMap(downloadList, false);
        final Map<Integer, Map<Integer, Set<Integer>>> userId2songIdCollectionMap = getUserId2songIdRecordMap(collectionList, false);
        final Map<Integer, Map<Integer, Set<Integer>>> userId2songIdPlayMap = getUserId2songIdRecordMap(playList, true);
        userIdList.forEach(new Consumer<Integer>() {
            public void accept(final Integer userId) {
                final float[] curUserRatingArray = new float[songLen];
                int songIndex = 0;
                for (final Integer songId : songIdList) {
                    if (userId2songIdDownloadMap.get(userId) != null && userId2songIdDownloadMap.get(userId).get(0).contains(songId)) {
                        final float[] array = curUserRatingArray;
                        final int n = songIndex;
                        array[n] += 2.0f;
                    }
                    if (userId2songIdCollectionMap.get(userId) != null && userId2songIdCollectionMap.get(userId).get(0).contains(songId)) {
                        final float[] array2 = curUserRatingArray;
                        final int n2 = songIndex;
                        array2[n2] += 5.0f;
                    }
                    if (userId2songIdPlayMap.get(userId) != null && userId2songIdPlayMap.get(userId).get(0).contains(songId)) {
                        final int count = userId2songIdPlayMap.get(userId).get(songId).iterator().next();
                        final float[] array3 = curUserRatingArray;
                        final int n3 = songIndex;
                        array3[n3] += 1.0f + count;
                    }
                    if (curUserRatingArray[songIndex] > 10.0f) {
                        curUserRatingArray[songIndex] = 10.0f;
                    }
                    ++songIndex;
                }
                user2songRatingMatrix.put(userId, curUserRatingArray);
            }
        });
        return user2songRatingMatrix;
    }
    
    private static <T> Map<Integer, Map<Integer, Set<Integer>>> getUserId2songIdRecordMap(final List<T> recordList, final boolean isCount) {
        final Map<Integer, Map<Integer, Set<Integer>>> userId2songIdRecordMap = new HashMap<Integer, Map<Integer, Set<Integer>>>();
        recordList.forEach(new Consumer<T>() {
            public void accept(final T t) {
                try {
                    final Field userIdField = t.getClass().getDeclaredField("userId");
                    final Field songIdField = t.getClass().getDeclaredField("songId");
                    userIdField.setAccessible(true);
                    songIdField.setAccessible(true);
                    final int userId = userIdField.getInt(t);
                    final int songId = songIdField.getInt(t);
                    if (!isCount) {
                        if (userId2songIdRecordMap.containsKey(userId)) {
                            final Map<Integer, Set<Integer>> curRecordSetMap = userId2songIdRecordMap.get(userId);
                            curRecordSetMap.get(0).add(songId);
                        }
                        else {
                            final Map<Integer, Set<Integer>> curRecordSetMap = new HashMap<Integer, Set<Integer>>();
                            final Set<Integer> curSongIdSet = new HashSet<Integer>();
                            curSongIdSet.add(songId);
                            curRecordSetMap.put(0, curSongIdSet);
                            userId2songIdRecordMap.put(userId, curRecordSetMap);
                        }
                    }
                    else if (userId2songIdRecordMap.containsKey(userId)) {
                        final Map<Integer, Set<Integer>> curRecordSetMap = userId2songIdRecordMap.get(userId);
                        curRecordSetMap.get(0).add(songId);
                        this.count(songId, curRecordSetMap);
                    }
                    else {
                        final Map<Integer, Set<Integer>> curRecordSetMap = new HashMap<Integer, Set<Integer>>();
                        final Set<Integer> curSongIdSet = new HashSet<Integer>();
                        curSongIdSet.add(songId);
                        curRecordSetMap.put(0, curSongIdSet);
                        userId2songIdRecordMap.put(userId, curRecordSetMap);
                        this.count(songId, curRecordSetMap);
                    }
                }
                catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
                catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                }
                catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                }
            }
            
            private void count(final int songId, final Map<Integer, Set<Integer>> curRecordSetMap) {
                if (curRecordSetMap.containsKey(songId)) {
                    final Set<Integer> curCountSet = curRecordSetMap.get(songId);
                    final int cnt = curCountSet.iterator().next() + 1;
                    curCountSet.clear();
                    curCountSet.add(cnt);
                }
                else {
                    final Set<Integer> curCountSet = new HashSet<Integer>();
                    curCountSet.add(1);
                    curRecordSetMap.put(songId, curCountSet);
                }
            }
        });
        return userId2songIdRecordMap;
    }
}
