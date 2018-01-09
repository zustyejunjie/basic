package queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.DelayQueue;

/**
 *
 * 延迟队列的使用
 * Created by Administrator on 2017/11/8 0008.
 */
public class Test {
    private final static DelayQueue<DelayedEle> delayQueue = new DelayQueue<DelayedEle>();

    private final static Logger logger = LoggerFactory.getLogger(Test.class);
    public static void main(String[] args) {

        System.out.println("now is "+new Date().toString());
        DelayedEle element1 = new DelayedEle(5000,"zlx","2222");
        DelayedEle element2 = new DelayedEle(10000,"gh","1111");

        delayQueue.offer(element1);
        delayQueue.offer(element2);


        new Thread(new Task()).start();
        while (true){
            try {
                DelayedEle  element =  delayQueue.take();
                System.out.println(element.getData());
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    static  class Task implements Runnable{
        @Override
        public void run() {
            try {
                DelayedEle element1 = new DelayedEle(0,"0","137");
                delayQueue.add(element1);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
