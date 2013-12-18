package com.study.gg.transaction.cos.CosTransaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TransactorManager {

	private Map<Integer,ArrayList<Transactor>> transactions;
	static private TransactorManager manager;
	
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

}
