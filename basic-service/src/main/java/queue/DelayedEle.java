package queue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/11/8 0008.
 */
public class DelayedEle implements Delayed {
    private final long delayTime; //延迟时间
    private final long expire;  //到期时间
    private String data;   //数据
    private String userId;

    public DelayedEle(long delay, String data,String userId) {
        delayTime = delay;
        this.data = data;
        expire = System.currentTimeMillis() + delay;
        this.userId = userId;
    }

    /**
     * 剩余时间=到期时间-当前时间
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.expire - System.currentTimeMillis() , TimeUnit.MILLISECONDS);
    }

    /**
     * 优先队列里面优先级规则
     */
    @Override
    public int compareTo(Delayed o) {
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) -o.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DelayedElement{");
        sb.append("delay=").append(delayTime);
        sb.append(", expire=").append(expire);
        sb.append(", data='").append(data).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public long getDelayTime() {
        return delayTime;
    }

    public long getExpire() {
        return expire;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }



    class Task implements Runnable{
        @Override
        public void run() {

        }
    }
}
