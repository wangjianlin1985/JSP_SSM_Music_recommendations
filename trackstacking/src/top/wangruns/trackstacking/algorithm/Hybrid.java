// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.algorithm;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.Random;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletContext;
import top.wangruns.trackstacking.model.PlayRecord;
import top.wangruns.trackstacking.model.Collection;
import java.util.Map;
import top.wangruns.trackstacking.model.Song;
import java.util.List;

public class Hybrid
{
    public static Map<Integer, Integer[]> open(final List<Song> songList, final Map<Integer, Integer[]> user2songRecMatrix, final List<Collection> collectionList, final List<PlayRecord> playList, final ServletContext servletContext) {
        final Map<Integer, Integer[]> user2songRecMatrixHybrid = new HashMap<Integer, Integer[]>();
        final List<Song> engSongList = new ArrayList<Song>();
        filterChinese(servletContext, engSongList, songList);
        for (final Song s : engSongList) {
            System.out.println(s.getSongName());
        }
        System.out.println("------------filterChinese\u5b8c\u6210-------------");
        final StringBuilder wordSb = new StringBuilder();
        final Set<String> wordSet = getWordSet(servletContext, engSongList, wordSb);
        System.out.println("------------\u83b7\u53d6\u5355\u8bcd\u96c6\u5408\u5b8c\u6210-------------");
        final Map<String, int[]> w2wNetwork = W2WNetwork.constructW2WN(wordSet, wordSb);
        System.out.println("------------w2wNetwork\u7f51\u7edc\u6784\u5efa\u5b8c\u6210-------------");
        final Map<String, int[]> w2dNetwork = W2DNetwork.constructW2DN(wordSet, engSongList, servletContext);
        System.out.println("------------w2dNetwork\u7f51\u7edc\u6784\u5efa\u5b8c\u6210-------------");
        final int iter = 10;
        final int d = 5;
        final float alpha = 0.01f;
        final Map<Integer, float[]> lyricEmbedding = Training.train(engSongList, w2wNetwork, w2dNetwork, iter, d, alpha, wordSet);
        System.out.println("---------lyricEmbedding done----------");
        lyricEmbedding.forEach(new BiConsumer<Integer, float[]>() {
            public void accept(final Integer id, final float[] e) {
                String str = " ";
                for (int i = 0; i < e.length; ++i) {
                    str = String.valueOf(str) + e[i] + " ";
                }
                System.out.println("songId:" + id + ", e:" + e.toString() + ", " + str);
            }
        });
        final Map<Integer, Set<Integer>> user2EmbedSample = new HashMap<Integer, Set<Integer>>();
        user2songRecMatrix.forEach(new BiConsumer<Integer, Integer[]>() {
            public void accept(final Integer userId, final Integer[] recommendedSongIds) {
                final Set<Integer> originalIdSet = new HashSet<Integer>();
                final Set<Integer> collectedSongIdSet = getUserRecordIdSet(userId,  collectionList, lyricEmbedding.keySet());
                if (collectedSongIdSet.size() >= 1) {
                    collectedSongIdSet.forEach(new Consumer<Integer>() {
                        int cnt = 0;
                        
                        public void accept(final Integer id) {
                            if (this.cnt++ < 1) {
                                originalIdSet.add(id);
                            }
                        }
                    });
                }
                else {
                    int deltaN = 1 - collectedSongIdSet.size();
                    final Set<Integer> playedSongIdSet = getUserRecordIdSet(userId, playList, lyricEmbedding.keySet());
                    if (deltaN <= playedSongIdSet.size()) {
                        originalIdSet.addAll(collectedSongIdSet);
                        for (final Integer id : playedSongIdSet) {
                            if (deltaN-- <= 0) {
                                break;
                            }
                            originalIdSet.add(id);
                        }
                    }
                    else {
                        originalIdSet.addAll(collectedSongIdSet);
                        originalIdSet.addAll(playedSongIdSet);
                        deltaN = 1 - collectedSongIdSet.size() - playedSongIdSet.size();
                        final Set<Integer> embeddingSet = lyricEmbedding.keySet();
                        for (final Integer i : embeddingSet) {
                            if (!originalIdSet.contains(i)) {
                                originalIdSet.add(i);
                                --deltaN;
                            }
                            if (deltaN <= 0) {
                                break;
                            }
                        }
                    }
                }
                user2EmbedSample.put(userId, originalIdSet);
            }
        });
        final List<Integer> embedSongIdList = new ArrayList<Integer>();
        lyricEmbedding.keySet().forEach(new Consumer<Integer>() {
            public void accept(final Integer songId) {
                embedSongIdList.add(songId);
            }
        });
        final Map<Integer, Integer[]> itemKNNMatrix = UserKNN.getKNN(embedSongIdList, lyricEmbedding, 1);
        final float P = 0.5f;
        final Random random = new Random();
        user2songRecMatrix.forEach(new BiConsumer<Integer, Integer[]>() {
            public void accept(final Integer userId, final Integer[] recedSongIds) {
                final Set<Integer> embedSampleSet = user2EmbedSample.get(userId);
                final int originalIdSetSize = embedSampleSet.size();
                final Integer[] recIds = new Integer[originalIdSetSize];
                final Integer[] collaborativeFilterRecIds = user2songRecMatrix.get(userId);
                int index = 0;
                final Set<Integer> listenedSongIdSet = getUserRecordIdSet(userId, playList, lyricEmbedding.keySet());
                for (final Integer songId : embedSampleSet) {
                    final Integer[] similarSongIds = itemKNNMatrix.get(songId);
                    Integer[] array;
                    for (int length = (array = similarSongIds).length, i = 0; i < length; ++i) {
                        final Integer similarSongId = array[i];
                        recIds[index] = similarSongId;
                        if (random.nextFloat() > 0.5f && listenedSongIdSet.contains(similarSongId) && !isInArray(similarSongId, collaborativeFilterRecIds)) {
                            break;
                        }
                    }
                    ++index;
                }
                user2songRecMatrixHybrid.put(userId, recIds);
            }
        });
        return user2songRecMatrixHybrid;
    }
    
    private static <T> boolean isInArray(final T e, final T[] array) {
        for (final T t : array) {
            if (e.equals(t)) {
                return true;
            }
        }
        return false;
    }
    
    private static Set<String> getWordSet(final ServletContext servletContext, final List<Song> engSongList, final StringBuilder wordSb) {
        final Set<String> wordSet = new HashSet<String>();
        engSongList.forEach(new Consumer<Song>() {
            public void accept(final Song song) {
                final String realLyricAddress = servletContext.getRealPath(song.getLyricAddress());
                try {
                    final BufferedReader in = new BufferedReader(new FileReader(new File(realLyricAddress)));
                    try {
                        String s;
                        while ((s = in.readLine()) != null) {
                            if (s.trim().length() != 0) {
                                s = s.substring(s.lastIndexOf("]") + 1);
                                final String[] strArray = s.split(" ");
                                String[] array;
                                for (int length = (array = strArray).length, i = 0; i < length; ++i) {
                                    final String str = array[i];
                                    if (str.length() != 0) {
                                        wordSb.append(str);
                                        if (wordSet.isEmpty() || !wordSet.contains(str)) {
                                            wordSet.add(str);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    finally {
                        in.close();
                    }
                    in.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return wordSet;
    }
    
    private static void filterChinese(final ServletContext servletContext, final List<Song> engSongList, final List<Song> songList) {
        for (int len = songList.size(), i = 0; i < len; ++i) {
            final Song song = songList.get(i);
            if (!isContainChinese(song.getSongName())) {
                if (!isLyricContainChinese(servletContext.getRealPath(song.getLyricAddress()))) {
                    engSongList.add(song);
                }
            }
        }
    }
    
    private static boolean isLyricContainChinese(final String realLyricAddress) {
        try {
            final BufferedReader in = new BufferedReader(new FileReader(new File(realLyricAddress)));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    if (isContainChinese(s)) {
                        System.err.println(s);
                        return true;
                    }
                }
            }
            finally {
                in.close();
            }
            in.close();
        }
        catch (IOException e) {
            return true;
        }
        return false;
    }
    
    private static boolean isContainChinese(final String str) {
        final Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        final Matcher m = p.matcher(str);
        return m.find();
    }
    
    private static <T> Set<Integer> getUserRecordIdSet(final Integer userID, final List<T> list, final Set<Integer> embeddingIdSet) {
        final Set<Integer> set = new HashSet<Integer>();
        list.forEach(new Consumer<T>() {
            public void accept(final T t) {
                try {
                    final Field userIdField = t.getClass().getDeclaredField("userId");
                    userIdField.setAccessible(true);
                    final int userId = userIdField.getInt(t);
                    if (userId == userID) {
                        final Field songIdField = t.getClass().getDeclaredField("songId");
                        songIdField.setAccessible(true);
                        final int songId = songIdField.getInt(t);
                        if ((set.isEmpty() || !set.contains(songId)) && embeddingIdSet.contains(songId)) {
                            set.add(songId);
                        }
                    }
                }
                catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
                catch (SecurityException e2) {
                    e2.printStackTrace();
                }
                catch (IllegalArgumentException e3) {
                    e3.printStackTrace();
                }
                catch (IllegalAccessException e4) {
                    e4.printStackTrace();
                }
            }
        });
        return set;
    }
}
