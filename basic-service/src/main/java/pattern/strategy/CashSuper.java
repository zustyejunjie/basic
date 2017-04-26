package pattern.strategy;


/**
 * 父类抽象类
 * Created by Administrator on 2017/4/25 0025.
 */
public abstract class CashSuper {

    /**
     *
     * @param cash 未处理钱的总额
     * @return 处理后的总额
     */
    public abstract double acceptCash(double cash);
}
