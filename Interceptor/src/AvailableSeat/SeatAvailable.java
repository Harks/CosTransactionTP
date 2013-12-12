package AvailableSeat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

import common.*;
public class SeatAvailable extends UnicastRemoteObject implements IAvailableseat {
	public SeatAvailable() throws RemoteException {
		super();
	}

	@Override
	public void showinfo(String msg) throws RemoteException {
		System.out.println(msg+"\r\nCatch by Biblio");
	}

	@Override
	public ArrayList<Seat> getAvailableSeat() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
