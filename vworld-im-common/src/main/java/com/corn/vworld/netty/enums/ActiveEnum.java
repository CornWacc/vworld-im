package com.corn.vworld.netty.enums;

public enum ActiveEnum {

    ONLINE("ONLINE","在线"),
    OFFLINE("OFFLINE","离线");

    private final String code;

    private final String msg;

    ActiveEnum(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public static ActiveEnum getEnumByCode(String s){

        for(ActiveEnum activeEnum : values()){
            if(activeEnum.code.equals(s)){
                return activeEnum;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
