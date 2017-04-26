package pattern.pubsub;

/**
 *
 * 主题类 调用观察者的方法 。
 * Created by Administrator on 2017/4/22 0022.
 */
public class Test {

    public static void main(String[] args) {
        AbstractSubject subject = new AbstractSubject();
        subject.attach(new Observer1());
        subject.attach(new Observer2());

        subject.Notify();
    }
}
