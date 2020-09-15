package rdevs.implementation.tracker.entities;

import rdevs.implementation.tracker.models.NetworkModelTracker;

public class ExternalInputPort {
	NetworkModelTracker NModel;//Los External couplings que llegan a este port
	String name;			   // se guardan en el modelo de red. Se puede cambiar de ser necesario.
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ExternalInputPort(NetworkModelTracker m) {
		this.NModel= m;
	}
}
