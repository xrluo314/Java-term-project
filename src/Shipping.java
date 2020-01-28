import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import shipping.*;
import solution.*;

public class Shipping {

	public static void main(String[] args) {
		


		String inputFileName = "ShippingEvents.txt";

		IDockyard dockyard = new Dockyard();  // need to instantiate an object of your class
				
		ShippingProcessor processor = new ShippingProcessor(dockyard);
		
		processor.processEvents("ShippingEvents");	
		
		
		
		
	}

}
