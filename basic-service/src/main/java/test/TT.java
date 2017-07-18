package test;


/**
 * Created by yejj on 2017/6/27 0027.
 */
public class TT {


    public TT(){

        System.out.println("'dddddddddddddddddd");
    }


    public static TT getInta(){
        System.out.println("'getInta");
        return new TT();
    }


    static  {
        System.out.println("ddd");

    }
}
