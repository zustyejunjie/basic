package guava.eventbus;

/**
 * Created by Administrator on 2017/4/22 0022.
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {

        DataObserver1 observer1 = new DataObserver1();
        DataObserver2 observer2 = new DataObserver2();

        //注册
        EventBusCenter.register(observer1);
        EventBusCenter.register(observer2);


        // 只有注册的参数类型为String的方法会被调用
        EventBusCenter.post("post string method");
        EventBusCenter.post(123);

        // 注销observer2
        EventBusCenter.unregister(observer2);
        EventBusCenter.post("post string method");
        EventBusCenter.post(123);

    }
}
