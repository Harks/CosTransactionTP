package com.study.gg.transaction.Client;
import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import com.study.gg.transaction.Servicescommon.*;
import com.study.gg.transaction.cos.CosTransaction.Transactor;

public class ClientProx {

	public static void main(String[] args) throws RemoteException, MalformedURLException, UnknownHostException, NotBoundException {
		ArrayList<Seat> myseats;
		Transactor transac = new Transactor();
		transac.begin();
		IAvailableseat aseat = (IAvailableseat) Proxy.newProxyInstance(IAvailableseat.class.getClassLoader(),new Class[] {IAvailableseat.class}, transac.getAvailhandler());
		myseats = aseat.getAvailableSeat();
		ISideBySide sides =  (ISideBySide) Proxy.newProxyInstance(ISideBySide.class.getClassLoader(), new Class[] {ISideBySide.class},transac.getSidehandler());
		myseats = sides.getSideBySideseats(myseats, 3);
		ILockerSeat locks = (ILockerSeat) Proxy.newProxyInstance(ILockerSeat.class.getClassLoader(), new Class[] {ILockerSeat.class},transac.getLockhandler());
		myseats = locks.lockseats(myseats);
		transac.commit();
	}

}
