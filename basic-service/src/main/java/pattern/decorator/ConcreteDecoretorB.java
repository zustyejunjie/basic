package pattern.decorator;

/**
 * Created by yejj on 2017/5/26 0026.
 */
public class ConcreteDecoretorB  extends Decorator{

    public ConcreteDecoretorB(Person person) {
        super(person);
    }

    @Override
    public void show() {
        System.out.println("ConcreteDecoretorB 执行中");
        super.show();
    }
}