package defenceAttack;

import com.sun.corba.se.impl.orbutil.LogKeywords;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.RedisClient;

/**
 * Created by Administrator on 2017/4/29 0029.
 */
public class Expired {


    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring.xml");

        RedisClient client = applicationContext.getBean("redis",RedisClient.class);

        String  key ="ngari.yjj";


        if(client.exists(key)){
            int count = client.get(key);
        }else{
            client.set(key,10);
        }




    }




}
