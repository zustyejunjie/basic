package nio;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by yejunjie on 2017/2/26.
 */
public class Test {


    public static void main(String[] args) {

        int a = 1;
        String s ="12";
        Map<String,Object> map = new HashMap<>();

        setIntValue(1);
        setStringValue(s);
        setMapValue(map);

        System.out.println(a);
        System.out.println(s);
        System.out.println(map);
    }


    public static void setStringValue(String s){
        s = "new String";
    }

    public static void setIntValue(int value){
        value = value + 1;
    }

    public static void setMapValue(Map<String,Object> map){

        map.put("s","ss");

    }
}
