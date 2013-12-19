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
	
	private boolean isbeginging = false;
	private int currentfreeseat, transactnbseataffect;
	private int id;
	
	public Transactor(int id) throws FileNotFoundException, UnknownHostException, IOException{
		TransactorManager.getInstance();
		this.id = id; 
	}
	public Transactor()throws FileNotFoundException, UnknownHostException, IOException
	{}
	
	public void begin() throws MalformedURLException, RemoteException,
			UnknownHostException, NotBoundException {
		isbeginging = true;
	}


	public ServiceInterface addRessource(Class service,String address)throws RemoteException {
		return TransactorManager.getHandler(service,address);
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
