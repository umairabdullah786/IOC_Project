package startUp;
import java.util.HashMap;

import beans.*;
import ioc.IOC;

public class MainClass {
	public static void main(String[] args) {
		HashMap<String, Object> pool=IOC.getContainer("beans.conf").manager();
		Needy nd=(Needy)pool.get("beans.Needy");
		nd.ms.getX();
		nd.ms.getSum();
		nd.ms.printer();
		
//		Registration reg=(Registration)pool.get("beans.Registration");
//		reg.lg.display();
	}
}
