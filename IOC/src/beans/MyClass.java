package beans;
import ioc.IocInterface;
public class MyClass implements IocInterface{
	public MyClass(){}
	public void printer(){
		System.out.println("I am printer of MyClass from New project");
	}
}
