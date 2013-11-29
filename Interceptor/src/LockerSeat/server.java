package LockerSeat;
import java.net.*;
import java.net.UnknownHostException;
import java.rmi.*;
import java.rmi.registry.*;
import common.*;
public class server {

	public static void main(String[] args)  throws RemoteException, MalformedURLException, UnknownHostException{
		LocateRegistry.createRegistry(1099);
		ILockerSeat lockerseat= new LockSeat();
		Naming.rebind("rmi://"+InetAddress.getLocalHost()+"/LockSeat", lockerseat);
	}

}
