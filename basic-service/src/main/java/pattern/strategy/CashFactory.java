package pattern.strategy;

/**
 * Created by Administrator on 2017/4/25 0025.
 */
public class CashFactory {

    public static CashSuper createCashAccept(String type){
        CashSuper cashSuper = null;
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
        return cashSuper;
    }

}
