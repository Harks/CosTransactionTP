package com.study.gg.transaction.service.LockSeatService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import com.study.gg.transaction.Servicescommon.ILockerSeat;
import com.study.gg.transaction.Servicescommon.Seat;

public class LockSeat extends UnicastRemoteObject implements ILockerSeat{

	public LockSeat() throws RemoteException{
		super();
	}
	
	public ArrayList<Seat> getSideBySideseats(ArrayList<Seat> seats, int nbr)
			throws RemoteException {
		System.out.println("Catch Req SideBySide");
		return null;
	}


}
