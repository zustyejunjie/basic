package enumDemo;

/**
 * Created by Administrator on 2017/3/30 0030.
 */
public enum Actions {

    insert("insert","m1"),
    update("insert","m2"),
    delete("insert","m3");

    private String action;
    private String method;
    private Actions(String action,String method){
        this.action = action;
        this.method = method;
    }
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
