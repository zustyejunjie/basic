package staticFinal;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/11 0011.
 */
public class FinalTest {

    private static final Map<String,Object> map = new HashMap<>();

    public static void main(String[] args) {

        test();

    }

    public static void test(){

        map.put("id","001");
        map.put("name","name1");

        System.out.print(map);


    }

}
