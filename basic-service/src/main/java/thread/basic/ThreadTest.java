package thread.basic;


/**
 * Created by yejunjie on 2017/2/7.
 */

class Ticket{
     int num = 10;
}

// ThreadTest.java 源码
class MyThread1 extends Thread{
    private Ticket ticket;
    public MyThread1(Ticket ticket){
        this.ticket = ticket;
    }
    public void run(){
        for(int i=0;i<20;i++){
            if(ticket.num>0){
                System.out.println(this.getName()+" 卖票：ticket"+ticket.num--);
            }
        }
    }
};

public class ThreadTest {
    public static void main(String[] args) {
        // 启动3个线程t1,t2,t3；每个线程各卖10张票！
        Ticket ticket = new Ticket();
        MyThread1 t1=new MyThread1(ticket);
        MyThread1 t2=new MyThread1(ticket);
        MyThread1 t3=new MyThread1(ticket);
        t1.start();
        t2.start();
        t3.start();
    }
}