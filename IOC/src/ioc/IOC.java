package ioc;

import java.util.*;

public class IOC{
	static IOC ioc=null;
	static String propertypath;
	private IOC() { }
	
	public static IOC getContainer(String pkg) {
		propertypath=pkg;
		if(ioc==null) {
			ioc=new IOC();
		}
		return ioc;
	}
	public void manager() {
		try{
			ResourceBundle bundle=ResourceBundle.getBundle(propertypath);
			//beans.default
			String subpath=propertypath.substring(0,propertypath.lastIndexOf('.'));
			String cls=bundle.getString("class");
			String dependent=bundle.getString(cls+".dependent");
			Class n=Class.forName(cls);
			Class c=Class.forName(dependent);
			n.getDeclaredConstructor(c).newInstance(c.newInstance());
			//ioc.IocInterface iinterface=ioc.IocInterface.class.cast(n.getDeclaredConstructor(c).newInstance(c.newInstance()));
		}catch(Exception cnf){
			cnf.printStackTrace();
		}
	}
}
