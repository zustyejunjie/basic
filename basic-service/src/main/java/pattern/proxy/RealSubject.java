package pattern.proxy;

/**
 * Created by yejunjie on 2017/2/18.
 */
public class RealSubject implements Subject{

    @Override
    public void doSomething()
    {
        System.out.println( "call doSomething()" );
    }

    @Override
    public void put() {
        System.out.println( "call put()" );
    }
}
