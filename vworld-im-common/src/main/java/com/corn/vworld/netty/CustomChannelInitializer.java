package com.corn.vworld.netty;

import com.corn.vworld.netty.base.BaseNettyProperties;
import com.corn.vworld.netty.handler.ConnectHandler;
import com.corn.vworld.netty.handler.WRHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;


/**
 * @author yyc
 * @apiNote 自定义初始化器
 * */
public class CustomChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {

        //获取对应的管道
        ChannelPipeline pipeline = socketChannel.pipeline();

        //设置管道处理器
        //Http编解码操作
        pipeline.addLast(new HttpServerCodec());

        //大数据流支持
        pipeline.addLast(new ChunkedWriteHandler());

        //HttpMessage聚合
        pipeline.addLast(new HttpObjectAggregator(BaseNettyProperties.WRITE_MAX_LENGTH));

        //webSocket处理协议
        pipeline.addLast(new WebSocketServerProtocolHandler(BaseNettyProperties.WEBSOCKET_PATH));

        //客户端连接断开处理器
        pipeline.addLast(new ConnectHandler());

        //读写处理器
        pipeline.addLast(new WRHandler());
    }
}
