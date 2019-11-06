package com.corn.vworld.netty.handler;

import com.corn.vworld.netty.base.Handler;
import io.netty.channel.Channel;

public class GroupChatHandler implements Handler {

    private Channel channel;

    public GroupChatHandler(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void execute() {
        //todo 此处应该是群聊
    }
}
