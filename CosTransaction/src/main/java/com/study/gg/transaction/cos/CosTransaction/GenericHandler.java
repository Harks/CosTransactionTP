package com.study.gg.transaction.cos.CosTransaction;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.Remote;

import com.study.gg.transaction.Servicescommon.IAvailableseat;
import com.study.gg.transaction.Servicescommon.ServiceInterface;

public class GenericHandler implements InvocationHandler,Serializable{

	private Class serviceInt;
	private String address;
	public GenericHandler(Class serviceI, String address){
		this.serviceInt = serviceI;
		this.address = address;
	}
	
	public Object invoke(Object arg0, Method arg1, Object[] arg2)
			throws Throwable {
		
		System.out.println("Client Call, service =  "+serviceInt.getName());
		System.out.println("Address => "+this.address);
		Remote r = Naming.lookup("rmi://"+address+"/"+serviceInt.getSimpleName());
		return arg1.invoke((serviceInt.cast(r)), arg2);
	}
	
}
