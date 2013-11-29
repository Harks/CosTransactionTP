package ServeurBiblio;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

import Interface.*;
public class Biblio extends UnicastRemoteObject implements IBiblio {
	public Biblio() throws RemoteException {
		super();
	}

	@Override
	public void showinfo(String msg) throws RemoteException {
		System.out.println(msg+"\r\nCatch by Biblio");
	}

}
