package beans;

public class MyClass {
	public MyClass(){}
	private int x=10;
	private int y=20;
	public void getX() {
		System.out.println("Value of x  :"+x);
		System.out.println("-------------------");
	}
	
	
	
	public void getSum() {
		int result=x+y;
		System.out.println("x+y ="+result);
		System.out.println("-------------------");
	}
	
	
	
	public void printer(){
		System.out.println("I am printer of MyClass from New project");
		System.out.println("-------------------");
	}
	
	public static void pattern() {
		int n=5;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int m=1;m<=n;m++) {
			for(int b=n-1;b>=m;b--) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("-------------------");
	}
}
