// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.utils;

import java.security.MessageDigest;

public class MD5Util
{
    public static String string2MD5(final String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        }
        catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        final char[] charArray = inStr.toCharArray();
        final byte[] byteArray = new byte[charArray.length];
        for (int i = 0; i < charArray.length; ++i) {
            byteArray[i] = (byte)charArray[i];
        }
        final byte[] md5Bytes = md5.digest(byteArray);
        final StringBuffer hexValue = new StringBuffer();
        for (int j = 0; j < md5Bytes.length; ++j) {
            final int val = md5Bytes[j] & 0xFF;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
}
