package com.itstack;



import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;

/**
 * Created by yejunjie on 2017/3/13.
 */
public class MyServerHanlder extends ChannelHandlerAdapter {


    /**
     * 客户端连接建立时触发
     * @param ctx
     * @throws Exception
     */
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        System.out.println("与客户端建立连接，客户端为："+ctx.channel().localAddress().toString());

        //添加到channelGroup 通道组
        MyChannelHandlerPool.channelGroup.add(ctx.channel());

        //只会通知到连接到他的客户端
        String str = "you have already get server"+" "+ctx.channel().id()+new Date()+" "+ctx.channel().localAddress();
        ctx.writeAndFlush(str);

    }

    /**
     * 客户端断开连接时触发
     * @param ctx
     * @throws Exception
     */
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

        // 从channelGroup中移除，当有客户端退出后，移除channel。
        MyChannelHandlerPool.channelGroup.remove(ctx.channel());

        System.out.println("与客户端断开连接，客户端为："+ctx.channel().localAddress().toString());

    }

    /**
     * 客户端发送数据时，接收数据
     * @param ctx
     * @param msg
     * @throws Exception
     */
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {

        //注意此处已经不需要手工解码了
        System.out.println("通道号："+ctx.channel().id()+" 接收的数据："+msg);

        //通知您已经链接上客户端[给客户端穿回去的数据加个换行]
        String str = "server data notifyAll client："+msg+"\r\n";

        //收到信息后，群发给所有小伙伴
        MyChannelHandlerPool.channelGroup.writeAndFlush(str);
    }


    /**
     * 完成接收数据后触发
     * @param ctx
     * @throws Exception
     */
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        ctx.flush();
    }

    /**
     * 发生异常时触发
     * @param ctx
     * @param cause
     * @throws Exception
     */
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        ctx.close();
        System.out.println("异常信息：\r\n"+cause.getMessage());
    }

}
