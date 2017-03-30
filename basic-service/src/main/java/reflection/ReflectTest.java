package reflection;

/**
 *
 * 1：获取类的属性和方法列表
 * 2：获取方法，执行方法
 * 3：获取构造器，新建对象
 * Created by yejunjie on 2017/2/20.
 */
import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class ReflectTest {
    /**
     * 通过java的反射机制获取类的所有属性和方法
     */
    public void test1() {
        try {
            Class c = Class.forName("reflection.Customer");  //通过类的全路径得到class对象  底层的方法为native方法。

            System.out.println("属性：");
            Field f[] = c.getDeclaredFields(); //查询全部的属性
            for (int i = 0; i < f.length; i++) {

                System.out.println(f[i].getName());
            }
            System.out.println("方法：");
            Method m[] = c.getDeclaredMethods();//查询全部的方法
            for (int i = 0; i < m.length; i++) {
                System.out.println(m[i].toString());
            }

        } catch (Throwable e) {
            System.err.println(e);
        }
    }

    /**
     * 通过java的反射机制动态修改对象的属性
     * @param o
     */
    public void test2(Customer o) {

        try {
            Class c = o.getClass();  //已知类的实例，得到他的class对象


            //getMethod方法第一个参数指定一个需要调用的方法名称，第二个参数是需要调用方法的参数类型列表，如无参数可以指定null，该方法返回一个方法对象　
            Method sAge = c.getMethod("setAge", new Class[] { int.class });  //传入参数类型 区别同名不同参的方法
            Method gAge = c.getMethod("getAge", null);
            Method sName = c.getMethod("setName", new Class[] { String.class });

            //动态修改Customer对象的age
            Object[] args1 = { new Integer(25) };
            sAge.invoke(o, args1);
            //动态取得Customer对象的age
            Integer AGE = (Integer) gAge.invoke(o, null);
            System.out.println("the Customer age is: " + AGE.intValue());
            //动态修改Customer对象的name
            Object[] args2 = { new String("李四") };
            sName.invoke(o, args2);

        } catch (Throwable e) {
            System.err.println(e);
        }
    }
    /**
     * 通过java的反射机制做一个简单对象的克隆
     * @param o
     * @return
     */
    public Object test3(Customer o) {
        Object o2 = null;
        try {
            Class c = Customer.class;

            //通过默认构造方法创建一个新的对象
            o2 = c.getDeclaredConstructor(new Class[] {}).newInstance(
                    new Object[] {});
            //或者使用  得到c的实例  理解：所有类都是Class类的实例对象
//            o2 = c.newInstance();

            //得到class的属性列表
            Field fields[] = c.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                String fieldName = field.getName();
                String firstLetter = fieldName.substring(0, 1).toUpperCase();
                // 获得和属性对应的getXXX()方法的名字
                String getMethodName = "get" + firstLetter + fieldName.substring(1);
                // 获得和属性对应的setXXX()方法的名字
                String setMethodName = "set" + firstLetter + fieldName.substring(1);
                // 获得和属性对应的getXXX()方法
                Method getMethod = c.getMethod(getMethodName, new Class[] {});
                // 获得和属性对应的setXXX()方法
                Method setMethod = c.getMethod(setMethodName, new Class[] { field.getType() });
                // 调用原对象的getXXX()方法
                Object value = getMethod.invoke(o, new Object[] {});
                // 调用拷贝对象的setXXX()方法
                setMethod.invoke(o2, new Object[] { value });
            }
        } catch (Throwable e) {
            System.err.println(e);
        }
        return o2;
    }

    public static void main(String[] args) throws Exception {
        ReflectTest t = new ReflectTest();
        t.test1();

        Customer customer = new Customer();
        customer.setAge(20);
        customer.setName("张三");
        System.out.println("调用前name: " + customer.getName());
        System.out.println("调用前age: " + customer.getAge());
        t.test2(customer);
        System.out.println("调用后name: " + customer.getName());
        System.out.println("调用后age: " + customer.getAge());

        Customer customer2 = (Customer)t.test3(customer);
        System.out.println("克隆对象的name: " + customer2.getName());
        System.out.println("克隆对象的age: " + customer2.getAge());
    }
}

class Customer {
    private long id;
    private String name;
    private int age;

    public Customer() {
    }
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}