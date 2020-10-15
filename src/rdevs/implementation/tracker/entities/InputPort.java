package rdevs.implementation.tracker.entities;

import java.util.ArrayList;
import java.util.List;

import rdevs.implementation.tracker.models.RoutingModelTracker;

public class InputPort {
	String name;
	RoutingModelTracker rm;
	List<Coupling> couplings = new ArrayList<>();//Lista de todos los coupling que entran a este puerto
	ExternalInputCoupling EIC;//Registra el coupling que lo une al ExternalInputPort 
	
	public void setEIC(ExternalInputCoupling eIC) {
		EIC = eIC;
	}

	public InputPort(String name) {
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

	public ExternalInputCoupling getEIC() {
		return EIC;
	}
	
}
