package pattern.strategy;

/**
 * Created by Administrator on 2017/4/25 0025.
 */
public class Client {

    public static void main(String[] args) {

        //工厂模式
        CashSuper cashSuper = CashFactory.createCashAccept("打折");
        System.out.print(cashSuper.acceptCash(100));

        //策略模式
        CashContext cashContext = new CashContext("打折");
        System.out.print(cashContext.getResult(100));
    }
}
