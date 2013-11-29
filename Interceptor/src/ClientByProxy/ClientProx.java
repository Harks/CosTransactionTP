package ClientByProxy;
import java.lang.reflect.Proxy;
import java.rmi.RemoteException;

import Interface.*;
public class ClientProx {

	public static void main(String[] args) throws RemoteException {
		IBiblio biblio = (IBiblio) Proxy.newProxyInstance(IBiblio.class.getClassLoader(),new Class[] {IBiblio.class}, new BiblioHandler());
		String msg ="Send by ClientProx";
		biblio.showinfo(msg);
	}

}
