package beans;
import ioc.IocInterface;
public class Needy implements IocInterface{
	public MyClass ms=null;
	public Needy(MyClass m){
		this.ms=m;
		this.ms.printer();
	}
	

}
