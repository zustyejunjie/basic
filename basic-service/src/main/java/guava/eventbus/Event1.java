package guava.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * Created by yejj on 2017/8/2 0002.
 */
public class Event1 {

    @Subscribe
    public void s(String a) throws Exception{
        System.out.println("222222222222222222222222222");
    }
}
