package collection.map;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by yejunjie on 2017/1/18.
 */
public class ConcurrentHashMapTest {

    private static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();


    public static void main(String[] args) {
        new Thread("Thread1"){
            @Override
            public void run() {
                map.put(3, 33);
            }
        }.start();

        new Thread("Thread2"){
            @Override
            public void run() {
                map.put(4, 44);
            }
        }.start();

        new Thread("Thread3"){
            @Override
            public void run() {
                map.put(7, 77);
            }
        }.start();

        try {
            TimeUnit.SECONDS.sleep(10);
        }catch (Exception e){

        }
        System.out.println(map);
    }
}
