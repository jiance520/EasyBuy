package action;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SesListenter implements HttpSessionAttributeListener{

	public void attributeAdded(HttpSessionBindingEvent arg0) {
		String name = arg0.getName();
		Object uobj = arg0.getValue();
		System.out.println(" add name = "+name);
	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		String name = arg0.getName();
		System.out.println(" remove name = "+name);
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		String name = arg0.getName();
		System.out.println(" replace name = "+name);
	}

}
