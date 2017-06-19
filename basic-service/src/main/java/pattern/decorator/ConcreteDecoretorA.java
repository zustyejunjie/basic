package pattern.decorator;

/**
 * Created by yejj on 2017/5/26 0026.
 */
public class ConcreteDecoretorA extends Decorator{

    public ConcreteDecoretorA(Person person) {
        super(person);
    }

    @Override
    public void show() {
        System.out.println("ConcreteDecoretorA 执行中");
        super.show();
    }
}
