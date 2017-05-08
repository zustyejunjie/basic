package defenceAttack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.RedisClient;

import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2017/4/29 0029.
 */
public class AuthService implements Callable<Boolean> {

    private Logger logger = LoggerFactory.getLogger(AuthService.class);
    private RedisClient redisClient;
    private String key;

    //防刷规则   一秒内 最多调用 10次  可在配置文件中配置
    private int interval = 1;
    private int maxCount = 10;
    private Boolean flag = true;


    public AuthService(RedisClient redisClient, String key){
        this.redisClient = redisClient;
        this.key = key;
    }


    @Override
    public Boolean call() throws Exception {
        try {
            //先判断开关是否开启
            Object isDefence = redisClient.getRedisTemplate().opsForValue().get("base.auth.isDefence");
            if(isDefence == null || !isDefence.toString().equals("1")){
                //没有配置 或者 值不为1  则不进行校验
                return true;
            }

            long value = redisClient.getRedisTemplate().opsForValue().increment(key,1);

            if(value == 1){
                redisClient.setex(key,interval);
                return true;
            }
            if(value >maxCount){
                flag = false;
            }else{
                flag = true;
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("method tpsIsAllowable error",e);
        }
        return flag;
    }
}
