package com.corn.vworld.netty.base;


/**
 * @author yyc
 * @apiNote 基础信息实体
 * */
public class BaseMsgInfo {

    private BaseFromUserInfo baseMsgUserInfo;

    private String toUserId;

    private String msgContent;

    private String type;

    public BaseFromUserInfo getBaseMsgUserInfo() {
        return baseMsgUserInfo;
    }

    public void setBaseMsgUserInfo(BaseFromUserInfo baseMsgUserInfo) {
        this.baseMsgUserInfo = baseMsgUserInfo;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
