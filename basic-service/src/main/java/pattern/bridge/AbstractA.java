package pattern.bridge;

/**
 * Created by yejunjie on 2018/1/31 0031.
 */
public abstract class AbstractA {

    private InterfaceA interfaceA ;
    public AbstractA(InterfaceA interfaceA){
        this.interfaceA = interfaceA;
    }

    public void getName(){
        System.out.println(interfaceA.getName());
    }
}
