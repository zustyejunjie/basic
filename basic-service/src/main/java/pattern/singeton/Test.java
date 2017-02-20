package pattern.singeton;

/**
 * Created by yejunjie on 2017/2/18.
 */
public class Test {

    public static void main(String[] args) {
        A a = new A();

        a.setA("a");


        String aa = a.getA();

        a = new A();

        System.out.println(aa);

    }
}
