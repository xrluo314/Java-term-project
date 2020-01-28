package solution;

import java.util.*;

import shipping.IContainer;
import shipping.IShip;

public class Ship implements IShip {
	private String id;
	private List<IContainer> cons;

	
	public Ship(String theid) {
		id=theid;
		cons=new ArrayList<IContainer>();
	}
	@Override
	public String getRegistration() {
		return id;
	}

	@Override
	public void setRegistration(String id) {
		this.id=id;
	}

	@Override
	public void addContainer(IContainer container) {
		Container con=new Container(container.id(),container.description(),container.destinationCity());
		cons.add(con);

	}

	@Override
	public List<IContainer> containers() {
		return cons;
	}

	@Override
	public List<IContainer> offload() {
		List<IContainer> theCons= new ArrayList<IContainer>(cons);
		cons.clear();
		return theCons;
	}

	@Override
	public void printDetails() {
		System.out.println("Before unloading: Ship "+this.getRegistration()
		+" has "+this.offload().size()+" containers.");
		System.out.println("After unloading: Ship "+this.getRegistration()
		+" has "+this.containers().size()+" containers.");

	}

}
