package com.study.gg.transaction.Servicescommon;

import java.rmi.*;
import java.util.ArrayList;

public interface IAvailableseat extends Remote {
		public void showinfo(String msg)throws RemoteException;
		public ArrayList<Seat> getAvailableSeat() throws RemoteException;
}
