package com.corn.vworld.netty.handler;

import com.corn.boot.error.BizError;
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

import java.util.Map;

/**
 * @author yyc
 * @apiNote 读写处理器
 * */
public class WRHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static final Logger log = LoggerFactory.getLogger(WRHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {

        log.info("接收到客户端信息:{}",msg.text());
        Map<String,String> msgMap = AgreementUtil.analysisMsg(msg.text());
        executeByType(msgMap,ctx.channel());
    }

    private void executeByType(Map<String,String> map, Channel channel){

        String type = map.get("type");
        WSMsgEnum wsMsgEnum = WSMsgEnum.getEnumByCode(type);
        if(ObjectUtils.isEmpty(wsMsgEnum)){
            throw new BizError("协议类型异常:"+type);
        }

        switch (wsMsgEnum){
            case INIT:
                doInit(channel).execute();
                break;
            case SINGLE:
                doSingle(channel).execute();
                break;
            case GROUP:
                doGroup(channel).execute();
                break;
            default : throw new BizError("未知协议类型:"+type);
        }
    }

    private Handler doSingle(Channel channel){
        return new SingleChatHandler(channel);
    }

    private Handler doGroup(Channel channel){
        return new GroupChatHandler(channel);
    }

    private Handler doInit(Channel channel){
        return new InitHandler(channel);
    }

}
