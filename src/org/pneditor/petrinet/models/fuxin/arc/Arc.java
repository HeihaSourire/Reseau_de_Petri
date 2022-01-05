package org.pneditor.petrinet.models.fuxin.arc;

import java.util.Objects;

import org.pneditor.petrinet.models.fuxin.petrinetwork.Place;
import org.pneditor.petrinet.models.fuxin.petrinetwork.Transition;

public class Arc {
	
	private Place place;
	private Transition transition;
	private int tokenInArc;
	private boolean direction; //the direction is to distinguish the ArcLeft(Transition to Place) and the ArcEntered(Place to Transition)
	public static final boolean ARCLEFT = false; //the direction of the ArcLeft is false
	public static final boolean ARCENTERED = true; //the direction of the ArcEntered is true
	
	
	public Arc(Place place, Transition transition) {
		super();
		this.place = place;
		this.transition = transition;
	}

	public Arc(Place place, Transition transition, int tokenInArc) {
		super();
		this.place = place;
		this.transition = transition;
		this.tokenInArc = tokenInArc;
	}
	
	public boolean haveEnoughToken(){
		
		return false; //by default, we set to false, so the Transition is not triggerable.
	}
	
	public void doChange(){
		
	}

	public Place getPlace() {
		return place;
	}

	public Transition getTransition() {
		return transition;
	}

	public int getTokenInArc() {
		return tokenInArc;
	}
	
	public void changeArcToken(int newTokenInArc) {
		tokenInArc = newTokenInArc;
	}

	public boolean isDirection() {
		return direction;
	}

	public void setDirection(boolean direction) {
		this.direction = direction;
	}

	@Override
	public int hashCode() {
		return Objects.hash(direction, place, transition);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Arc other = (Arc) obj;
		return direction == other.direction && Objects.equals(place, other.place)
				&& Objects.equals(transition, other.transition);
	}

	@Override
	public String toString() {
			return "";
	}
	

	
	
	
}
