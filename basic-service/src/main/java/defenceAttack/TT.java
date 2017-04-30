package defenceAttack;

import redis.RedisClient;

import javax.validation.constraints.Null;
import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2017/4/29 0029.
 */
public class TT implements Callable<Boolean> {

    private RedisClient redisClient;
    private String key;

    public TT(RedisClient redisClient,String key){
        this.redisClient = redisClient;
        this.key = key;
    }


    @Override
    public Boolean call() throws Exception {


        //先判断开关是否开启
        Object isDefence = redisClient.getRedisTemplate().opsForValue().get("isDefence");
        if(isDefence == null || isDefence.toString().equals("1")){

            System.out.println("dddddddddddddddddddddddddd");
            return true;
        }

        Boolean flag = true;

        try {
            long value = redisClient.getRedisTemplate().opsForValue().increment(key,1);

            if(value == 1){
                redisClient.setex(key,1);
            }

            if(value >10){
                flag = false;
            }else{
                flag = true;
            }

        }catch (Exception e){

        }
        Thread.sleep(100);

        return flag;
    }
}
