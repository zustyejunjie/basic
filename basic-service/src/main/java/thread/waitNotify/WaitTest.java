package thread.waitNotify;

/**
 * Created by yejunjie on 2017/2/9.
 */
// WaitTest.java的源码
class ThreadA extends Thread{

    public ThreadA(String name) {
        super(name);
    }

    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName()+" 调用 notify");
            // 唤醒当前的wait线程
//            notify();
        }
    }
}


public class WaitTest {

    public static void main(String[] args) {

        ThreadA t1 = new ThreadA("线程A");

        synchronized(t1) {  //持有t1的锁，在该锁释放前，其他线程对于t1内的同步方法或者同步代码块将被阻塞
            try {
                // 启动“线程t1”
                System.out.println(Thread.currentThread().getName()+" 开始启动线程A");
                t1.start();

                // 主线程等待t1通过notify()唤醒。
                System.out.println(Thread.currentThread().getName()+" 线程A调用wait方法");
                t1.wait();

                System.out.println(Thread.currentThread().getName()+" continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
