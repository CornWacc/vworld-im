package com.corn.vworld.netty.base;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author yyc
 * @apiNote 基础处理器
 * */
public abstract class BaseHandler extends ChannelInboundHandlerAdapter implements Handler{

    protected final Logger log = LoggerFactory.getLogger(getClass());

    protected Channel channel;

    protected BaseFromUserInfo baseFromUserInfo;

    protected String toUserId;

    protected String msgContent;

    public BaseHandler() {
    }

    public BaseHandler(Channel channel, BaseFromUserInfo baseFromUserInfo){
        this.channel = channel;
        this.baseFromUserInfo = baseFromUserInfo;
    }

    public BaseHandler(Channel channel,BaseFromUserInfo baseFromUserInfo,String toUserId){
        this.channel = channel;
        this.baseFromUserInfo = baseFromUserInfo;
        this.toUserId = toUserId;
    }

    public BaseHandler(Channel channel,BaseFromUserInfo baseFromUserInfo,String toUserId,String msgContent){
        this.channel = channel;
        this.baseFromUserInfo = baseFromUserInfo;
        this.toUserId = toUserId;
        this.msgContent = msgContent;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public BaseFromUserInfo getBaseFromUserInfo() {
        return baseFromUserInfo;
    }

    public void setBaseFromUserInfo(BaseFromUserInfo baseFromUserInfo) {
        this.baseFromUserInfo = baseFromUserInfo;
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
}
