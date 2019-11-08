package com.corn.vworld.service.user.order;

import com.corn.boot.base.BaseOrder;


/**
 * @author yyc
 * @apiNote 用户在线情况列表查询入参
 * */
public class UserActiveListQueryOrder extends BaseOrder {

    private static final long serialVersionUID = -7414446826190392496L;

    /**
     * 当前用户id
     * */
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
