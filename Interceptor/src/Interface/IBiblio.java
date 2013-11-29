package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBiblio extends Remote {
		public void showinfo(String msg)throws RemoteException;
}
