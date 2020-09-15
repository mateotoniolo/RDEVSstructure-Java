package rdevs.implementation.tracker.models;

import rdevs.implementation.tracker.entities.InputPort;
import rdevs.implementation.tracker.entities.OutputPort;

public class RoutingModelTracker {
	
	int id;
	String name;
	EssentialModelInstanceTracker EModel;
	InputPort entrance;
	OutputPort exit;
	NetworkModelTracker NModel;
	
	public RoutingModelTracker(String name, int id, EssentialModelInstanceTracker em) {
		this.name = name;
		this.id = id;
		EModel = em;
		this.EModel.addRoutingModelReference(this);
		entrance = new InputPort("InputPort of "+this.getNameAndID());
		exit = new OutputPort("OutputPort of "+this.getNameAndID());
		exit.setRm(this); 
		entrance.setRm(this);
	}

	//TODO Mateo agrego este método fijate luego si te parece útil dejarlo para referenciar trackers.
	public void addNetworkModelReference(NetworkModelTracker networkModelTracker) {
		this.NModel = networkModelTracker;
	}
	
	//TODO Mateo: Agrego este método para poder probar.
	public void showData() {
		System.out.println("ROUTING MODEL TRACKER");
		System.out.println("Name: " + this.name);
		System.out.println("ID: " + this.id);
		System.out.println("Embeds EM: " + this.EModel.getName());
	}

	//TODO Mateo: Agrego este método para poder probar.
	public EssentialModelInstanceTracker getEssentialModelInstance() {
		return this.EModel;
	}

	//TODO Mateo: Agrego este método para poder probar.
	public String getNameAndID() {
		return "(" + this.name + "," + this.id + ")";
	}

	public InputPort getEntrance() {
		return entrance;
	}

	public void setEntrance(InputPort entrance) {
		this.entrance = entrance;
	}

	public OutputPort getExit() {
		return exit;
	}

	public void setExit(OutputPort exit) {
		this.exit = exit;
	}
	
}
