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
		Transactor transac = new Transactor(1);
		transac.begin();
		IAvailableseat aseat = (IAvailableseat)transac.addRessource(IAvailableseat.class);
		ISideBySide sides = (ISideBySide)transac.addRessource(ISideBySide.class);
		ILockerSeat locks = (ILockerSeat)transac.addRessource(ILockerSeat.class);
		myseats = aseat.getAvailableSeat();
		System.out.println("After AvailableSeat "+myseats);
		myseats = sides.getSideBySideseats(myseats, 3);
		System.out.println("After SideBySideseats "+myseats);
		myseats = locks.lockseats(myseats);
		transac.commit();
		System.out.println("Final "+myseats);
	}

}
