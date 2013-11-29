package Client;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import ClientByProxy.BiblioHandler;
import Interface.*;
public class Utilisateur {

	public static void main(String[] args) throws MalformedURLException, RemoteException, UnknownHostException, NotBoundException {
		IBiblio biblio = (IBiblio) Naming.lookup("rmi://"+InetAddress.getLocalHost()+"/Bibliotheque");
		biblio.showinfo("Send from client");
		
	}

}
