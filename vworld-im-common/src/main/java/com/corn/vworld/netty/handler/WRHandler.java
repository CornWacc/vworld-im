package com.corn.vworld.netty.handler;

import com.corn.boot.error.BizError;
import com.corn.vworld.netty.base.BaseFromUserInfo;
import com.corn.vworld.netty.base.BaseMsgInfo;
import com.corn.vworld.netty.base.Handler;
import com.corn.vworld.netty.enums.WSMsgEnum;
import com.corn.vworld.netty.util.AgreementUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

/**
 * @author yyc
 * @apiNote 读写处理器
 * */
public class WRHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static final Logger log = LoggerFactory.getLogger(WRHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {

        log.info("接收到客户端信息:{}",msg.text());

        BaseMsgInfo baseMsgInfo = AgreementUtil.analysisMsg(msg.text());
        executeByType(baseMsgInfo,ctx.channel());
    }

    private void executeByType(BaseMsgInfo baseMsgInfo, Channel channel){

        BaseFromUserInfo fromUserInfo = baseMsgInfo.getBaseMsgUserInfo();
        String type = baseMsgInfo.getType();
        String toUserId = baseMsgInfo.getToUserId();
        String msgContent = baseMsgInfo.getMsgContent();

        WSMsgEnum wsMsgEnum = WSMsgEnum.getEnumByCode(type);
        if(ObjectUtils.isEmpty(wsMsgEnum)){
            throw new BizError("协议类型异常:"+type);
        }

        switch (wsMsgEnum){
            case INIT:
                doInit(channel,fromUserInfo).execute();
                break;
            case SINGLE:
                doSingle(channel,fromUserInfo,toUserId,msgContent).execute();
                break;
            case GROUP:
                doGroup(channel,fromUserInfo,toUserId,msgContent).execute();
                break;
            default : throw new BizError("未知协议类型:"+type);
        }
    }

    private Handler doSingle(Channel channel,BaseFromUserInfo fromUserInfo,String toUserId,String msgContent){
        return new SingleChatHandler(channel,fromUserInfo,toUserId,msgContent);
    }

    private Handler doGroup(Channel channel,BaseFromUserInfo fromUserInfo,String groupId,String msgContent){
        return new GroupChatHandler(channel,fromUserInfo,groupId,msgContent);
    }

    private Handler doInit(Channel channel,BaseFromUserInfo fromUserInfo){
        return new InitHandler(channel,fromUserInfo);
    }

}
