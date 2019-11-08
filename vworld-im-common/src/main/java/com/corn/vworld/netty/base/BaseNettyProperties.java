package com.corn.vworld.netty.base;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.concurrent.ConcurrentHashMap;

public class BaseNettyProperties {

    public static final Integer WRITE_MAX_LENGTH = 1024*64;

    public static final String WEBSOCKET_PATH = "/ws";

    /**
     * 连接组
     * */
    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 连接关联
     * */
    public static ConcurrentHashMap<String, Channel> userChannelMap = new ConcurrentHashMap<>();
}
