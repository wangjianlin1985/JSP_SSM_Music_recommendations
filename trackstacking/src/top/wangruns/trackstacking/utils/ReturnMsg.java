// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.utils;

import com.alibaba.fastjson.JSONObject;

public class ReturnMsg
{
    public static String msg(final int status, final String detail) {
        final JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", (Object)status);
        jSONObject.put("msg", (Object)detail);
        final String res = jSONObject.toJSONString();
        System.out.println(res);
        return res;
    }
}
