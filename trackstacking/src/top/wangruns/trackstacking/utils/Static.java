// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.utils;

public class Static
{
    public static volatile boolean isFromA;
    public static final long PERIOD_DAY = 86400000L;
    public static final int START_HOUR = 6;
    public static final int START_MINUTE = 0;
    public static final int START_SECOND = 0;
    public static final boolean IS_START_TOMORROW = false;
    public static final int K = 2;
    public static final int N = 10;
    public static final String[] RANKING_WORD_ARRAY;
    public static final String[] MY_MUSIC_WORD_ARRAY;
    public static final String[] SEARCH_WORD_ARRAY;
    public static final boolean IS_HYBRID = false;
    public static final int N_HYBRID = 1;
    
    static {
        Static.isFromA = true;
        RANKING_WORD_ARRAY = new String[] { "\u767e\u5c3a\u7aff\u5934", "\u6b65\u6b65\u9ad8\u5347", "\u7cbe\u76ca\u6c42\u7cbe", "\u767b\u5802\u5165\u5ba4", "\u767b\u5cf0\u9020\u6781", "\u6cf0\u5c71\u5317\u6597", "\u529f\u6210\u540d\u5c31", "\u5927\u5c55\u9e3f\u56fe", "\u7089\u706b\u7eaf\u9752" };
        MY_MUSIC_WORD_ARRAY = new String[] { "\u56db\u9762\u695a\u6b4c", "\u4f59\u97f3\u7ed5\u6881", "\u9761\u9761\u4e4b\u97f3", "\u6263\u4eba\u5fc3\u5f26", "\u9ad8\u5c71\u6d41\u6c34", "\u56db\u9762\u695a\u6b4c", "\u66f2\u9ad8\u548c\u5be1", "\u4f59\u97f3\u8885\u8885", "\u4e00\u5531\u4e09\u53f9", "\u56db\u9762\u695a\u6b4c", "\u7ed5\u6881\u4e09\u65e5", "\u6e38\u9c7c\u51fa\u542c" };
        SEARCH_WORD_ARRAY = new String[] { "\u4f17\u91cc\u5bfb\u4ed6", "\u8ba1\u83b7\u4e8b\u8db3", "\u671b\u773c\u6b32\u7a7f", "\u8e0f\u7834\u94c1\u978b", "\u5982\u613f\u4ee5\u507f", "\u4e1c\u5bfb\u897f\u89c5", "\u6478\u7d22\u95e8\u5f84", "\u5bfb\u8e2a\u89c5\u8ff9" };
    }
}
