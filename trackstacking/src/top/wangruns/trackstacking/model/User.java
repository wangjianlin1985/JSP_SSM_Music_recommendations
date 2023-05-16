// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.model;

import top.wangruns.trackstacking.utils.MD5Util;

public class User
{
    private int userId;
    private String email;
    private String password;
    private String validateCode;
    private String userName;
    
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(final String userName) {
        this.userName = userName;
    }
    
    public String getValidateCode() {
        return this.validateCode;
    }
    
    public void setValidateCode(final String validateCode) {
        this.validateCode = validateCode;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(final String password) {
        this.password = MD5Util.string2MD5(password);
    }
    
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(final int userId) {
        this.userId = userId;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(final String email) {
        this.email = email;
    }
}
