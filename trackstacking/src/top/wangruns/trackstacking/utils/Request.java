// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.utils;

import top.wangruns.trackstacking.model.User;
import javax.servlet.http.HttpServletRequest;

public class Request
{
    public static User getUserFromHttpServletRequest(final HttpServletRequest request) {
        return (User)request.getSession().getAttribute("user");
    }
}
