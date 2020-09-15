package rdevs.implementation.tracker.models;

import java.util.LinkedList;
import java.util.List;

import rdevs.implementation.tracker.entities.Coupling;
import rdevs.implementation.tracker.entities.ExternalCoupling;
import rdevs.implementation.tracker.entities.ExternalInputCoupling;
import rdevs.implementation.tracker.entities.ExternalInputPort;
import rdevs.implementation.tracker.entities.ExternalOutputCoupling;
import rdevs.implementation.tracker.entities.ExternalOutputPort;

public class NetworkModelTracker {

	String name;
	List<RoutingModelTracker> entities;
	List<Coupling> InternalCoupling;
	List<ExternalInputCoupling> EIC;
	List<ExternalOutputCoupling> EOC;
	ExternalOutputPort EOP;
	ExternalInputPort EIP;
	List<ExternalCoupling> Externals;//Lista de Todos los ExternalCouplings, tanto input como output
	
	public NetworkModelTracker(String name) {
		this.name = name;
		this.entities = new LinkedList<RoutingModelTracker>();
		this.InternalCoupling = new LinkedList<Coupling>() ;
		this.EIP = new ExternalInputPort(this);
		this.EOP = new ExternalOutputPort(this);
	}
	
	public void addRoutingModelTracker(RoutingModelTracker rm) {
		if(!entities.isEmpty()) {
			for(RoutingModelTracker roumo : entities) {
				//TODO Mateo: Ojo que aca no estas usando el mismo coupling en ambos modelos ni estas usando la lista completa (porque aun no la conoces). Podemos charlarlo.
				InternalCoupling.add(new Coupling(roumo.exit, rm.entrance));
				InternalCoupling.add(new Coupling(rm.exit,roumo.entrance));
			}	
		}
		entities.add(rm);
		rm.addNetworkModelReference(this);
		Externals.add(new ExternalOutputCoupling(rm.getExit(),EOP));//Agrega un ExternalOutputCoupling que va del RM al EOP del NM
		Externals.add(new ExternalInputCoupling(rm.getEntrance(),EIP));//Agrega un ExternalInputCoupling que va del EIP al RM 
	}
	
	public void showData() {
		System.out.println("NETWORK MODEL TRACKER");
		System.out.println("Name: " + this.name);
		List<EssentialModelInstanceTracker> essentials = new LinkedList<EssentialModelInstanceTracker>();
		for(RoutingModelTracker rm: this.entities) {
			System.out.println("-----------------------------------------");
			rm.showData();
			EssentialModelInstanceTracker em = rm.getEssentialModelInstance();
			if (!essentials.contains(em)) essentials.add(em);
		}		
		for(EssentialModelInstanceTracker em: essentials) {
			System.out.println("-----------------------------------------");
			em.showData();
		}
	}
	
}
