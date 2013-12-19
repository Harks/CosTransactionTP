package com.study.gg.transaction.Servicescommon;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceInterface extends Remote, Serializable{
	public InetAddress getserviceAdresse()throws UnknownHostException, RemoteException;
}
