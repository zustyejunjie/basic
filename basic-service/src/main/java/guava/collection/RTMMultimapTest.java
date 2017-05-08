package guava.collection;


import java.util.Collection;
import java.util.Map;

/**
 *
 * 测试rtm中map作为存储介质
 * Created by Administrator on 2017/5/3 0003.
 */
public class RTMMultimapTest {

    public static void main(String[] args) {

        //调用方法 操作map
        MultiMapUtil.doSom();


        //查看map
        Map<String,Collection<NettyRTMClientHolder>> clients = MultiMapUtil.getClients();

        if(clients.containsKey("pipi")){
            System.out.print(1);
        }


    }
}
