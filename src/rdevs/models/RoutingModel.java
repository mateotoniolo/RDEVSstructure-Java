package rdevs.models;

import rdevs.entities.InputPort;
import rdevs.entities.OutputPort;

public class RoutingModel {
	private static int count = 0;
	int id;
	String name;
	EssentialModel EModel;
	InputPort entrance;
	OutputPort exit;
	
	public RoutingModel(String name, EssentialModel em, InputPort ip, OutputPort op) {
		this.name = name;
		EModel = em;
		entrance = ip;
		exit = op;
		id = count++;
		op.setRm(this);
		ip.setRm(this);
	}
}
