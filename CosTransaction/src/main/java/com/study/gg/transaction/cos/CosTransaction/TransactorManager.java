package com.study.gg.transaction.cos.CosTransaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TransactorManager {

	private Map<Integer,ArrayList<Transactor>> transactions = new HashMap<Integer,ArrayList<Transactor>>();
	
	private TransactorManager(){
		//TODO Singleton to only have one manager
	}
	
	public void addTransaction(Transactor transaction, int id){
		transactions.get(id).add(transaction);
	}
	
	static TransactorManager getInstance(){
		//TODO singleton
		return null;
	}

	public Map<Integer, ArrayList<Transactor>> getTransactions() {
		return transactions;
	}

}
