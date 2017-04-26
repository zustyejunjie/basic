package pattern.pubsub;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象主题类
 * Created by Administrator on 2017/4/22 0022.
 */
public class AbstractSubject implements Subject{


    private List<Observer> observers = new ArrayList<>();


    @Override
    public void Notify() {
        for(Observer observer : observers){
            observer.update();
        }
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void dettach(Observer observer) {
        observers.remove(observer);
    }
}
