package rdevs.entities;

import java.util.List;

import rdevs.models.RoutingModel;

public class OutputPort {
	String name;
	RoutingModel rm;
	List<Event> events;
	
	public OutputPort(String name) {
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
