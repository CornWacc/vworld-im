package com.corn.vworld;


import com.corn.boot.annotations.Runner;
import com.corn.boot.base.RunMain;
import com.corn.vworld.netty.NettyServerRunner;

@Runner(port = "9099")
public class Main {

    public static void main(String[] args) {

        //todo 此处由于netty启动会同步阻塞在连接监听中待优化
        RunMain.springRun(Main.class);
    }

}
