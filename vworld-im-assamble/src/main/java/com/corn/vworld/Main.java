package com.corn.vworld;


import com.corn.boot.annotations.Runner;
import com.corn.boot.base.RunMain;
import com.corn.vworld.netty.NettyServerRunner;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.PropertySource;


@EnableDubbo(scanBasePackages = "com.corn.vworld.service")
@PropertySource("classpath:application.properties")
@Runner(port = "9099")
public class Main {

    public static void main(String[] args) {

        RunMain.springRun(Main.class);
    }

}
