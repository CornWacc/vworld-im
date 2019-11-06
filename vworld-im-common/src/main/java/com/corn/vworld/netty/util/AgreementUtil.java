package com.corn.vworld.netty.util;


import com.corn.boot.error.BizError;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yyc
 * @apiNote 协议处理工具
 * 协议格式 ws/type/userId/to/usermsg
 * */
public class AgreementUtil {

    private static final String MSG_PREFIX = "WS/";

    private static final Integer COMMON_LENGTH = 5;

    /**
     * 消息解析
     * */
    public static Map<String,String> analysisMsg(String msg){

        if(!msg.startsWith(MSG_PREFIX)){
            throw new BizError("消息协议异常,请校验协议文本:"+msg);
        }

        String[] strings = msg.split("/");

        if(strings.length < COMMON_LENGTH){
            throw new BizError("协议格式错误");
        }

        Map<String,String> map = new HashMap<>();
        map.put("prefix",strings[0]);
        map.put("type",strings[1]);
        map.put("userId",strings[2]);
        map.put("to",strings[3]);
        map.put("msg",strings[4]);

        return map;
    }

}
