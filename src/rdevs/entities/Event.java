package rdevs.entities;

import java.util.List;

import rdevs.enums.TypeEvent;
import rdevs.models.RoutingModel;

public class Event {
	TypeEvent type ;
	List<RoutingModel> target;
	OutputPort port;
}
