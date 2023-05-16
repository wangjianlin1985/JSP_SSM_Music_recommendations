// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.utils;

import java.util.Random;

public class OneDayOneWord
{
    public static String getOneDayOneWord(final String[] wordArray) {
        if (wordArray == null) {
            return " ";
        }
        final Random random = new Random();
        final String oneDayOneWord = wordArray[random.nextInt(wordArray.length)];
        return oneDayOneWord;
    }
}
