package solution;

import shipping.IContainer;

public class Container implements IContainer {
	private String id;
	private String description;
	private String desCity;
	
	public Container() {
		id=null;
		desCity=null;
	}
	@Override
	public String id() {
		return id;
	}

	@Override
	public String description() {
		return description;
	}

	@Override
	public String destinationCity() {
		return desCity;
	}
	
	public Container (String theId,String theCity) {
		id=theId;
		desCity=theCity;
	}
	public Container (String theId,String theDes,String theCity) {
		id=theId;
		description=theDes;
		desCity=theCity;
	}

}
