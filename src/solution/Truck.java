package solution;

import shipping.IContainer;
import shipping.ITruck;

public class Truck implements ITruck {
	private String regi;
	private String desCity;
	private Container con;
	private boolean hasCon;

	public Truck(String r, String d) {
		regi = r;
		desCity = d;

		hasCon = false;
	}

	@Override
	public String registration() {

		return regi;
	}

	@Override
	public String destinationCity() {
		return desCity;
	}

	@Override
	public boolean addContainer(IContainer container) {
		con = new Container(container.id(), container.description(), container.destinationCity());
		hasCon = true;
		return true;
	}

	@Override
	public IContainer offloadContainer() {
		if (hasCon) {
			Container thisCon = new Container(con.id(), con.destinationCity());
			con = null;
			hasCon = false;
			return thisCon;
		} else {
			Container nullCon = new Container();
			return nullCon;
		}

	}

	@Override
	public boolean hasContainer() {
		return hasCon;
	}

	@Override
	public void printDetails() {
		if (this.con.id() == "empty") {
			System.out.println("Before loading: Truck " + this.registration() + " is headed to "
					+ this.destinationCity() + " with no container.");
			System.out.println("After unloading: Truck " + this.registration() + " is headed to "
					+ this.destinationCity() + " with no container.");
		} else {
			System.out.println("Before loading: Truck " + this.registration() + " is headed to "
					+ this.destinationCity() + " with no container.");
			System.out.println("After unloading: Truck " + this.registration() + " is headed to "
					+ this.destinationCity() + " with container " + this.offloadContainer().id());
		}

	}

}
