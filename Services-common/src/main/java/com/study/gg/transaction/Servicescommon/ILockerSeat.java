package com.study.gg.transaction.Servicescommon;

import java.rmi.*;
import java.util.ArrayList;

public interface ILockerSeat extends Remote, ServiceInterface{
	
	public ArrayList<Seat> lockseats(ArrayList<Seat> seats)throws RemoteException;
}
