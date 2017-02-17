package thread.reentrantlock;

/**
 * 可重入互斥锁  ReentrantLock
 *
 * Created by yejunjie on 2017/2/13.
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1：生产和消费商品 都在仓库的类中，是因为在多线程环境下，共享变量，也就是临界区资源，就是该仓库的某一个实例。
 * 2：在消费者和生产者线程中，该实例通过构造函数传入
 * 通过独占锁lock实现对仓库的互斥访问
 */

// 仓库
class Depot {
    private int size;        // 仓库的实际数量
    private Lock lock;        // 独占锁

    public Depot() {
        //新建仓库时，初始数量为0，新建一个可重入的互斥锁
        this.size = 0;
        this.lock = new ReentrantLock();
    }

    //仓库生产商品
    public void produce(int val) {
        //获取仓库的锁
        lock.lock();
        try {
            size += val;
            System.out.printf("%s produce(%d) --> 仓库目前有商品=%d个\n",
                    Thread.currentThread().getName(), val, size);
        } finally {
            //释放锁  finally 除非jvm退出否则最后都会执行该步骤
            lock.unlock();
        }
    }

    //仓库消费商品
    public void consume(int val) {
        //获取锁
        lock.lock();
        try {
            size -= val;
            System.out.printf("%s consume(%d) <-- 仓库目前有商品size=%d\n个",
                    Thread.currentThread().getName(), val, size);
        } finally {
            //释放锁
            lock.unlock();
        }
    }
};

// 生产者
class Producer {
    private Depot depot;

    public Producer(Depot depot) {
        this.depot = depot;
    }

    // 消费产品：新建一个线程向仓库中生产产品。
    public void produce(final int val) {
        new Thread() {
            public void run() {
                System.out.println(Thread.currentThread().getName()+"线程开始生产商品");
                depot.produce(val);
            }
        }.start();
    }
}

// 消费者
class Customer {
    private Depot depot;

    public Customer(Depot depot) {
        this.depot = depot;
    }

    // 消费产品：新建一个线程从仓库中消费产品。
    public void consume(final int val) {
        new Thread() {
            public void run() {
                System.out.println(Thread.currentThread().getName()+"线程开始消费商品");
                depot.consume(val);
            }
        }.start();
    }
}

public class LockTest1 {
    public static void main(String[] args) {
        Depot mDepot = new Depot();
        Producer mPro = new Producer(mDepot);
        Customer mCus = new Customer(mDepot);

        mPro.produce(60);
        mPro.produce(120);
        mCus.consume(90);
        mCus.consume(150);
        mPro.produce(110);
    }
}