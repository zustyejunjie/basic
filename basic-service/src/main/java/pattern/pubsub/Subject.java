package pattern.pubsub;

/**
 * 主题接口 或者叫 通知接口
 * Created by Administrator on 2017/4/22 0022.
 */
public interface Subject {

    public void Notify();
    public void attach(Observer observer);
    public void dettach(Observer observer);

}
