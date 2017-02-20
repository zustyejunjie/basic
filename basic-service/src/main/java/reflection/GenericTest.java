package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * 反射获取泛型相关信息
 * Created by yejunjie on 2017/2/20.
 */
public class GenericTest {

    private Map<String, Object> objectMap;

    public void test(Map<String, User> map, String string) {
    }

    public Map<User, Bean> test() {
        return null;
    }


    public static void main(String[] args) {
        try {
//            testFieldType();
//            testParamType();
            testReturnType();
        }catch (Exception e){

        }
    }

    /**
     * 测试属性类型
     *
     * @throws NoSuchFieldException
     */
    public static void testFieldType() throws NoSuchFieldException {
        Field field = Client.class.getDeclaredField("objectMap");
        Type gType = field.getGenericType();
        // 打印type与generic type的区别
        System.out.println(field.getType());
        System.out.println(gType);
        System.out.println("**************");
        if (gType instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) gType;
            Type[] types = pType.getActualTypeArguments();
            for (Type type : types) {
                System.out.println(type.toString());
            }
        }
    }

    /**
     * 测试参数类型
     *
     * @throws NoSuchMethodException
     */
    public static  void testParamType() throws NoSuchMethodException {
        Method testMethod = Client.class.getMethod("test", Map.class, String.class);
        Type[] parameterTypes = testMethod.getGenericParameterTypes();
        for (Type type : parameterTypes) {
            System.out.println("type -> " + type);
            if (type instanceof ParameterizedType) {
                Type[] actualTypes = ((ParameterizedType) type).getActualTypeArguments();
                for (Type actualType : actualTypes) {
                    System.out.println("\tactual type -> " + actualType);
                }
            }
        }
    }

    /**
     * 测试返回值类型
     *
     * @throws NoSuchMethodException
     */
    public static  void testReturnType() throws NoSuchMethodException {
        Method testMethod = Client.class.getDeclaredMethod("test");
        Type returnType = testMethod.getGenericReturnType();
        System.out.println("return type -> " + returnType);

        if (returnType instanceof ParameterizedType) {
            Type[] actualTypes = ((ParameterizedType) returnType).getActualTypeArguments();
            for (Type actualType : actualTypes) {
                System.out.println("\tactual type -> " + actualType);
            }
        }
    }

}
