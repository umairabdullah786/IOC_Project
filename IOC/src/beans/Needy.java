package beans;
import ioc.IocInterface;
public class Needy implements IocInterface{
	public MyClass ms=null;
	public Abc mn=null;
	public Needy(MyClass m){
		this.ms=m;
		this.ms.getX();
		this.ms.getSum();
		this.ms.printer();
	}
//	public Needy(Abc a) {
//		this.mn.getX();
//	}
}
