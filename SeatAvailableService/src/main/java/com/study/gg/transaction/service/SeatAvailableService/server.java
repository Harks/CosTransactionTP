package com.study.gg.transaction.service.SeatAvailableService;
import java.net.*;
import java.net.UnknownHostException;
import java.rmi.*;
import java.rmi.registry.*;

import com.study.gg.transaction.Servicescommon.IAvailableseat;
public class server {

	public static void main(String[] args) throws RemoteException, MalformedURLException, UnknownHostException {

		//LocateRegistry.createRegistry(1099);
		IAvailableseat availseat= new SeatAvailable();
		Naming.rebind("rmi://"+InetAddress.getLocalHost()+"/SeatAvailable", availseat);
	}

}