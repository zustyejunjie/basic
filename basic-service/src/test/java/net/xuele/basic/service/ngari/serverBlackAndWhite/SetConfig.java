package net.xuele.basic.service.ngari.serverBlackAndWhite;

import net.xuele.basic.service.TestSupport;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.SetOperations;
import redis.RedisClient;

import java.util.Set;

/**
 * 把服务黑白名单 设置到redis中
 * Created by Administrator on 2017/5/8 0008.
 */
public class SetConfig extends TestSupport {



    @Autowired
    private RedisClient client;

    @Test
    public void setDate(){

        System.out.println("开始导入");

        SetOperations<String, String>  setOps = client.getRedisTemplate().opsForSet();

        //设置数据
        for(int i=0;i<1000;i++){
            setOps.add("aaa","method"+i);
        }

        //读取数据库 并判断
        long start = System.currentTimeMillis();
        Set<String> members = setOps.members("aaa");
    }

}
