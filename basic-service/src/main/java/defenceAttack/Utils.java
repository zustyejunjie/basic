package defenceAttack;


import com.google.common.collect.ImmutableMap;
import redis.RedisClient;

import java.util.Map;

public class Utils implements Runnable{

    private static final String lastResetTimeStr = "lastResetTime"; //上次操作时间
    private static  final String intervalStr = "interval"; //时间间隔
    private static  final String tokenStr = "token"; //剩余调用次数
    private static  final String rateStr = "rate"; //阀值

    String key = "eh.weixin.getName";

    boolean flag = true;


    //默认一秒阀值10次
    int rate = 10;
    long interval = 1000;

    private RedisClient client;
    public Utils(RedisClient client){
        this.client = client;
    }

    @Override
    public void run() {


        //putifabsent  相当于命令  HSETNX

        //多线程同时执行到这里 由于redis是单线程执行的 所以可以保证状态安全
        if (client.getRedisTemplate().opsForHash().putIfAbsent(key, tokenStr, 0)) {

            //没有key  写入其他信息  设置超时时间
            client.getRedisTemplate().opsForHash().putAll(key,
                    (Map) ImmutableMap.of(
                            lastResetTimeStr, System.currentTimeMillis(),
                            rateStr, rate, intervalStr, interval));
            client.getRedisTemplate().opsForHash().increment(key,tokenStr,1);
            client.setex(key,1);
            flag = true;
        } else {

            //已经有调用过  查询配置的信息 判断是否调用次数过多
            Map<String,Object> configMap = client.getRedisTemplate().opsForHash().entries(key);
            long token = client.getRedisTemplate().opsForHash().increment(key,tokenStr,1);
            System.out.println("调用次数"+token);
            Integer max = configMap.get(rateStr)==null?10: Integer.valueOf(configMap.get(rateStr).toString());
            if(token > max){
                flag = false;
            }else{
                flag = true;
            }
        }

        if(flag){
            System.out.print("允许操作");
        }else{
            System.out.print("不允许");
        }
    }
}
