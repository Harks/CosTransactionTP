package com.study.gg.transaction.cos.CosTransaction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.*;
import java.net.UnknownHostException;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

import com.study.gg.transaction.Servicescommon.*;

public class Transactor extends UnicastRemoteObject implements ITransactor {
	/*private LockerSeatHandler lockhandler;
	private SideBySideHandler sidehandler;
	private AvailableHandler availhandler;
	*/
	private boolean isbeginging = false;
	private int currentfreeseat, transactnbseataffect;
	private int id;
	private ArrayList<Class> ressources = new ArrayList<Class>();
	private TransactorManager transactorM;
	public Transactor(int id) throws FileNotFoundException, UnknownHostException, IOException{
		transactorM = TransactorManager.getInstance();
		//PropertiesNetwork.setTransacAddresse(this.getserviceAdresse().toString());
		this.id = id;

		// TODO => Don't add the ressource if unecessary	 
	}
	public Transactor()throws FileNotFoundException, UnknownHostException, IOException
	{
		//PropertiesNetwork.setTransacAddresse(this.getserviceAdresse().toString());
	}
	public void begin() throws MalformedURLException, RemoteException,
			UnknownHostException, NotBoundException {
		isbeginging = true;
	}


	public ServiceInterface addRessource(Class service)throws RemoteException {

		/*if (!ressources.contains(service)) {
			ressources.add(service);
		}*/
		System.out.println("service.getCanonicalName() "+service.getCanonicalName());
		System.out.println("service "+service);
		return TransactorManager.getHandler(service);
	}


	public void commit() throws RemoteException{
		if (isbeginging == true) {
			currentfreeseat -= transactnbseataffect;
			isbeginging = false;
		}
	}

	public void rollback() throws RemoteException{
		if (isbeginging == true) {
			isbeginging = false;
		}
	}
	public InetAddress getserviceAdresse() throws UnknownHostException,
			RemoteException {
		return InetAddress.getByName(InetAddress.getLocalHost().getHostAddress());
	}


}
