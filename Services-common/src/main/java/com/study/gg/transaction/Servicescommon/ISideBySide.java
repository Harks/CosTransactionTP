package com.study.gg.transaction.Servicescommon;

import java.rmi.*;
import java.util.ArrayList;

public interface ISideBySide extends Remote, ServiceInterface{
	public ArrayList<Seat> getSideBySideseats(ArrayList<Seat> seats, int nbr)throws RemoteException;
}
