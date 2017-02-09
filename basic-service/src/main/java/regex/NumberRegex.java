package regex;

/**
 * Created by yejunjie on 2017/2/8.
 */
public class NumberRegex {


    public static void main(String[] args) {


        //去掉数字前面的0
        String month = "001";
        String newStr = month.replaceFirst("^0*", "");
        System.out.println(newStr);
    }
}
