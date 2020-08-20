package rdevs.entities;

import rdevs.models.RoutingModel;

public class InputPort {
	String name;
	RoutingModel rm;
	
	public InputPort(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RoutingModel getRm() {
		return rm;
	}
	public void setRm(RoutingModel rm) {
		this.rm = rm;
	}
	
	
}
