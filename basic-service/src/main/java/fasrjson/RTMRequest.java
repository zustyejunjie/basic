package fasrjson;

/**
 * Created by yejj on 2017/6/4 0004.
 */
public class RTMRequest<T> {
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

}
