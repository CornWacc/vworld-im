package com.corn.vworld.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ConnectHandler extends SimpleChannelInboundHandler {

    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        System.out.println(channelHandlerContext.name());
    }
}
