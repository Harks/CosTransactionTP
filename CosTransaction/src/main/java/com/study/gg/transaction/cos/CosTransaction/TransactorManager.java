package com.study.gg.transaction.cos.CosTransaction;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.study.gg.transaction.Servicescommon.IAvailableseat;
import com.study.gg.transaction.Servicescommon.ILockerSeat;
import com.study.gg.transaction.Servicescommon.ISideBySide;
import com.study.gg.transaction.Servicescommon.ServiceInterface;

public class TransactorManager {

	private Map<Integer,ArrayList<Transactor>> transactions;
	static private TransactorManager manager;
	static LockerSeatHandler lockhandler;
	static SideBySideHandler sidehandler;
	static AvailableHandler availhandler;
	static IAvailableseat available;
	static ILockerSeat lock;
	static ISideBySide side;
	
	private TransactorManager(){
		this.transactions = new HashMap<Integer,ArrayList<Transactor>>();
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
	
	static ServiceInterface getHandler(Class service){
		System.out.println(service.getSimpleName());
		if (service.getSimpleName().toString().equalsIgnoreCase("IAvailableseat")){
			if(availhandler == null){
				available = (IAvailableseat) Proxy.newProxyInstance(IAvailableseat.class.getClassLoader(),new Class[] {IAvailableseat.class},TransactorManager.getAvailhandler());
			}
			return available;
		}
		else if (service.getSimpleName().toString().equalsIgnoreCase("ILockerSeat")){
			if(lock == null ){
				lock = (ILockerSeat) Proxy.newProxyInstance(ILockerSeat.class.getClassLoader(),new Class[] {ILockerSeat.class},TransactorManager.getLockhandler());
			}
			return lock;
		}
		else if(service.getSimpleName().toString().equalsIgnoreCase("ISideBySide")) {
			if(side == null){
				side = (ISideBySide) Proxy.newProxyInstance(ISideBySide.class.getClassLoader(),new Class[] {ISideBySide.class},TransactorManager.getSidehandler());
			}
			return side;
		}else {
			return null;
		}
	}
	
	static LockerSeatHandler getLockhandler() {
		lockhandler = new LockerSeatHandler();
		return lockhandler;
	}

	static SideBySideHandler getSidehandler() {
		sidehandler = new SideBySideHandler();
		return sidehandler;
	}

	static AvailableHandler getAvailhandler() {
		availhandler = new AvailableHandler();
		return availhandler;
	}

}
