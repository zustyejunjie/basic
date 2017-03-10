package thread.futureAndCallable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by yejunjie on 2017/3/10.
 */
public class SubmitAndFuture {

    /**
     * 批量任务的限时 invokeAll(tasks) 批量提交不限时任务
     * <p>
     * invokeAll(tasks, timeout, unit) 批量提交限时任务
     * <p>
     * InvokeAll方法处理一个任务的容器（collection），并返回一个Future的容器。两个容器具有相同的结构：
     * invokeAll将Future添加到返回的容器中，这样可以使用任务容器的迭代器，从而调用者可以将它表现的Callable与Future 关联起来。
     * 当所有任务都完成时、调用线程被中断时或者超过时限时，限时版本的invokeAll都会返回结果。 超过时限后，任务尚未完成的任务都会被取消。
     *
     * @author hadoop
     */
    // 固定大小的线程池，同时只能接受5个任务
    static ExecutorService mExecutor = Executors.newFixedThreadPool(10);

    /**
     * 计算价格的任务
     *
     * @author hadoop
     */
    private class QuoteTask implements Callable<BigDecimal> {
        public final double price;
        public final int num;

        public QuoteTask(double price, int num) {
            this.price = price;
            this.num = num;
        }

        @Override
        public BigDecimal call() throws Exception {
            Thread.sleep(10);
            BigDecimal d = BigDecimal.valueOf(price * num).setScale(2);
            return d;
        }
    }

    /**
     * 在预定时间内请求获得旅游报价信息
     *
     * @return
     */
    public void getRankedTravelQuotes() throws InterruptedException {

        List<BigDecimal> totalPriceList = new ArrayList<BigDecimal>();


        //方式0 单线程模式
        for (int i = 1; i <= 200; i++) {
            Thread.sleep(10);
            BigDecimal d = BigDecimal.valueOf(200 * i).setScale(2);
        }


//        //方式1 submit
//        List<Future<BigDecimal>> submitFutures = new ArrayList<>();
//        for (int i = 1; i <= 200; i++) {
//            submitFutures.add(mExecutor.submit(new SubmitAndFuture.QuoteTask(200, i)));
//        }
//
//        for (Future<BigDecimal> future : submitFutures) {
//            try {
//                totalPriceList.add(future.get());
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            } catch (CancellationException e) {
//               e.printStackTrace();
//            }
//        }



        //方式2 invokeAll
//        List<SubmitAndFuture.QuoteTask> taskList = new ArrayList<>();
//        for (int i = 1; i <= 200; i++) {
//            taskList.add(new SubmitAndFuture.QuoteTask(200, i));
//        }
//
//        List<Future<BigDecimal>> futureList = mExecutor.invokeAll(taskList);
//        try {
//            for(Future<BigDecimal> future : futureList){
//                totalPriceList.add(future.get());
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }



        for (BigDecimal bigDecimal : totalPriceList) {
//            System.out.println(bigDecimal);
        }
        mExecutor.shutdown();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try {
            SubmitAndFuture it = new SubmitAndFuture();
            it.getRankedTravelQuotes();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("花费时间"+(end-start));
    }
}
