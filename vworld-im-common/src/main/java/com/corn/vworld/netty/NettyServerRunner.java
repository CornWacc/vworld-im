package com.corn.vworld.netty;

import com.corn.vworld.netty.handler.ConnectHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * @author yyc
 * @apiNote netty启动类
 */
@Component
public class NettyServerRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(NettyServerRunner.class);

    @Value("${netty.port}")
    private String nettyPort;

    private EventLoopGroup mainGroup;

    private EventLoopGroup supGroup;

    private ServerBootstrap serverBootstrap;


    public NettyServerRunner() {
        this.mainGroup = new NioEventLoopGroup();
        this.supGroup = new NioEventLoopGroup();
        serverBootstrap = new ServerBootstrap();
    }

    public void run(String... args) throws Exception {

        this.nettyStart();
    }

    private void nettyStart() {

        serverBootstrap
                .group(mainGroup, supGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new ConnectHandler());
                    }
                }).bind(Integer.valueOf(nettyPort)).
                addListeners(new GenericFutureListener<Future<? super Void>>() {
                    public void operationComplete(Future<? super Void> future) throws Exception {
                        if (future.isSuccess()) {
                            log.info("------------ netty服务器启动成功:监听端口:{} ----------", nettyPort);
                        } else {
                            log.info("------------ netty服务器启动失败:监听端口:{} ----------", nettyPort);
                        }
                    }

                });

    }
}
