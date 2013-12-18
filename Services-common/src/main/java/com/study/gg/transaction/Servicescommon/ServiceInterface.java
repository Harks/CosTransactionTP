package com.study.gg.transaction.Servicescommon;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceInterface extends Remote{
	public InetAddress getserviceAdresse()throws UnknownHostException, RemoteException;
}
