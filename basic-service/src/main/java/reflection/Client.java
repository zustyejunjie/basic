package reflection;


/**
 * Created by yejunjie on 2017/2/16.
 */
public class Client {

    public static  void client() {
        ObjectPool pool = ObjectPool.init("config.json");
        User user = (User) pool.getObject("id1");
        System.out.println(user);

        Bean bean = (Bean) pool.getObject("id2");
        System.out.println(bean);
    }

    public static void main(String[] args) {
        client();
    }
}
