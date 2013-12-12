package com.study.gg.transaction.service.SideBySideService;
import java.net.*;
import java.net.UnknownHostException;
import java.rmi.*;
import java.rmi.registry.*;

import com.study.gg.transaction.Servicescommon.ISideBySide;
public class server {

	public static void main(String[] args)  throws RemoteException, MalformedURLException, UnknownHostException{

		LocateRegistry.createRegistry(1099);
		ISideBySide sideseat= new SideBySide();
		Naming.rebind("rmi://"+InetAddress.getLocalHost()+"/SideBySide", sideseat);
	}

}
