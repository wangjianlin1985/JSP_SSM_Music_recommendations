// 
// Decompiled by Procyon v0.5.29
// 

package trackstacking;

import java.lang.reflect.Field;
import top.wangruns.trackstacking.model.DownloadRecord;

public class DataTranslateTest
{
    public static void main(final String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        final DownloadRecord dr = new DownloadRecord();
        dr.setUserId(1);
        dr.setSongId(100);
        final Field f = dr.getClass().getDeclaredField("userId");
        f.setAccessible(true);
        System.out.println(f.getInt(dr));
    }
}
