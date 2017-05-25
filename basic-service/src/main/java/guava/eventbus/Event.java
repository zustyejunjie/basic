package guava.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * Created by yejj on 2017/5/18 0018.
 */
public class Event {

    @Subscribe
    public void sub(String message) {
        System.out.println(message);
    }

}
