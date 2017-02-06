package thread.volatilet;

import java.util.concurrent.TimeUnit;

/** flag 增加volatile关键字 或者把 打印语句注释打开 才能正常运行。  原因是：在jit中对字节码做了深度优化
 * Created by yejunjie on 2017/1/21.
 */
public class Main extends Thread {

    private static  Boolean flag = false;

    private int count;

    public void run(){
        if(!flag){
//            System.out.println("looping");
        }
    }

    public static void main(String[] args) {

        Main main = new Main();
        main.start();

        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){

        }

        try {
            main.join();
        }catch (Exception e){

        }

        System.out.println("done");
    }
}
