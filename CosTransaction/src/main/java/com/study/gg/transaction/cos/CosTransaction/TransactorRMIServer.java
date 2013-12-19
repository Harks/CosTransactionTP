package com.study.gg.transaction.cos.CosTransaction;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import com.study.gg.transaction.Servicescommon.ITransactor;

public class TransactorRMIServer {

	public static void main(String[] args)  throws RemoteException,
	MalformedURLException, UnknownHostException{
		try {
			LocateRegistry.createRegistry(1099);
		} catch (Exception ex) {
		}
		ITransactor itransac = new Transactor();
		Naming.rebind("rmi://" + InetAddress.getLocalHost() + "/Transactor",
				itransac);
	}

}
