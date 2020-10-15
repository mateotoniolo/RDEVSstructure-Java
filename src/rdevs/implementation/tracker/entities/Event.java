package rdevs.implementation.tracker.entities;

import java.util.List;

import rdevs.implementation.tracker.enums.TypeEvent;
import rdevs.implementation.tracker.models.RoutingModelTracker;

public class Event {
	TypeEvent type ;
	OutputPort source;
	InputPort target;
	
	public Event(TypeEvent t, OutputPort s, InputPort tg) {
		type = t;
		source =s;
		target = tg;
		s.addEvent(this);
	}
	public TypeEvent getType() {
		return type;
	}
	public void setType(TypeEvent type) {
		this.type = type;
	}
	public OutputPort getSource() {
		return source;
	}
	public void setSource(OutputPort source) {
		this.source = source;
	}
	public InputPort getTarget() {
		return target;
	}
	public void setTarget(InputPort target) {
		this.target = target;
	}
	
	
}
