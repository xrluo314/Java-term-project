package solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


import shipping.IContainer;
import shipping.IDockyard;
import shipping.IShip;
import shipping.ShippingProcessorBase;

public class ShippingProcessor extends ShippingProcessorBase {

	public ShippingProcessor(IDockyard dockyard) {
		super(dockyard);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected List<IContainer> readManifest(String shipId) {
		List<IContainer> theCon=new ArrayList<IContainer>();
		BufferedReader br = null;

		try {
			String root = System.getProperty("user.dir");
			String filePath = root +File.separator +shipId+"-Manifest";
			br = new BufferedReader(new FileReader(filePath));
			String contentLine = br.readLine();
			//System.out.println("Input file processing...");
			while (contentLine != null) {
				StringTokenizer st = new StringTokenizer(contentLine, ",");
				theCon.add(new Container(st.nextToken(),st.nextToken().trim()));
				contentLine = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				System.out.println("Error in closing the BufferedReader");
			}
		}
		return theCon;
	}

	@Override
	protected void processTruck(String registration, String destination) {
		Truck tr=new Truck(registration,destination);
		if(this.getDockyard().loadTruck(tr)) {
			tr.printDetails();
		}
		
		

	}

	@Override
	protected IShip processShip(String registration) {
		List<IContainer> theConts=this.readManifest(registration);
		IShip shi=new Ship(registration);
		for(int i=0;i<theConts.size();i++) {
			shi.addContainer(theConts.get(i));
			this.getDockyard().addContainer(theConts.get(i));
		}
		shi.printDetails();
		return shi;
	}

}
