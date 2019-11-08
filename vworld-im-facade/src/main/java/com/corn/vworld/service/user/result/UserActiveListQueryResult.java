package com.corn.vworld.service.user.result;

import com.corn.boot.base.BaseRes;
import com.corn.vworld.service.user.info.UserActiveInfo;

import java.util.List;


/**
 * @author yyc
 * @apiNote
 * */
public class UserActiveListQueryResult extends BaseRes {

    private static final long serialVersionUID = 8792160862540519504L;


    /**
     * 用户在线情况列表
     * */
    private List<UserActiveInfo> userActiveInfoList;

    public List<UserActiveInfo> getUserActiveInfoList() {
        return userActiveInfoList;
    }

    public void setUserActiveInfoList(List<UserActiveInfo> userActiveInfoList) {
        this.userActiveInfoList = userActiveInfoList;
    }
}
