package pattern.bridge;

/**
 * Created by yejunjie on 2018/1/31 0031.
 */
public class Client {

    public static void main(String[] args) {

        InterfaceA interfaceA = new ImplB();
        AbstractA abstractA = new ExtendB(interfaceA);
        abstractA.getName();


        interfaceA = new ImplC();
        abstractA = new AbstractC(interfaceA);
        abstractA.getName();


    }
}
