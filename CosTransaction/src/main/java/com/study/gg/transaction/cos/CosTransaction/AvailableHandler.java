package com.study.gg.transaction.cos.CosTransaction;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.Remote;
import com.study.gg.transaction.Servicescommon.IAvailableseat;



public class AvailableHandler implements InvocationHandler{
	
	IAvailableseat handlerAvailable;
	
	public Object invoke(Object arg0, Method arg1, Object[] arg2)
			throws Throwable {
		System.out.println("Catch by AvailableHandler :"+arg0.getClass().getSimpleName());
		System.out.println("Catch by AvailableHandler :"+arg1.getName());
		Remote r = Naming.lookup("rmi://"+InetAddress.getLocalHost()+"/SeatAvailable");
		return arg1.invoke((IAvailableseat)r, arg2);
	}

}
