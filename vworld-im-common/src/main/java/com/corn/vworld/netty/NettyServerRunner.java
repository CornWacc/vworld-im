package com.corn.vworld.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.string.StringDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


/**
 * @author yyc
 * @apiNote netty启动类
 */
@Component
@PropertySource("classpath:/application.properties")
public class NettyServerRunner implements CommandLineRunner{

    private static final Logger log = LoggerFactory.getLogger(NettyServerRunner.class);

    @Value("${netty.port}")
    private String nettyPort;

    /**
     * 读写线程组大小
     */
    @Value("${netty.workgroup.size}")
    private String workGroupSize;

    /**
     * 连接线程组大小
     */
    @Value("${netty.bossgroup.size}")
    private String bossGroupSize;

    /**
     * 连接线程组
     */
    private EventLoopGroup mainGroup;

    /**
     * 读写线程组
     */
    private EventLoopGroup supGroup;

    /**
     * 辅助器
     */
    private ServerBootstrap serverBootstrap;


    @PostConstruct
    private void init() {
        this.mainGroup = new NioEventLoopGroup(Integer.valueOf(bossGroupSize));
        this.supGroup = new NioEventLoopGroup(Integer.valueOf(workGroupSize));
        serverBootstrap = new ServerBootstrap();
    }

    @Override
    public void run(String... args) {
        nettyStart();
    }

    private void nettyStart() {

        try {
            ChannelFuture channelFuture =
                    serverBootstrap
                            .group(mainGroup, supGroup)
                            .channel(NioServerSocketChannel.class)
                            .childHandler(new CustomChannelInitializer())
                            .bind(Integer.valueOf(nettyPort)).sync()
                            .addListeners(future -> {
                                if (future.isSuccess()) {
                                    log.info("------------ netty服务器启动成功:监听端口:{} ----------", nettyPort);
                                } else {
                                    log.info("------------ netty服务器启动失败:监听端口:{} ----------", nettyPort);
                                }
                            });

            channelFuture.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            log.info("netty客户端关闭");
            mainGroup.shutdownGracefully();
            supGroup.shutdownGracefully();
        }

    }
}
