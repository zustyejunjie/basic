package net.xuele.basic.service.timer;



import java.util.*;
import java.util.concurrent.TimeUnit;

/**定时器执行类
 * Created by yejunjie on 2016/11/8.
 */
public class MonthAwardTimer {


    private static final String key = "monthAwardTimer";
    /**
     * 发放每月排行版奖励
     */
    public void monthRankAward() {

        System.out.print("定时器开始任务，持续10s,当前时间"+new Date());
        try {
            TimeUnit.SECONDS.sleep(10);
        }catch (Exception e){

        }
        System.out.print("任务结束，,结束时间"+new Date());
    }

}
