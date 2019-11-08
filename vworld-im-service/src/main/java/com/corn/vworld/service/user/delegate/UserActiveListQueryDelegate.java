package com.corn.vworld.service.user.delegate;

import com.corn.boot.base.AbstractBizService;
import com.corn.vworld.service.user.order.UserActiveListQueryOrder;
import com.corn.vworld.service.user.result.UserActiveListQueryResult;
import org.springframework.stereotype.Service;


/**
 * @author yyc
 * @apiNote 用户在线情况列表查询
 * */
@Service
public class UserActiveListQueryDelegate extends AbstractBizService<UserActiveListQueryOrder, UserActiveListQueryResult> {

    protected UserActiveListQueryResult initResult() {
        return null;
    }

    protected void orderCheck(UserActiveListQueryOrder order) {

    }

    protected void appBiz(UserActiveListQueryOrder order, UserActiveListQueryResult result) {

    }
}
