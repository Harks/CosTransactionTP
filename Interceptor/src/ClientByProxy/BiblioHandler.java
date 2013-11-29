package ClientByProxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import ServeurBiblio.*;

public class BiblioHandler implements InvocationHandler{
	Biblio theBiblio;
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2)
			throws Throwable {
		theBiblio = new Biblio();
		String msg = arg2[0]+"\r\nCatch by CustomerHandler";
		theBiblio.showinfo(msg);
		
		return null;
	}

}
