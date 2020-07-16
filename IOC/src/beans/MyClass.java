package beans;

public class MyClass {
	public MyClass(){}
	private int x=10;
	private int y=20;
	public void getX() {
		System.out.println("Value of x  :"+x);
	}
	
	public void getSum() {
		int result=x+y;
		System.out.println("x+y ="+result);
	}
	
	
	public void printer(){
		System.out.println("I am printer of MyClass from New project");
	}
}
