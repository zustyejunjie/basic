package jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Test {

    public static void main(String[] args) {


        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // 最大连接数
        poolConfig.setMaxTotal(2);
        // 最大空闲数
        poolConfig.setMaxIdle(2);
        // 最大允许等待时间，如果超过这个时间还未获取到连接，则会报JedisException异常：
        // Could not get a resource from the pool
        poolConfig.setMaxWaitMillis(1000);
        JedisPool pool = new JedisPool(poolConfig, "192.168.83.128", 6379, 0, "123");
        Jedis jedis = null;
        try {
            for (int i = 0; i < 5; i++) {
                jedis = pool.getResource();
                jedis.set("foo" + i, "bar" + i);
                System.out.println("第" + (i + 1) + "个连接, 得到的值为" + jedis.get("foo" + i));
                // 用完一定要释放连接
                jedis.close();
            }
        } finally {
            pool.close();
        }
    }
}
