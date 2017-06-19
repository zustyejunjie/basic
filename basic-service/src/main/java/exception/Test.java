package exception;

/**
 * Created by yejj on 2017/6/6 0006.
 */
public class Test {

    public static void main(String[] args) {

        Student s = new Student();
        s.setClassName("s");
        s.setId("1");

        Person p = new Person();

        p = s;

        if(p instanceof Student){
            System.out.println("sss");
        }

    }
}
