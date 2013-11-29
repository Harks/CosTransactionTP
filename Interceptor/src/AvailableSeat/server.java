package AvailableSeat;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import common.*;
public class server {

	public static void main(String[] args) throws RemoteException, MalformedURLException, UnknownHostException {
		LocateRegistry.createRegistry(1099);
		IAvailableseat biblio= new SeatAvailable();
		Naming.rebind("rmi://"+InetAddress.getLocalHost()+"/Bibliotheque", biblio);

	}

}
