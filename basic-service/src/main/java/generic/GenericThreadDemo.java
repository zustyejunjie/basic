package generic;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * 多个rest请求  一个一个执行太慢  多线程并发执行，需要得到返回的数据  callable 和 future
 *
 * 每个rest请求返回的数据类型都不一样 泛型
 *
 *
 * Created by yejunjie on 2017/3/11.
 */
public class GenericThreadDemo {

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {

    }






}
