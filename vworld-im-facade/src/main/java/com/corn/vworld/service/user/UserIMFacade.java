package com.corn.vworld.service.user;


import com.corn.vworld.service.user.order.UserActiveListQueryOrder;
import com.corn.vworld.service.user.result.UserActiveListQueryResult;

/**
 * @author yyc
 * @apiNote 用户IM操作接口
 * */
public interface UserIMFacade {

    /**
     * 用户在线情况列表查询
     * */
    UserActiveListQueryResult userActiveListQuery(UserActiveListQueryOrder order);
}
