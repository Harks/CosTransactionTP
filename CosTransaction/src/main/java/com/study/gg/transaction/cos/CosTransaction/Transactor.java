package com.study.gg.transaction.cos.CosTransaction;

import java.lang.reflect.Proxy;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.study.gg.transaction.Servicescommon.*;

public class Transactor {
	private LockerSeatHandler lockhandler;
	private SideBySideHandler sidehandler;
	private AvailableHandler availhandler;
	private boolean isbeginging = false;
	private int currentfreeseat, transactnbseataffect;
	private int id;
	ArrayList<Class> ressources = new ArrayList<Class>();

	public Transactor(int id) {
		TransactorManager transactorM = TransactorManager.getInstance();
		
		this.id = id;
		
		//TODO => Don't add the ressource if unecessary
		transactorM.addTransaction(this, this.id);
	}

	public void begin() throws MalformedURLException, RemoteException,
			UnknownHostException, NotBoundException {
		isbeginging = true;
	}

	public ServiceInterface addRessource(Class service) {

		if (!ressources.contains(service)) {
			ressources.add(service);
		}

		return (ServiceInterface) Proxy.newProxyInstance(
				service.getClassLoader(), new Class[] { service },
				this.getLockhandler());
	}

	public void commit() {
		if (isbeginging == true) {
			currentfreeseat -= transactnbseataffect;
			isbeginging = false;
		}
	}

	public void rollback() {
		if (isbeginging == true) {
			isbeginging = false;
		}
	}

	public LockerSeatHandler getLockhandler() {
		lockhandler = new LockerSeatHandler();
		return lockhandler;
	}

	public SideBySideHandler getSidehandler() {
		sidehandler = new SideBySideHandler();
		return sidehandler;
	}

	public AvailableHandler getAvailhandler() {
		availhandler = new AvailableHandler();
		return availhandler;
	}
}
