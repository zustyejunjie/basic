package com.itstack;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * Created by yejunjie on 2017/3/15.
 */
public class ClientChildChannelHandler extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel e) throws Exception {

        System.out.println("客户端链接到服务端");


        //基于行的半包粘包处理、String类型解码、String类型编码、消息处理
        e.pipeline().addLast(new LineBasedFrameDecoder(1024));
        e.pipeline().addLast(new StringDecoder());
        e.pipeline().addLast(new StringEncoder());
        e.pipeline().addLast(new MyClientHanlder());

    }
}
