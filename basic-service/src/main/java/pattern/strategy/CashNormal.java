package pattern.strategy;

/**
 * Created by Administrator on 2017/4/25 0025.
 */
public class CashNormal extends CashSuper{

    @Override
    public double acceptCash(double cash) {
        return cash;
    }
}
