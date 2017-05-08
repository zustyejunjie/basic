package net.xuele.basic.service.ngari;

import defenceAttack.AuthService;
import net.xuele.basic.service.TestSupport;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import redis.RedisClient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Administrator on 2017/5/2 0002.
 */
public class DefenceTest extends TestSupport {


    @Autowired
    private  RedisClient client;

    @Test
    public void classList(){

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        String key = "test.yjj1";
        try {
            List<Boolean> results = new ArrayList<>();
            List<Future<Boolean>> futures = new ArrayList<>();
            long start = System.currentTimeMillis();
            //开始任务
            for(int i=0;i<50000;i++){
                futures.add(executorService.submit(new AuthService(client,key)));
            }

            for(Future<Boolean> future : futures){
                results.add(future.get());
            }
            long cost = System.currentTimeMillis()-start;
            System.out.println("任务执行时间："+cost);

            int r = 0;
            int w = 0;
            //统计结果
            for(Boolean b  : results){
                if(b){
                    r++;
                }else{
                    w++;
                }
            }
            System.out.println("通过---------------次数："+r);

            System.out.println("拒绝---------------次数："+w);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }


}
