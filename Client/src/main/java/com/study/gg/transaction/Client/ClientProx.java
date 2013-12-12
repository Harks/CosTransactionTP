package com.study.gg.transaction.Client;
import java.lang.reflect.Proxy;
import java.rmi.RemoteException;

import com.study.gg.transaction.Servicescommon.IAvailableseat;
import com.study.gg.transaction.Servicescommon.ILockerSeat;
import com.study.gg.transaction.Servicescommon.ISideBySide;
import com.study.gg.transaction.cos.CosTransaction.Transactor;

public class ClientProx {

	public static void main(String[] args) throws RemoteException {
		Transactor transac = new Transactor();
		transac.begin();
		IAvailableseat aseat = (IAvailableseat) Proxy.newProxyInstance(IAvailableseat.class.getClassLoader(),new Class[] {IAvailableseat.class}, transac.getAvailhandler());
		String msg ="Send by ClientProx";
		aseat.showinfo(msg);
		ILockerSeat locks = (ILockerSeat) Proxy.newProxyInstance(ILockerSeat.class.getClassLoader(), new Class[] {ILockerSeat.class},transac.getLockhandler());
		locks.getSideBySideseats(null, 0);
		ISideBySide sides =  (ISideBySide) Proxy.newProxyInstance(ISideBySide.class.getClassLoader(), new Class[] {ISideBySide.class},transac.getSidehandler());
		sides.lockseats(null);
		transac.commit();
	}

}