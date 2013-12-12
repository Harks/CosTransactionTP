package CosTransaction;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import AvailableSeat.*;
import LockerSeat.*;
import SideBySideSeat.*;
public class InterceptorHandler implements InvocationHandler{
	Object handlerobject;
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2)
			throws Throwable {
		System.out.println("Catch by AvailableHandler\r\n");
		/*if(arg0.getClass().getName())
		{
			
		}else if(arg0.getClass().getName())
		{
			
		}
		else if(arg0.getClass().getName())
		{
			
		}*/
		return null;
	}

}
