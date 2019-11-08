package com.corn.vworld.service.user;

import com.corn.vworld.service.user.delegate.UserActiveListQueryDelegate;
import com.corn.vworld.service.user.order.UserActiveListQueryOrder;
import com.corn.vworld.service.user.result.UserActiveListQueryResult;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yyc
 * @apiNote 用户IM服务端实现
 * */
@Service
public class UserIMFacadeImpl implements UserIMFacade {

    @Autowired
    private UserActiveListQueryDelegate userActiveListQueryDelegate;

    public UserActiveListQueryResult userActiveListQuery(UserActiveListQueryOrder order) {
        return userActiveListQueryDelegate.execute("用户在线情况列表查询",order);
    }
}
