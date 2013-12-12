package com.study.gg.transaction.service.SeatAvailableService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

import com.study.gg.transaction.Servicescommon.IAvailableseat;
import com.study.gg.transaction.Servicescommon.Seat;

public class SeatAvailable extends UnicastRemoteObject implements IAvailableseat {
	public SeatAvailable() throws RemoteException {
		super();
	}

	public void showinfo(String msg) throws RemoteException {
		System.out.println(msg+"\r\n Catch Req SeatAvailable");
	}

	public ArrayList<Seat> getAvailableSeat() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
