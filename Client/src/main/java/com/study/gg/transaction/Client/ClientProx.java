package com.study.gg.transaction.Client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import com.study.gg.transaction.Servicescommon.*;

public class ClientProx {

	public static void main(String[] args) throws NotBoundException,
			FileNotFoundException, IOException {
		System.out.println("args.length = "+args.length);
		if(args.length == 0) {
			System.out.println("Erreur \r\nVeuillez indiquez l'adresse du CosTransactions");
		} else {
			ArrayList<Seat> myseats;
			ArrayList<Seat> myseats2;
			System.out.println("args[0] "+args[0]);
			ITransactor transac = (ITransactor) Naming.lookup("rmi://"
					+ args[0] + "/Transactor");// new Transactor(1);
			ITransactor transac2 = (ITransactor) Naming.lookup("rmi://"
					+ args[0] + "/Transactor"); // new Transactor(2);
			transac.begin();
			System.out.println("RMI Cos OK");
			IAvailableseat aseat = (IAvailableseat) transac
					.addRessource(IAvailableseat.class,args[0]);
			
			//System.out.println("Aseat => "+aseat);
			
			ISideBySide sides = (ISideBySide) transac
					.addRessource(ISideBySide.class,args[0]);
			ILockerSeat locks = (ILockerSeat) transac
					.addRessource(ILockerSeat.class,args[0]);

			IAvailableseat aseat2 = (IAvailableseat) transac2
					.addRessource(IAvailableseat.class,args[0]);
			ISideBySide sides2 = (ISideBySide) transac2
					.addRessource(ISideBySide.class,args[0]);
			ILockerSeat locks2 = (ILockerSeat) transac2
					.addRessource(ILockerSeat.class,args[0]);

			myseats = aseat.getAvailableSeat();
			System.out.println("After AvailableSeat " + myseats);
			myseats2 = aseat2.getAvailableSeat();
			System.out.println("After AvailableSeat 2 " + myseats);
			myseats2 = sides2.getSideBySideseats(myseats, 2);
			System.out.println("After SideBySideseats " + myseats);
			myseats = sides.getSideBySideseats(myseats, 2);
			System.out.println("After SideBySideseats " + myseats);
			myseats = locks.lockseats(myseats);
			System.out.println("Final " + myseats);
			myseats2 = locks2.lockseats(myseats);
			transac.commit();
			System.out.println("Final " + myseats2);
		}
	}

}
