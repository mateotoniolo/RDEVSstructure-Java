package rdevs.implementation.tracker.models;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import rdevs.implementation.tracker.entities.Event;
import rdevs.implementation.tracker.entities.InputPort;
import rdevs.implementation.tracker.entities.OutputPort;
import rdevs.implementation.tracker.enums.TypeEvent;

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


	public void addNetworkModelReference(NetworkModelTracker networkModelTracker) {
		this.NModel = networkModelTracker;
	}
	

	public void showData() {
		System.out.println("ROUTING MODEL TRACKER");
		System.out.println("Name: " + this.name);
		System.out.println("ID: " + this.id);
		System.out.println("Embeds EM: " + this.EModel.getName());
		this.showOutputEvents();
	}

	/*
	 * Este método debería mostrar renglón a renglón los eventos que han salido desde este
	 * routing tracker, con toda su información.
	 */
	private void showOutputEvents() {
		System.out.println("OutPutEvents---------------------");
		for(Event event : this.exit.getEvents()) {
			System.out.println("Event Type: "+ event.getType()+" | From: "+ this.getNameAndID() +" --------> To: "+ event.getTarget().getRm().getNameAndID());
		}
	}
	
	public EssentialModelInstanceTracker getEssentialModelInstance() {
		return this.EModel;
	}


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
	
	/*
	 * Este método debería tomar los datos como argumento y generar el evento que se manda desde
	 * este modelo hacia todos los demas (con todo lo que implica).
	 */
	public void sendingOutputEvent(int sourceID, String eventType, int[] destinationsID) {
		Optional<RoutingModelTracker> source = this.NModel.getEntities().stream().filter(e -> (e.getId() == sourceID)).findFirst();
		Optional<RoutingModelTracker> destination;
		for(int d : destinationsID) {
			destination = this.NModel.getEntities().stream().filter(e -> (e.getId() == d)).findFirst();
			new Event(TypeEvent.valueOf(eventType), source.get().getExit(), destination.get().getEntrance());
		}
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
}
