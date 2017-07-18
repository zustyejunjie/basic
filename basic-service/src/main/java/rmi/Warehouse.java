package rmi;

/**
 * Created by yejj on 2017/6/19 0019.
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Warehouse extends Remote{
    double getPrice(String description) throws RemoteException;
}