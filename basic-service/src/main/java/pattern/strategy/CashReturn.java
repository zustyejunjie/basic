package pattern.strategy;

/**
 * Created by Administrator on 2017/4/25 0025.
 */
public class CashReturn extends CashSuper {

    private double moneyCondition = 0.0d;
    private double moneyReturn = 0.0d;

    public CashReturn(double moneyCondition,double moneyReturn){
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public double acceptCash(double cash) {

        if(cash >= moneyCondition){
            cash = cash - Math.floor(cash/moneyCondition)*moneyReturn;
        }
        return cash;
    }

    public static void main(String[] args) {
        double a = Math.floor(700/300);
        System.out.print(a);
    }
}
