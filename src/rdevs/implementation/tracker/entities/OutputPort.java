package rdevs.implementation.tracker.entities;

import java.util.ArrayList;
import java.util.List;

import rdevs.implementation.tracker.models.RoutingModelTracker;

public class OutputPort {
	String name;
	RoutingModelTracker rm;
	List<Event> events = new ArrayList<>();
	List<Coupling> couplings = new ArrayList<>();//Lista de todos los coupling que salen de este puerto
	ExternalOutputCoupling EOC;//Registra el coupling que lo une al ExternalOutputPort 
	
	public List<Event> getEvents() {
		return events;
	}
	
	public void addEvent(Event e) {
		this.events.add(e);
	}
	
	public ExternalOutputCoupling getEOP() {
		return EOC;
	}

	public void setEOC(ExternalOutputCoupling EOC) {
		this.EOC = EOC;
	}

	public OutputPort(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RoutingModelTracker getRm() {
		return rm;
	}

	public void setRm(RoutingModelTracker rm) {
		this.rm = rm;
	}
	public void addCoupling(Coupling c) {
		this.couplings.add(c);
	}
}
