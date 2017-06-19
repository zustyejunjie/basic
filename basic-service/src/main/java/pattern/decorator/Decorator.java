package pattern.decorator;

/**
 * Created by yejj on 2017/5/25 0025.
 */
public class Decorator extends Person {


    private Person person;

    public Decorator(Person person){
        this.person = person;
    }

    @Override
    public void show() {
        super.show();

    }
}
