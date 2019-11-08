package com.corn.vworld.netty.configuration;


import org.apache.dubbo.config.ProtocolConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author yyc
 * @apiNote dubbo配置类
 * */
@Configuration
public class DubboProtocolConfig {

    @Bean
    public ProtocolConfig createProtoColConfig(){

        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setPort(9066);
        return protocolConfig;
    }
}
