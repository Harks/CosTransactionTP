package com.study.gg.transaction.cos.CosTransaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.study.gg.transaction.Servicescommon.IAvailableseat;
import com.study.gg.transaction.Servicescommon.ILockerSeat;
import com.study.gg.transaction.Servicescommon.ISideBySide;
import com.study.gg.transaction.Servicescommon.ServiceInterface;

public class TransactorManager {

	private Map<Integer,ArrayList<Transactor>> transactions = new HashMap<Integer,ArrayList<Transactor>>();
	static Map<Class,GenericHandler> proxyRessources = new HashMap<Class, GenericHandler>();
	static private TransactorManager manager;
	static GenericHandler handler;

	
	private TransactorManager(){
		/*this.transactions = new HashMap<Integer,ArrayList<Transactor>>();
		this.proxyRessources = new HashMap<Class, GenericHandler>();*/
	}
	
	public void addTransaction(Transactor transaction, int id){
		transactions.get(id).add(transaction);
	}
	
	static TransactorManager getInstance(){
		if(manager == null){
			manager = new TransactorManager();
		}
		return manager;
	}

	public Map<Integer, ArrayList<Transactor>> getTransactions() {
		return transactions;
	}
	
	static ServiceInterface getHandler(Class<ServiceInterface> service){

		return (ServiceInterface)(Proxy.newProxyInstance(service.getClassLoader(),new Class[] {service},TransactorManager.callHandler(service)));
		
	}
	
	static InvocationHandler callHandler(Class service){
		
		System.out.println("callHandler Service Name => "+service);
		System.out.println("ProxyRessource => "+proxyRessources.toString());
		
		if(proxyRessources.containsKey(service)){
			return proxyRessources.get(service);
		}else {
			GenericHandler handler;
			//handler = new GenericHandler(service, InetAddress.getByName("192.167.0.1"));
			handler = new GenericHandler(service,null);
			proxyRessources.put(service, handler);
			return handler;
			//return null;
		}
	}

	

}
