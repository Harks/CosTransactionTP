package com.study.gg.transaction.cos.CosTransaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * This class store every transaction wich is made. And should also store
 * the data concerne by the current transaction, the data stored is the value
 * before the transaction in order to be able to rollback the transaction.
 * @author loicregnault
 *
 */
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
