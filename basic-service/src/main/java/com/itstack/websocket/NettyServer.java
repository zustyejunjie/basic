package com.itstack.websocket;

import com.google.common.collect.LinkedHashMultimap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import javax.naming.ldap.HasControls;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yejunjie on 2017/3/17.
 */
public class NettyServer {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("aa","bb");

        map.remove("aa");

        LinkedHashMultimap<String,Object> queue = LinkedHashMultimap.create();
        queue.put("aa","bb");
        queue.put("aa","cc");

        queue.get("aa");




        map.remove("aa");

        new NettyServer().run();




    }

    public void run(){

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try {

            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workGroup);
            b.channel(NioServerSocketChannel.class);
            b.childHandler(new ChildChannelHandler());

            System.out.println("服务端开启等待客户端连接 ... ...");

            Channel ch = b.bind(7397).sync().channel();

            ch.closeFuture().sync();

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }
}
