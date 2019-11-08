package com.corn.vworld.netty.handler;

import com.corn.vworld.netty.base.BaseFromUserInfo;
import com.corn.vworld.netty.base.BaseHandler;
import io.netty.channel.Channel;

public class GroupChatHandler extends BaseHandler {

    public GroupChatHandler(Channel channel, BaseFromUserInfo baseFromUserInfo, String toUserId, String msgContent) {
        super(channel, baseFromUserInfo, toUserId, msgContent);
    }

    @Override
    public void execute() {
        //todo 此处应该是群聊
    }
}
