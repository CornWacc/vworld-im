package com.corn.vworld.netty.handler;

import com.corn.vworld.netty.base.Handler;
import io.netty.channel.Channel;


public class InitHandler implements Handler {

    private Channel channel;

    public InitHandler(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void execute() {
        //todo 此处应该放进去一个userId
    }
}
