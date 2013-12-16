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
		IAvailableseat aseat = (IAvailableseat)transac.addRessource(IAvailableseat.class,0);
		ISideBySide sides = (ISideBySide)transac.addRessource(ISideBySide.class,0);
		ILockerSeat locks = (ILockerSeat)transac.addRessource(ILockerSeat.class,0);
		myseats = aseat.getAvailableSeat();
		myseats = sides.getSideBySideseats(myseats, 3);
		myseats = locks.lockseats(myseats);
		transac.commit();
		System.out.println(myseats);
	}

}
