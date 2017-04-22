package guava.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * Created by Administrator on 2017/4/22 0022.
 */
public class DataObserver1 {

    /**
     * 只有通过@Subscribe注解的方法才会被注册进EventBus
     * 而且方法有且只能有1个参数
     *
     * @param msg
     */
    @Subscribe
    public void func(String msg) {
        System.out.println("DataObserver1收到的消息: " + msg);
    }

    @Subscribe
    public void func1(String msg) {
        System.out.println("另一个函数func1: " + msg);
    }

}
