package com.study.gg.transaction.cos.CosTransaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.*;
import java.net.UnknownHostException;
import java.rmi.*;
import java.util.*;

import com.study.gg.transaction.Servicescommon.*;

public class Transactor {
	private LockerSeatHandler lockhandler;
	private SideBySideHandler sidehandler;
	private AvailableHandler availhandler;
	private boolean isbeginging = false;
	private int currentfreeseat, transactnbseataffect;
	private int id;
	ArrayList<Class> ressources = new ArrayList<Class>();
	private TransactorManager transactorM;
	public Transactor(int id) {
		transactorM = TransactorManager.getInstance();

		this.id = id;

		// TODO => Don't add the ressource if unecessary
		 
	}

	public void begin() throws MalformedURLException, RemoteException,
			UnknownHostException, NotBoundException {
		isbeginging = true;
	}

	public ServiceInterface addRessource(Class service) {

		if (!ressources.contains(service)) {
			ressources.add(service);
		}
		transactorM.addTransaction(this, this.id);
		return getRightHandler(service);
	}

	private ServiceInterface getRightHandler(Class service) {
		System.out.println(service.getSimpleName());
		if (service.getSimpleName().toString().equalsIgnoreCase("IAvailableseat"))
			return (IAvailableseat) Proxy.newProxyInstance(IAvailableseat.class.getClassLoader(),new Class[] {IAvailableseat.class},this.getAvailhandler());
		else if (service.getSimpleName().toString().equalsIgnoreCase("ILockerSeat"))
			return (ILockerSeat) Proxy.newProxyInstance(ILockerSeat.class.getClassLoader(),new Class[] {ILockerSeat.class},this.getLockhandler());
		else
			return (ISideBySide) Proxy.newProxyInstance(ISideBySide.class.getClassLoader(),new Class[] {ISideBySide.class},this.getSidehandler());
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
