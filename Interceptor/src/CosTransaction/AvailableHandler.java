package CosTransaction;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import AvailableSeat.*;
public class AvailableHandler implements InvocationHandler{
	SeatAvailable handlerAvailable;
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2)
			throws Throwable {
		System.out.println("Catch by AvailableHandler :"+arg0.getClass().getSimpleName());
		System.out.println("Catch by AvailableHandler :"+arg1.getName());
		return null;
	}

}
