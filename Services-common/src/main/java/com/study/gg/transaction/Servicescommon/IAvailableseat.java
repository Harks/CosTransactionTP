package com.study.gg.transaction.Servicescommon;

import java.rmi.*;
import java.util.ArrayList;

public interface IAvailableseat extends Remote, ServiceInterface {
		public void showinfo(String msg)throws RemoteException;
		public ArrayList<Seat> getAvailableSeat() throws RemoteException;
		public int getnbFreeSeat() throws RemoteException;
}
