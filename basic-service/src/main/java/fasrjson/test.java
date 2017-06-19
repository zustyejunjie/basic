package fasrjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * Created by yejj on 2017/6/5 0005.
 */
public class test {

    public static void main(String[] args) {

        Map<String ,Object> map = new HashedMap();
        map.put("id",1);
        map.put("fromFlag",1);
        map.put("queueFlag",1);

        Map<String,Object> mm = new HashedMap();
        mm.put("type",1);
        mm.put("t",map);

        String jsr = JSON.toJSONString(mm);
        RTMRequest rtmRequest =
               JSON.parseObject( jsr,new TypeReference<RTMRequest>(){});


        System.out.println();
    }
}
