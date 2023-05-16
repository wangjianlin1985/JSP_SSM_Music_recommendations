// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.algorithm;

public class Operator
{
    public static void assign(final float[] leftV, final float[] rightV) {
        for (int len = leftV.length, i = 0; i < len; ++i) {
            leftV[i] = rightV[i];
        }
    }
    
    public static float[] dotTimes(final float realNumber, final float[] array) {
        final int len = array.length;
        final float[] res = new float[len];
        for (int i = 0; i < len; ++i) {
            res[i] = array[i] * realNumber;
        }
        return res;
    }
    
    public static float[] dotTimes(final float[] array1, final float[] array2) {
        final int len = array1.length;
        final float[] res = new float[len];
        for (int i = 0; i < len; ++i) {
            res[i] = array1[i] * array2[i];
        }
        return res;
    }
    
    public static float[] dotMinus(final float[] array1, final float[] array2) {
        final int len = array1.length;
        final float[] res = new float[len];
        for (int i = 0; i < len; ++i) {
            res[i] = array1[i] - array2[i];
        }
        return res;
    }
    
    public static float times(final float[] e1, final float[] e2) {
        float res = 0.0f;
        for (int len = e1.length, i = 0; i < len; ++i) {
            res += e1[i] * e2[2];
        }
        return res;
    }
    
    public static void add(final float[] e1, final float[] e2) {
        for (int len = e1.length, i = 0; i < len; ++i) {
            final int n = i;
            e1[n] += e2[i];
        }
    }
    
    public static float[] divide(final float[] e, final float realNumber) {
        final int len = e.length;
        final float[] res = new float[len];
        for (int i = 0; i < len; ++i) {
            res[i] = e[i] / realNumber;
        }
        return res;
    }
}
