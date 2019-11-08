package com.corn.vworld.netty.handler;

import com.alibaba.fastjson.JSON;
import com.corn.vworld.netty.base.BaseFromUserInfo;
import com.corn.vworld.netty.base.BaseHandler;
import com.corn.vworld.netty.base.BaseNettyProperties;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author yyc
 * @apiNote 初始化用户通道映射
 * */
public class InitHandler extends BaseHandler {

    @Autowired
    private RedisTemplate redisTemplate;

    public InitHandler(Channel channel, BaseFromUserInfo baseFromUserInfo) {
        super(channel, baseFromUserInfo);
    }

    @Override
    public void execute() {

        //建立用户id和通道的关联
        BaseNettyProperties.userChannelMap.put(baseFromUserInfo.getUserId(),channel);

        log.info("当前登录人:{}", JSON.toJSON(BaseNettyProperties.userChannelMap.keys()));
        //设置Redis通道缓存
//        redisTemplate.opsForValue().set();
    }
}
