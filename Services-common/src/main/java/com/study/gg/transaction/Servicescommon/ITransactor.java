package com.study.gg.transaction.Servicescommon;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.study.gg.transaction.Servicescommon.ServiceInterface;

public interface ITransactor extends Remote, ServiceInterface {

	public void begin() throws MalformedURLException, RemoteException,
			UnknownHostException, NotBoundException;

	public ServiceInterface addRessource(Class service,String address)throws RemoteException;

	public void commit()throws RemoteException;

	public void rollback()throws RemoteException;

}