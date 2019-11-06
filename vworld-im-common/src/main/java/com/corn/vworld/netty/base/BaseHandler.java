package com.corn.vworld.netty.base;

import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author yyc
 * @apiNote 基础处理器
 * */
public abstract class BaseHandler extends ChannelInboundHandlerAdapter {

    protected final Logger log = LoggerFactory.getLogger(getClass());

}
