package atomic;

/**
 * Created by Administrator on 2017/3/29 0029.
 */
// AtomicReferenceTest.java的源码
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

    public static void main(String[] args){

        // 创建两个Person对象，它们的id分别是101和102。
        Person p1 = new Person(101);
        Person p2 = new Person(102);
        // 新建AtomicReference对象，初始化它的值为p1对象
        AtomicReference ar = new AtomicReference(p1);
        // 通过CAS设置ar。如果ar的值为p1的话，则将其设置为p2。
        ar.compareAndSet(p1, p2);

        Person p3 = (Person)ar.get();
        System.out.println("p3 is "+p3);
        System.out.println("p3.equals(p1)="+p3.equals(p1));

        AtomicBoolean isWriteIdled = new AtomicBoolean(true);
        Boolean b = isWriteIdled.compareAndSet(true, false);

        Boolean b1 = isWriteIdled.compareAndSet(true, false);

        Boolean b2 = isWriteIdled.compareAndSet(false, false);
        System.out.println(b);
        System.out.println(b1);
        System.out.println(b2);
    }
}

class Person {
    volatile long id;
    public Person(long id) {
        this.id = id;
    }
    public String toString() {
        return "id:"+id;
    }
}