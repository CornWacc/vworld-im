package com.corn.vworld.netty.base;


/**
 * @author yyc
 * @apiNote 消息实体中的from用户实体
 * */
public class BaseFromUserInfo {

    private String userId;

    private String userName;

    private String userAvatar;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }
}
