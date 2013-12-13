package com.study.gg.transaction.service.SeatAvailableService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.study.gg.transaction.Servicescommon.IAvailableseat;
import com.study.gg.transaction.Servicescommon.Seat;

public class SeatAvailable extends UnicastRemoteObject implements IAvailableseat {
	private int nbplaces;
	public SeatAvailable() throws RemoteException {
		super();
		nbplaces = new Random().nextInt(200-150) + 150;
	}

	public void showinfo(String msg) throws RemoteException {
		System.out.println(msg);
		System.out.println("Catch Req SeatAvailable");
	}

	public ArrayList<Seat> getAvailableSeat() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public int getFreeSeat() throws RemoteException {
		return nbplaces;
	}
	
}
