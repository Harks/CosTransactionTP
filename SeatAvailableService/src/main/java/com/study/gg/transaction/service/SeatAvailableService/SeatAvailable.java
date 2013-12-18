package com.study.gg.transaction.service.SeatAvailableService;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

import com.study.gg.transaction.Servicescommon.*;

public class SeatAvailable extends UnicastRemoteObject implements IAvailableseat {
	private int nbplaces;
	public SeatAvailable() throws RemoteException {
		super();
		System.out.println("Catch Req SeatAvailable SeatAvailable");
		nbplaces = new Random().nextInt(200-150) + 150;
	}

	public void showinfo(String msg) throws RemoteException {
		System.out.println(msg);
		System.out.println("Catch Req SeatAvailable");
	}

	public ArrayList<Seat> getAvailableSeat() throws RemoteException {
		System.out.println("Catch Req SeatAvailable getAvailableSeat");
		ArrayList<Seat> seats = new ArrayList<Seat>();
		for(int i = 1;i<=15;i++)
			seats.add(new Seat(i));
		return seats;
	}

	public int getnbFreeSeat() throws RemoteException {
		return nbplaces;
	}

	public InetAddress getserviceAdresse() throws UnknownHostException {
		return InetAddress.getByName(InetAddress.getLocalHost().getHostAddress());
	}
	
}
