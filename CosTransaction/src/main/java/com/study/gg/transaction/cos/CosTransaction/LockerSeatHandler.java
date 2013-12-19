package com.study.gg.transaction.cos.CosTransaction;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.Remote;

import com.study.gg.transaction.Servicescommon.ILockerSeat;

public class LockerSeatHandler implements InvocationHandler, Serializable{
	public Object invoke(Object arg0, Method arg1, Object[] arg2)
			throws Throwable {
		System.out.println("Catch by LockerSeatHandler :"+arg0.getClass().getSimpleName());
		System.out.println("Catch by LockerSeatHandler :"+arg1.getName());
		Remote r = Naming.lookup("rmi://"+InetAddress.getLocalHost()+"/LockSeat");
		return arg1.invoke((ILockerSeat)r, arg2);
	}

}
