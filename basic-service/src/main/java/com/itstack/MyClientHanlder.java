package com.itstack;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;


/**
 * Created by yejunjie on 2017/3/15.
 */
public class MyClientHanlder extends ChannelHandlerAdapter {


    /**
     *
     * @param ctx
     * @throws Exception
     */
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        System.out.println("客户端与服务端通道-开启："+ctx.channel().localAddress()+"channelActive");

    }

    /**
     *
     * @param ctx
     * @throws Exception
     */
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

        System.out.println("客户端与服务端通道-关闭："+ctx.channel().localAddress()+"channelInactive");

    }

    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {

        //注意此处已经不需要手工解码了
        System.out.println("客户端接收到数据"+msg);


        //加一个换行
        String str = (String) msg+"\r\n";

        //发送给服务端
        ctx.writeAndFlush(str);
    }

    /**
     *
     * @param ctx
     * @throws Exception
     */
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    /**
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        ctx.close();
        System.out.println("异常退出:"+cause.getMessage());
    }
}
