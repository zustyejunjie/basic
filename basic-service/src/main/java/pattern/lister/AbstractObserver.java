package pattern.lister;

/**
 * 观察者抽象类
 * Created by Administrator on 2017/4/22 0022.
 */
public abstract class AbstractObserver implements Observer{

    private String name;//观察者名字
    private Subject subject;
    private String observerState;



    //抽象方法 由具体的实现类来实现 具体的操作。
    public abstract void update();
}
