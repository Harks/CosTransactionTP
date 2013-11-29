package CosTransaction;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import LockerSeat.*;
public class LockerHandler implements InvocationHandler{

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("Catch by LockerHandler");
		return null;
	}

}
