package defenceAttack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import redis.RedisClient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by Administrator on 2017/4/29 0029.
 */
public class Test {



    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring.xml");

        RedisClient client = applicationContext.getBean("redis",RedisClient.class);


        ExecutorService executorService = Executors.newFixedThreadPool(5);

        try {
            for(int i=0;i<20;i++){
                executorService.submit(new Utils(client));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }





    }
}
