package com.study.gg.transaction.cos.CosTransaction;

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

	private Map<Integer, Transactor> transactions;
	private static TransactorManager instance;

	private TransactorManager() {
		this.transactions = new HashMap<Integer, Transactor>();
	}

	public void addTransaction(Transactor transaction, int id) {
		synchronized (this) {
			if (transactions.containsKey(id)) {
				instance.addTransaction(transaction, id + 1);
			} else {
				transactions.put(id, transaction);
			}
		}
	}

	static TransactorManager getInstance() {
		if (instance == null) {
			instance = new TransactorManager();
		}
		return instance;
	}

	public Map<Integer, Transactor> getTransactions() {
		return transactions;
	}

	public boolean rollBackTransaction(){
		return true;
	}
}
