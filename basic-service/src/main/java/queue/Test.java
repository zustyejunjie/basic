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
        DelayedEle element1 = new DelayedEle(15000,"zlx","137");
        DelayedEle element2 = new DelayedEle(15000,"gh","138");

        delayQueue.offer(element1);
        delayQueue.offer(element2);


        new Thread(new Task()).start();
        while (true){
            try {
                DelayedEle  element =  delayQueue.take();
                if(element.getData().equals("0")){
                    Iterator<DelayedEle> iterator =  delayQueue.iterator();
                    while (iterator.hasNext()){
                        DelayedEle delayedEle = iterator.next();
                        if(delayedEle.getUserId().equals(element.getUserId())){
                            System.out.println("发送userId:"+delayedEle.getUserId()+"   time:   "+new Date().toString());
                            delayQueue.remove(delayedEle);
                            break;
                        }
                    }
                }else{
                    System.out.println("error  time out"+new Date().toString());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    static  class Task implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                DelayedEle element1 = new DelayedEle(0,"0","138");
                delayQueue.add(element1);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
