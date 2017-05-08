package guava.collection;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/3 0003.
 */
public class MultiMapUtil {


    private final static Multimap<String,NettyRTMClientHolder> clients =  HashMultimap.create();

    public static Map<String,Collection<NettyRTMClientHolder>> getClients(){
        return clients.asMap();
    }


    public static void doSom(){



        RTMEndPoint pipi = new RTMEndPoint();
        pipi.setUserId("pipi");


        NettyRTMClientHolder ppholder = new NettyRTMClientHolder(pipi , 1);

        synchronized(clients){
            clients.put(pipi.getUserId(), ppholder);
        }


        RTMEndPoint ff = new RTMEndPoint();
        ff.setUserId("ff");


        NettyRTMClientHolder ffholder = new NettyRTMClientHolder(ff , 2);

        synchronized(clients){
            clients.put(ff.getUserId(), ffholder);
        }

        NettyRTMClientHolder other = new NettyRTMClientHolder(ff , 3);
        synchronized(clients){
            clients.put(ff.getUserId(), other);
        }


        if(clients.containsKey("ff")){
            clients.get("ff").remove(ffholder);
        }
    }

}
