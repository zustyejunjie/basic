package defenceAttack;

import redis.RedisClient;

/**
 * Created by Administrator on 2017/4/29 0029.
 */
public class TT implements Runnable {

    private RedisClient redisClient;

    public TT(RedisClient redisClient){
        this.redisClient = redisClient;
    }

    @Override
    public void run() {
        final String key = "eh.xx";
        /**
         * 默认一秒阀值10次
         */
        int rate = 10;
        long interval = 1000;


        //读取配置
        StatItem statItem = redisClient.get(key);
        /**
         *
         */
        if(statItem == null){
            redisClient.set(key,new StatItem(rate,interval));
            statItem = redisClient.get(key);
        }
        boolean flag = statItem.isAllowable();
        redisClient.set(key,statItem);
        if(flag){
            System.out.print("-----------xxxxxxxxxxxxx----------------------------------xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx------------");
        }else{
            System.out.print("-----------yyyyyyyyyyyyy----------------------------------xxxxxxxxxxxxxxx");
        }
    }
}
