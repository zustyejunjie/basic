//package pattern.proxy;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//
///**
// * Created by yejunjie on 2017/2/18.
// */
//public class ProxyHandler implements InvocationHandler{
//
//
//    private Object proxied;
//
//    public ProxyHandler( Object proxied )
//    {
//        this.proxied = proxied;
//    }
//
//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        //在转调具体目标对象之前，可以执行一些功能处理
//        System.out.println("代理类要开始调用方法了");
//        //转调具体目标对象的方法
//        method.invoke( proxied, args);
//        System.out.println("代理类执行完了，再做后续的一些处理");
//        return null;
//        //在转调具体目标对象之后，可以执行一些功能处理
//    }
//}
