package atomic;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Administrator on 2017/3/31 0031.
 */
public class AtomicBooleanTest {

    public static void main(String[] args) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);

        /**
         * 返回compare比较的值 然后set新值
         */
        System.out.println(atomicBoolean.compareAndSet(true,false));
        System.out.println(atomicBoolean.get());

    }
}
