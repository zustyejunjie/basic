package com.itstack.websocket1;

/**
 * Created by Administrator on 2017/5/5 0005.
 */
public class PingMsg extends BaseMsg {
    public PingMsg() {
        super();
        setType(MsgType.PING);
    }
}