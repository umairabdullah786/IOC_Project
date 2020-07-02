package ioc;
import java.util.ResourceBundle;

import beans.*;

public class IOC {
	static IOC ioc=null;
	private IOC() {}
	
	public static IOC getContainer() {
		if(ioc==null) {
			ioc=new IOC();
		}
		return ioc;
	}
	
    public void manager(String pkg){
        try{
        	ResourceBundle bundle=ResourceBundle.getBundle(pkg+".default");
        	String cls=bundle.getString("class");
        	String dependent=bundle.getString(cls+".dependent");
            Needy n;
            n=(Needy)Class.forName(pkg+"."+cls).getDeclaredConstructor(MyClass.class).newInstance(new MyClass());
            //    Needy n=new Needy(new MyClass());
            n.caller();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
