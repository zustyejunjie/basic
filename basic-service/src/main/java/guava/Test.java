package guava;

/**
 * Created by yejj on 2017/6/11 0011.
 */
public class Test {


    public static void main(String[] args) {

        Student student =new Student();  //正常
//        Student student = null;  //空指针

        get(student);

        System.out.println(student.getId());
    }

    private static  boolean get(Student student){

        student.setId(11);

        return true;
    }
}
