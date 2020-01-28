package solution;

import java.util.*;
import shipping.IContainer;
import shipping.IDockyard;
import shipping.ITruck;

public class Dockyard implements IDockyard {
	Map<String, List<IContainer>> consMap = new HashMap<String, List<IContainer>>();
	
	@Override
	public void addContainer(IContainer container) {
		String theKey = container.destinationCity();
		if (consMap.get(theKey) == null) {
			consMap.put(theKey, new ArrayList<IContainer>());
		}
		consMap.get(theKey).add(container);
	}

	@Override
	public boolean loadTruck(ITruck truck) {
		if (!truck.hasContainer()) {
			String theDes = truck.destinationCity();
			if (consMap.get(theDes) == null) {
				return false;
			} else {
				if (consMap.get(theDes).size() == 0) {
					Container nullCon=new Container("empty","empty");
					truck.addContainer(nullCon);
					return true;
				} else {
					truck.addContainer(consMap.get(theDes).remove(0));
					return true;
				}
			}
		} else {
			return false;
		}
	}

	@Override
	public int containerCount() {
		int count=0;
		if(consMap.size()!=0) {
			for (String key : consMap.keySet()) {
				count += consMap.get(key).size();
			}
		}
		return count;
	}

	@Override
	public int containerCount(String destinationCity) {
		if(consMap.get(destinationCity)==null) {
			return 0;
		}else {
			return consMap.get(destinationCity).size();
		}
	}

	@Override
	public void printDetails() {
		if(this.containerCount()==0) {
			System.out.println("The dockyard contains 0 containers.");
		}else {
			System.out.println("The dockyard contains "+this.containerCount()+" containers");
			for (String key : consMap.keySet()) {
				System.out.printf("%15s : %d", key,consMap.get(key).size());
				System.out.println();
			}
		}
	}

}
