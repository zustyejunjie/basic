package thread.productAndConsumer;


/**
 * Created by yejunjie on 2017/2/11.
 */
public class Test {

    public static void main(String[] args) {

        Resources resources = new Resources();

        Productor productor = new Productor(resources);
        Consumer consumer = new Consumer(resources);

        Thread t = new Thread(productor);
        t.start();

        Thread t1 = new Thread(consumer);
        t1.start();
    }
}
