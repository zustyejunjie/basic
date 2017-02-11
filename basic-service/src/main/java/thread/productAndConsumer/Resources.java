package thread.productAndConsumer;

/**
 * Created by yejunjie on 2017/2/11.
 */
public class Resources {

    public final int maxCount=100;

    private int productionCount=50;

    public int getProductionCount() {
        return productionCount;
    }

    public void setProductionCount(int productionCount) {
        this.productionCount = productionCount;
    }
}
