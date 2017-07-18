package annotationTest;

import org.apache.commons.lang3.StringUtils;
import staticFinal.FinalTest;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by yejj on 2017/7/11 0011.
 */
public class Test {

    final Timer timer = new Timer();
    public void start() {
        timer.schedule(new TimerTask() {
            int a =10;
            public void run() {
                playSound();
                if(StringUtils.isNotEmpty("") || a<=0){
                    timer.cancel();
                }
            }
            private void playSound() {
                a--;
                System.out.println(a);
            }
        },200,200);
    }
    public static void main(String[] args) {
        Test eggTimer = new Test();
        eggTimer.start();
    }
}
