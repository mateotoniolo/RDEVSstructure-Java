package rdevs.entities;

public class Coupling {
	OutputPort origin;
	InputPort  end;
	
	public Coupling(OutputPort op, InputPort ip) {
		this.origin = op;
		this.end = ip;
	}

	public OutputPort getOrigin() {
		return origin;
	}

	public void setOrigin(OutputPort origin) {
		this.origin = origin;
	}

	public InputPort getEnd() {
		return end;
	}

	public void setEnd(InputPort end) {
		this.end = end;
	}
	
}
