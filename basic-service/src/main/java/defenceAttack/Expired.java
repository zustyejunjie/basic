package defenceAttack;

import com.sun.corba.se.impl.orbutil.LogKeywords;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.RedisClient;

import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Administrator on 2017/4/29 0029.
 */
public class Expired {


    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring.xml");
        RedisClient client = applicationContext.getBean("redis",RedisClient.class);

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        client.set("base.auth.isDefence",1);

        String key = "test.yjj1";
        try {

            /**
             * 使用有返回值得callable 和 future
             */
            List<Boolean> results = new ArrayList<>();
            List<Future<Boolean>> futures = new ArrayList<>();
            long start = System.currentTimeMillis();
            //开始任务
            for(int i=0;i<1;i++){
                futures.add(executorService.submit(new TT(client,key)));
            }

            //等待所有结果
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
