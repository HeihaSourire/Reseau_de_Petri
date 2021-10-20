package org.pneditor.petrinet.models.fuxin.exception;

public class DoubleArcException extends Exception {
	
//	@java.io.Serial
//    static final long serialVersionUID = -7033997290745766939L;
	
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "You try to add two same arcs to a transtion";
	}
	
	
}
