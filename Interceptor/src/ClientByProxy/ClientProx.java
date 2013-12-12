package ClientByProxy;
import java.lang.reflect.Proxy;
import java.rmi.RemoteException;
import common.*;
import CosTransaction.*;
public class ClientProx {

	public static void main(String[] args) throws RemoteException {
		IAvailableseat aseat = (IAvailableseat) Proxy.newProxyInstance(IAvailableseat.class.getClassLoader(),new Class[] {IAvailableseat.class}, new InterceptorHandler());
		String msg ="Send by ClientProx";
		aseat.showinfo(msg);
		ILockerSeat locks = (ILockerSeat) Proxy.newProxyInstance(ILockerSeat.class.getClassLoader(), new Class[] {ILockerSeat.class},new InterceptorHandler());
		locks.getSideBySideseats(null, 0);
		ISideBySide sides =  (ISideBySide) Proxy.newProxyInstance(ISideBySide.class.getClassLoader(), new Class[] {ISideBySide.class},new InterceptorHandler());
		sides.lockseats(null);
	}

}
