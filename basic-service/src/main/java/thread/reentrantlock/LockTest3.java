package thread.reentrantlock;

/**
 * Created by yejunjie on 2017/2/13.
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

/**
 * 在test1的基础上，修复了仓库为空继续消费，仓库满了继续生产的问题
 */

// 仓库
class Depot3 {
    private int capacity;    // 仓库的容量
    private int size;        // 仓库的实际数量
    private Lock lock;       // 独占锁
    private Condition fullCondtion;          // 满容量的条件
    private Condition emptyCondtion;        //  空仓库的条件

    //新进仓库时 设定仓库的最大容量
    public Depot3(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.lock = new ReentrantLock();
        this.fullCondtion = lock.newCondition();
        this.emptyCondtion = lock.newCondition();
    }

    public void produce(int val) {
        //获取锁
        lock.lock();
        try {
            // addCount 表示“想要生产的数量”(有可能生产量太多，需多此生产)  while循环
            int addCount = val;
            while (addCount > 0) {
                // 库存已满时，等待“消费者”消费产品。
                while (size >= capacity)
                    fullCondtion.await();
                // 获取“实际生产的数量”(即库存中新增的数量)
                // 如果“库存”+“想要生产的数量”>“总的容量”，则“实际增量”=“总的容量”-“当前容量”。(此时填满仓库)
                // 否则“实际增量”=“想要生产的数量”
                int inc = (size+addCount)>capacity ? (capacity-size) : addCount;
                size += inc;
                addCount -= inc;
                System.out.printf("%s produce(%3d) --> left=%3d, 增加数量=%3d, size=%3d\n",
                        Thread.currentThread().getName(), val, addCount, inc, size);
                // 通知“消费者”可以消费了。
                emptyCondtion.signal();
            }
        } catch (InterruptedException e) {
        } finally {
            lock.unlock();
        }
    }

    public void consume(int val) {
        lock.lock();
        try {
            // delCount 表示“客户要消费数量”(有可能消费量太大，库存不够，需多此消费)
            int delCount = val;
            while (delCount > 0) {
                // 库存为0时，等待“生产者”生产产品。
                while (size <= 0)
                    emptyCondtion.await();
                // 获取“实际消费的数量”(即库存中实际减少的数量)
                // 如果“库存”<“客户要消费的数量”，则“实际消费量”=“库存”；
                // 否则，“实际消费量”=“客户要消费的数量”。
                int dec = (size<delCount) ? size : delCount;
                size -= dec;
                delCount -= dec;
                System.out.printf("%s consume(%3d) <-- left=%3d, dec=%3d, size=%3d\n",
                        Thread.currentThread().getName(), val, delCount, dec, size);
                fullCondtion.signal();
            }
        } catch (InterruptedException e) {
        } finally {
            lock.unlock();
        }
    }

    public String toString() {
        return "capacity:"+capacity+", actual size:"+size;
    }
};

// 生产者
class Producer3 {
    private Depot3 depot;

    public Producer3(Depot3 depot) {
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
class Customer3 {
    private Depot3 depot;

    public Customer3(Depot3 depot) {
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

public class LockTest3 {
    public static void main(String[] args) {
        Depot3 mDepot = new Depot3(100);
        Producer3 mPro = new Producer3(mDepot);
        Customer3 mCus = new Customer3(mDepot);

        mPro.produce(60);
        mPro.produce(120);
        mCus.consume(90);
        mCus.consume(150);
        mPro.produce(110);
    }
}
