//package pattern.proxy;
//
//import sun.misc.ProxyGenerator;
//
//import java.io.FileOutputStream;
//import java.lang.reflect.Proxy;
//
///**
// * Created by yejunjie on 2017/2/18.
// */
//public class DynamicProxy {
//
//    public static void main( String args[] ){
//        RealSubject real = new RealSubject();
//        Subject proxySubject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),
//                new Class[]{Subject.class},
//                new ProxyHandler(real));
//
//        proxySubject.doSomething();
//        proxySubject.put();
//        //write proxySubject class binary data to file
//        createProxyClassFile();
//    }
//
//    public static void createProxyClassFile()
//    {
//        String name = "ProxySubject";
//        byte[] data = ProxyGenerator.generateProxyClass(name, new Class[]{Subject.class});
//        try
//        {
//            FileOutputStream out = new FileOutputStream( name + ".class" );
//            out.write( data );
//            out.close();
//        }
//        catch( Exception e )
//        {
//            e.printStackTrace();
//        }
//    }
//}
