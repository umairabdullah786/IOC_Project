package startUp;
import ioc.*;
public class MainClass {

	public static void main(String[] args) {
		IOC ioc=IOC.getContainer();
		ioc.manager("beans");
		

	}

}
