package com.corn.vworld.netty.util;


import com.alibaba.fastjson.JSON;
import com.corn.boot.error.BizError;
import com.corn.vworld.netty.base.BaseFromUserInfo;
import com.corn.vworld.netty.base.BaseMsgInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yyc
 * @apiNote 协议处理工具
 * 协议格式 ws/type/fromuser/to/usermsg
 * */
public class AgreementUtil {

    private static final String MSG_PREFIX = "WS/";

    private static final Integer COMMON_LENGTH = 5;

    private static final String SPLID_REGEX = "/x/";

    /**
     * 消息解析
     * */
    public static BaseMsgInfo analysisMsg(String msg){

        if(!msg.startsWith(MSG_PREFIX)){
            throw new BizError("消息协议异常,请校验协议文本:"+msg);
        }

        String[] strings = msg.split(SPLID_REGEX);

        if(strings.length < COMMON_LENGTH){
            throw new BizError("协议格式错误");
        }

        BaseFromUserInfo baseFromMsgInfo = JSON.parseObject(strings[2],BaseFromUserInfo.class);

        BaseMsgInfo baseMsgInfo = new BaseMsgInfo();
        baseMsgInfo.setType(strings[1]);
        baseMsgInfo.setBaseMsgUserInfo(baseFromMsgInfo);
        baseMsgInfo.setToUserId(strings[3]);
        baseMsgInfo.setMsgContent(strings[4]);

        return baseMsgInfo;
    }

}
