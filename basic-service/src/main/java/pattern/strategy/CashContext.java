package pattern.strategy;

/**
 * Created by Administrator on 2017/4/25 0025.
 */
public class CashContext {

    private CashSuper cashSuper;

    public CashContext(String type){
        switch (type){
            case "正常":
                cashSuper = new CashNormal();
                break;
            case "打折":
                cashSuper = new CashRebate(0.8);
                break;
            case "返现":
                cashSuper = new CashReturn(100,10);
                break;
        }
    }

    public double getResult(double result){
        return cashSuper.acceptCash(result);
    }
}
