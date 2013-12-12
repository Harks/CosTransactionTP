package com.study.gg.transaction.service.SideBySideService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import com.study.gg.transaction.Servicescommon.ISideBySide;
import com.study.gg.transaction.Servicescommon.Seat;

public class SideBySide extends UnicastRemoteObject implements ISideBySide{

	protected SideBySide() throws RemoteException {
		super();
	}

	public ArrayList<Seat> lockseats(ArrayList<Seat> seats)
			throws RemoteException {
		System.out.println("Received SideBySide Req");
		return null;
	}
	
}
