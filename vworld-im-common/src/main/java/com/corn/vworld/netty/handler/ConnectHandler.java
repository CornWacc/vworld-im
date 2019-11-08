package com.corn.vworld.netty.handler;

import com.corn.vworld.netty.base.BaseHandler;
import com.corn.vworld.netty.base.BaseNettyProperties;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author yyc
 * @apiNote 该处理器仅处理连接与关闭
 * */
public class ConnectHandler extends BaseHandler {


    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        BaseNettyProperties.channels.add(channel);
        log.info("客户端连接:IP:{},当前连接数:{}",channel.remoteAddress(), BaseNettyProperties.channels.size());

    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        log.info("客户端断开:IP:{}",channel);

        //关闭客户端连接
        ctx.channel().close();
        BaseNettyProperties.channels.remove(channel);
    }

    @Override
    public void execute() {
    }
}
