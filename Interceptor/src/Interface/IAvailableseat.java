package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAvailableseat extends Remote {
		public void showinfo(String msg)throws RemoteException;
}
