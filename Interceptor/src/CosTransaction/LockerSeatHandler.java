package CosTransaction;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import LockerSeat.*;
public class LockerSeatHandler implements InvocationHandler{
	LockSeat handlerlocker;
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2)
			throws Throwable {
		System.out.println("Catch by LockerSeatHandler :"+arg0.getClass().getSimpleName());
		System.out.println("Catch by LockerSeatHandler :"+arg1.getName());
		return null;
	}

}
