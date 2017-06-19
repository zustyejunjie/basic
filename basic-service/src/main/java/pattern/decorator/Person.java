package pattern.decorator;

/**
 * Created by yejj on 2017/5/25 0025.
 */
public class Person {

    public void Person(){}

    private String name;

    public void Person(String name){
        this.name = name;
    }


    public void show(){
        System.out.println("show------------");
    }

}
