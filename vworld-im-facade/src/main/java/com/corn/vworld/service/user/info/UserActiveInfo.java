package com.corn.vworld.service.user.info;

import com.corn.boot.base.Base;

/**
 * @author yyc
 * @apiNote 用户在线实体
 * */
public class UserActiveInfo extends Base {

    private static final long serialVersionUID = 4029419118106224487L;

    /**
     * 用户id
     * */
    private String userId;

    /**
     * 用户等级
     * */
    private Integer userLevel;

    /**
     * 用户在线情况
     * */
    private String activeStatus;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }
}
