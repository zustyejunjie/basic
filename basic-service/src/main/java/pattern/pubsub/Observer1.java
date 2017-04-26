package pattern.pubsub;

/**
 * Created by Administrator on 2017/4/22 0022.
 */
public class Observer1 extends AbstractObserver {


    @Override
    public void update() {
        System.out.println("this is Observer1 update");
    }
}
