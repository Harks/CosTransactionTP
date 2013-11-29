package ClientByProxy;
import java.lang.reflect.Proxy;
import java.rmi.RemoteException;
import CosTransaction.*;
import LockerSeat.*;
import SideBySideSeat.*;
import Interface.*;
public class ClientProx {

	public static void main(String[] args) throws RemoteException {
		IAvailableseat biblio = (IAvailableseat) Proxy.newProxyInstance(IAvailableseat.class.getClassLoader(),new Class[] {IAvailableseat.class}, new AvailableHandler());
		String msg ="Send by ClientProx";
		biblio.showinfo(msg);
	}

}
