package Interface;

import java.rmi.*;
import java.util.ArrayList;

import RessourceMetier.*;

public interface IAvailableseat extends Remote {
		public void showinfo(String msg)throws RemoteException;
		public ArrayList<Seat> getAvailableSeat() throws RemoteException;
}
