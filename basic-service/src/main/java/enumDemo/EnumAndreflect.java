package enumDemo;


import java.lang.reflect.Method;

/**
 *
 * 功能：
 * 定义枚举类，表示不同的行为，主线程根据入参行为的不同，执行不同的方法。
 * 在枚举类中定义要执行的方法，通过反射去执行，而不是写switch
 * Created by Administrator on 2017/3/30 0030.
 */
public class EnumAndreflect {


    public static void main(String[] args) {
        //入参
        String param = "insert";

        //得到对应的枚举类
        Actions actions = Enum.valueOf(Actions.class,param);

        //得到方法名
        String method = actions.getMethod();

        try {
            Method  m = EnumAndreflect.class.getMethod(method,new Class[]{String.class});
            m.invoke(new EnumAndreflect(),param);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void m1(String message){
        System.out.println("m1方法执行" + message);
    }

    public void m2(String message){
        System.out.println("m2方法执行"+message);
    }

    public void m3(String message){
        System.out.println("m3方法执行"+message);
    }



}
