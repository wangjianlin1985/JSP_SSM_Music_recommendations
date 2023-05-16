// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.algorithm;

import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import java.util.Set;
import top.wangruns.trackstacking.model.Song;
import java.util.List;

public class W2DNetwork
{
    public static int getW2DNode(final int index, final List<Song> songList) {
        return songList.get(index).getSongId();
    }
    
    public static Map<String, int[]> constructW2DN(final Set<String> wordSet, final List<Song> engSongList, final ServletContext servletContext) {
        final Map<String, int[]> w2dNetwork = new HashMap<String, int[]>();
        for (final String curWord : wordSet) {
            final int[] weightArray = new int[engSongList.size()];
            int arrayIndex = 0;
            final int curWordLen = curWord.length();
            for (final Song song : engSongList) {
                int cnt = 0;
                final StringBuilder documentSb = readContentSb(servletContext.getRealPath(song.getLyricAddress()));
                int indexOfCurWord = 0;
                while (true) {
                    indexOfCurWord = documentSb.indexOf(curWord, indexOfCurWord);
                    if (indexOfCurWord == -1) {
                        break;
                    }
                    ++cnt;
                    indexOfCurWord += curWordLen;
                }
                weightArray[arrayIndex++] = cnt;
            }
            w2dNetwork.put(curWord, weightArray);
        }
        return w2dNetwork;
    }
    
    private static StringBuilder readContentSb(final String realPath) {
        final StringBuilder wordSb = new StringBuilder();
        try {
            final BufferedReader in = new BufferedReader(new FileReader(new File(realPath)));
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
        return wordSb;
    }
}
