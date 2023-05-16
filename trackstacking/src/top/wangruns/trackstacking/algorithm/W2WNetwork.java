// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class W2WNetwork
{
    public static int getW2WIndex(final String node, final Set<String> wordSet) {
        final Iterator<String> iterator = wordSet.iterator();
        int index = 0;
        while (iterator.hasNext() && !iterator.next().equals(node)) {
            ++index;
        }
        return index;
    }
    
    public static String getW2WNode(final int index, final Set<String> wordSet) {
        final Iterator<String> iterator = wordSet.iterator();
        int i = 0;
        String node = null;
        while (iterator.hasNext()) {
            if (i == index) {
                node = iterator.next();
                break;
            }
            ++i;
        }
        return node;
    }
    
    public static Map<String, int[]> constructW2WN(final Set<String> wordSet, final StringBuilder wordSb) {
        final Map<String, int[]> w2wNetwork = new HashMap<String, int[]>();
        final String wordStr = wordSb.toString();
        final Iterator<String> curIterator = wordSet.iterator();
        final int setSize = wordSet.size();
        while (curIterator.hasNext()) {
            final String curWord = curIterator.next();
            final int curWordLen = curWord.length();
            final int[] weightArray = new int[setSize];
            int arrayIndex = 0;
            for (final String word : wordSet) {
                if (!word.equals(curWord)) {
                    int cnt = 0;
                    int indexOfCurWord = 0;
                    while (true) {
                        indexOfCurWord = wordStr.indexOf(curWord, indexOfCurWord);
                        if (indexOfCurWord == -1) {
                            break;
                        }
                        final int wordLen = word.length();
                        if (indexOfCurWord - wordLen >= 0 && wordStr.substring(indexOfCurWord - wordLen, indexOfCurWord).equals(word)) {
                            ++cnt;
                        }
                        if (indexOfCurWord + curWordLen + wordLen <= wordStr.length() && wordStr.substring(indexOfCurWord + curWordLen, indexOfCurWord + curWordLen + wordLen).equals(word)) {
                            ++cnt;
                        }
                        indexOfCurWord += curWordLen;
                    }
                    weightArray[arrayIndex] = cnt;
                }
                ++arrayIndex;
            }
            w2wNetwork.put(curWord, weightArray);
        }
        return w2wNetwork;
    }
}
