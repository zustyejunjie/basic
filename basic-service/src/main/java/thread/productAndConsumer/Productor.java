package thread.productAndConsumer;

/**
 * 生产者
 * Created by yejunjie on 2017/2/11.
 */
public class Productor implements Runnable{


    private Resources resources;

    public Productor(Resources resources){
        this.resources = resources;
    }

    @Override
    public void run() {

        synchronized (resources){
            //打印当前有多少商品
            System.out.println("当前共有商品" + resources.getProductionCount());
            //商品数量加1 每1s生产一个商品
            while (resources.getProductionCount()<resources.maxCount){
                resources.setProductionCount(resources.getProductionCount()+1);
                System.out.println("目前商品" + resources.getProductionCount());
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                }
            }
        }

    }
}
