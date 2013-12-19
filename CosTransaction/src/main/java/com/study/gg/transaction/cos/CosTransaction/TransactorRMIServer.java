package com.study.gg.transaction.cos.CosTransaction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import com.study.gg.transaction.Servicescommon.*;

public class TransactorRMIServer {

	public static void main(String[] args)  throws FileNotFoundException, IOException{
		try {
			LocateRegistry.createRegistry(1099);
		} catch (Exception ex) {
		}
		ITransactor itransac = new Transactor();
		System.out.println("adresse cos = "+InetAddress.getLocalHost().getHostAddress());
		Naming.rebind("rmi://" + InetAddress.getLocalHost().getHostAddress() + "/Transactor",
				itransac);
	}

}
