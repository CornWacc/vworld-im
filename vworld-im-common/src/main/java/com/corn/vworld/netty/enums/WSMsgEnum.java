package com.corn.vworld.netty.enums;


import java.io.Serializable;
import java.util.Comparator;

/**
 * @author yyc
 * @apiNote websocket type类型协议枚举
 * */
public enum WSMsgEnum implements Comparator<WSMsgEnum> {

    INIT("INIT","初始化"),
    SINGLE("SINGLE","单聊"),
    GROUP("GROUP","群聊");

    private final String code;

    private final String msg;

    WSMsgEnum(String code,String msg) {
        this.code = code;
        this.msg =msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static WSMsgEnum getEnumByCode(String s){

        for(WSMsgEnum wsMsgEnum : values()){
            if(wsMsgEnum.code.equals(s)){
                return wsMsgEnum;
            }
        }
        return null;
    }


    @Override
    public int compare(WSMsgEnum o1, WSMsgEnum o2) {

        if(o1.code.equals(o2.code)){
            return 1;
        }else{
            return 0;
        }
    }
}
