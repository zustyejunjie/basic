package thread.productAndConsumer;

/**
 * Created by yejunjie on 2017/2/11.
 */
public class Consumer implements Runnable {


    private Resources resources;

    public Consumer(Resources resources){
        this.resources = resources;
    }
    @Override
    public void run() {

        synchronized (resources){
            //打印当前有多少商品
            System.out.println("当前共有商品：" + resources.getProductionCount());
            while (resources.getProductionCount()<resources.maxCount){
                //商品数量减1 每2s消费一个商品
                resources.setProductionCount(resources.getProductionCount()-1);
                try {
                    Thread.sleep(2000);
                }catch (Exception e){
                }
            }
        }

    }
}
