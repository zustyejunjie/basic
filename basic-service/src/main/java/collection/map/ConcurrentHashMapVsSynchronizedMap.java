package collection.map;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * 测试 hashtable  concurrenthashmap SynchronizedMap性能比较
 *
 * Created by yejunjie on 2017/1/16.
 */
public class ConcurrentHashMapVsSynchronizedMap {

    public final static int THREAD_POOL_SIZE = 5;

    public static Map<String, Integer> hashTableObject = null;
    public static Map<String, Integer> synchronizedMapObject = null;
    public static Map<String, Integer> concurrentHashMapObject = null;

    public static void main(String[] args) throws InterruptedException {

        // Test with Hashtable Object
        hashTableObject = new Hashtable<>();
        performTest(hashTableObject);

        // Test with synchronizedMap Object
        synchronizedMapObject = Collections.synchronizedMap(new HashMap<String, Integer>());
        performTest(synchronizedMapObject);

        // Test with ConcurrentHashMap Object
        concurrentHashMapObject = new ConcurrentHashMap<>();
        performTest(concurrentHashMapObject);

    }

    public static void performTest(final Map<String, Integer> map) throws InterruptedException {

        System.out.println("Test started for: " + map.getClass());
        long averageTime = 0;
        for (int i = 0; i < 5; i++) {

            long startTime = System.nanoTime();
            ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

            for (int j = 0; j < THREAD_POOL_SIZE; j++) {
                executorService.execute(new Runnable() {
                    @SuppressWarnings("unused")
                    @Override
                    public void run() {

                        for (int i = 0; i < 500000; i++) {
                            Integer randomNumber = (int) Math.ceil(Math.random() * 550000);
                            // Put value
                            map.put(String.valueOf(randomNumber), randomNumber);
                        }
                    }
                });
            }

            // Make sure executor stops
            executorService.shutdown();

            // Blocks until all tasks have completed execution after a shutdown request
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

            long entTime = System.nanoTime();
            long totalTime = (entTime - startTime) / 1000000L;
            averageTime += totalTime;
            System.out.println("2500K entried added/retrieved in " + totalTime + " ms");
        }
        System.out.println("For " + map.getClass() + " the average time is " + averageTime / 5 + " ms\n");

    }
}
