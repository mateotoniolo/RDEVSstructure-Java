package rdevs.models;

import java.util.List;

import rdevs.entities.Coupling;

public class NetworkModel {

	String name ;
	List<RoutingModel> entities = null;
	List<Coupling> coupling = null ;
	
	public NetworkModel(String name) {
		this.name = name;
	}
	
	public void addRM(RoutingModel rm) {
		if(!entities.isEmpty()) {
			for(RoutingModel roumo : entities) {
				coupling.add(new Coupling(roumo.exit, rm.entrance));
				coupling.add(new Coupling(rm.exit,roumo.entrance));
			}	
		}
		entities.add(rm);
	}
}
