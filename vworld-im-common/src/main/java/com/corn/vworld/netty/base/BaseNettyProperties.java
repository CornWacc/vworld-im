package com.corn.vworld.netty.base;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class BaseNettyProperties {

    public static final Integer WRITE_MAX_LENGTH = 1024*64;

    public static final String WEBSOCKET_PATH = "/ws";

    /**
     * 连接组
     * */
    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
}
