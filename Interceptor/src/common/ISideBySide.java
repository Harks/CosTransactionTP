package common;

import java.rmi.*;
import java.util.ArrayList;

public interface ISideBySide  extends Remote{
	public ArrayList<Seat> lockseats(ArrayList<Seat> seats)throws RemoteException;
}
