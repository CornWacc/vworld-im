package com.corn.vworld.netty.handler;

import com.alibaba.fastjson.JSON;
import com.corn.vworld.netty.base.BaseFromUserInfo;
import com.corn.vworld.netty.base.BaseHandler;
import com.corn.vworld.netty.base.BaseMsgInfo;
import com.corn.vworld.netty.base.BaseNettyProperties;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.util.ObjectUtils;


public class SingleChatHandler extends BaseHandler {

    public SingleChatHandler(Channel channel, BaseFromUserInfo baseFromUserInfo, String toUserId, String msgContent) {
        super(channel, baseFromUserInfo, toUserId, msgContent);
    }

    @Override
    public void execute() {
        //todo 此处应该是单聊
        Channel toChannel = BaseNettyProperties.userChannelMap.get(toUserId);

        //判断是否在线
        if(ObjectUtils.isEmpty(toChannel)){
            return;
        }

        //判断是否已连接
        if(toChannel.isActive()){

            //构建消息
            BaseMsgInfo baseMsgInfo = new BaseMsgInfo();
            baseMsgInfo.setBaseMsgUserInfo(baseFromUserInfo);
            baseMsgInfo.setMsgContent(msgContent);

            String sendMsg = JSON.toJSONString(baseMsgInfo);
            toChannel.writeAndFlush(new TextWebSocketFrame(sendMsg));
        }
    }
}
