package pattern.strategy;

/**
 * Created by Administrator on 2017/4/25 0025.
 */
public class CashRebate extends CashSuper {

    private double rebate;
    public CashRebate(double rebate){
        this.rebate = rebate;
    }

    @Override
    public double acceptCash(double cash) {
        return cash * rebate;
    }
}
