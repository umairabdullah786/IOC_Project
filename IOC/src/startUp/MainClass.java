package startUp;
import ioc.IOC;

public class MainClass {
	public static void main(String[] args) {
		IOC.getContainer("beans.conf").manager();
	}
}
