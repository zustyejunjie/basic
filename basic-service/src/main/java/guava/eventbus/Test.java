package guava.eventbus;

import com.google.common.eventbus.EventBus;

/**
 * Created by yejj on 2017/5/18 0018.
 */
public class Test {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        eventBus.register(new Event());//注册事件
        eventBus.register(new Event1());
        eventBus.post("ssdf");// 触发事件处理
    }

}
