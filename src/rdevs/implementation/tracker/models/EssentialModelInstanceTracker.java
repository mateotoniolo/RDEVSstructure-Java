package rdevs.implementation.tracker.models;

public class EssentialModelInstanceTracker {

	String name;
	RoutingModelTracker RModel;
	
	public EssentialModelInstanceTracker(String name) {
		// TODO Mateo: Lo completo para probar la idea, pero luego revisalo.
		this.name = name;
	}
	
	public void addRoutingModelReference(RoutingModelTracker routingModelTracker) {
		// TODO Mateo: Creo que esto debería hacer lo siguiente pero chequealo.
		this.RModel = routingModelTracker;
	}
	
	//TODO Mateo: Agrego este método para poder probar.
	public String getName() {
		return this.name;
	}	
	
	//TODO Mateo: Agrego este método para poder probar.
	public void showData() {
		System.out.println("ESSENTIAL MODEL TRACKER");
		System.out.println("Name: " + this.name);
		System.out.println("Used by: ");
	}
	
}
