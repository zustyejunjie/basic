package javaBasic;

/**
 * Created by yejj on 2017/9/13 0013.
 */
public class ClassDemo {
    public static void main(String[] args) {

        ClassDemo cls = new ClassDemo();
        Class c = cls.getClass();
        System.out.println(c);

        Object obj = new A();
        B b1 = new B();
        b1.show();

        // casts object
        Object a = A.class.cast(b1);

        System.out.println(obj.getClass());
        System.out.println(b1.getClass());
        System.out.println(a.getClass());
    }
}

class A {
    public static void show() {
        System.out.println("Class A show() function");
    }
}

class B extends A {
    public static void show() {
        System.out.println("Class B show() function");
    }
}