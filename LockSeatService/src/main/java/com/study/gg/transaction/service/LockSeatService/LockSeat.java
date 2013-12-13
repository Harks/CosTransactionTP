package com.study.gg.transaction.service.LockSeatService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import com.study.gg.transaction.Servicescommon.*;

public class LockSeat extends UnicastRemoteObject implements ILockerSeat{

	public LockSeat() throws RemoteException{
		super();
	}
	
	public ArrayList<Seat> lockseats(ArrayList<Seat> seats)
			throws RemoteException {
		System.out.println("Catch Req SideBySide");
		for ( Seat s: seats) {
			s.LockerUnLocker();
		}
		return seats;
	}


}
