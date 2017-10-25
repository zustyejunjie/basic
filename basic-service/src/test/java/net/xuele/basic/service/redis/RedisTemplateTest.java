package net.xuele.basic.service.redis;

import com.google.common.collect.Maps;
import net.xuele.basic.service.TestSupport;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.*;

/**
 * 通过spring提供的redisTemplate API 操作各种数据。
 * 作为demo 后面可以参考对照
 * 踩踩坑。
 * 熟悉下这个API，主要是一些不熟悉的方法。
 * Created by Administrator on 2017/10/18 0018.
 */
public class RedisTemplateTest extends TestSupport {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        System.out.println("dddd");
    }

    /**
     * 值为string的增删改查
     */
    @Test
    public void StringTest(){
        //增加
        redisTemplate.opsForValue().set("stringTest","add",1000000);

        //查询
        String getValue  = (String )redisTemplate.opsForValue().get("stringTest");

        //拼装
        redisTemplate.opsForValue().append("stringTest","append");

        //得到老数据  设置新数据
        String value = (String)redisTemplate.opsForValue().getAndSet("stringTest","getSet");

        //一次性设置多个值 获取多个值
        Map map = new HashMap();
        map.put("a","aa");
        map.put("b","bb");
        redisTemplate.opsForValue().multiSet(map);
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        List<String> result = redisTemplate.opsForValue().multiGet(list);

        redisTemplate.opsForValue().increment("stringTest",100);
    }

    /**
     * 值为hash的增删改查   key-value
     *
     * 对 key的操作  设置/删除/查询 整个hash
     *
     * 对hash的操作，  查询hash内 某一个key的值 删除某一个key的值  增加一个key-value对
     */
    @Test
    public void HashTest(){

        //设置
        Map map = Maps.newHashMap();
        map.put("hashKey1","hashValue1");
        map.put("hashKey2","hashValue2");
        map.put("hashKey10","hashValue10");
        redisTemplate.opsForHash().putAll("hashTest", map);

        //查询
        Map result = redisTemplate.opsForHash().entries("hashTest");


        //对hash内部的操作
        Set s = redisTemplate.opsForHash().keys("hashTest");

        //add
        redisTemplate.opsForHash().put("hashTest","hashKey3","hashValue3");
        //query
        redisTemplate.opsForHash().get("hashTest","hashKey3");
        //delete
        redisTemplate.opsForHash().delete("hashTest","hashKey2");

        List l = redisTemplate.opsForHash().values("hashTest");
    }

    /**
     * 值为list的增删改查 {1,2,3}
     */
    @Test
    public void ListTest(){

        //add
//        redisTemplate.opsForList().set("listTest1",);
        //

    }


    /**
     * 值为set的增删改查  没有重复元素的set
     */
    @Test
    public void SetTest(){

        //add
        String  data ="setTest1,setTest2,setTest3,setTest4,setTest5,setTest6";
        redisTemplate.opsForSet().add("setTest",data.split(","));

        //get
        Set set = redisTemplate.opsForSet().members("setTest");
        List set1 = redisTemplate.opsForSet().randomMembers("setTest",2);

        //del
        redisTemplate.opsForSet().remove("setTest","setTest1");
        redisTemplate.opsForSet().pop("setTest");



        redisTemplate.opsForSet().add("setTestB","setTest1","setTest2","setTest3","setTest4","setTest5","setTest6");

        //dif 两个set的不同    intersect 两个set的交集
        //dif 第一次set 减去 后面的set的元素 得到剩下的元素
        redisTemplate.opsForSet().intersect("setTest","setTestB");
        redisTemplate.opsForSet().difference("setTest","setTestB");

        //得到交集 并且保存到另一个set
        redisTemplate.opsForSet().intersectAndStore("setTest","setTestB","setTestC");

    }

}
