package com.study.gg.transaction.service.SideBySideService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import com.study.gg.transaction.Servicescommon.*;

public class SideBySide extends UnicastRemoteObject implements ISideBySide {

	protected SideBySide() throws RemoteException {
		super();
	}

	public ArrayList<Seat> getSideBySideseats(ArrayList<Seat> seats, int nbr)
			throws RemoteException {
		/*System.out.println("Catch Req LockSeat");
		return (ArrayList<Seat>) seats.subList(2, nbr);*/
		return null;
	}
}
