/**
 * 
 */
package org.pneditor.petrinet.models.fuxin.arc;

import org.pneditor.petrinet.models.fuxin.petrinetwork.Place;
import org.pneditor.petrinet.models.fuxin.petrinetwork.Transition;

public class ArcLeft extends Arc{

	private static final boolean direction = false;
	
	public ArcLeft(Place place, Transition transition) {
		super(place, transition);
		// TODO Auto-generated constructor stub
		super.setDirection(Arc.ARCLEFT);
	}

	public ArcLeft(Place place, Transition transition, int tokenInArc) {
		super(place, transition, tokenInArc);
		// TODO Auto-generated constructor stub
		super.setDirection(Arc.ARCLEFT);
	} //in generally, the ArcLeft has weight(tokenInArc)

	@Override
	public void doChange() {
		// TODO Auto-generated method stub
		super.getPlace().fireAddToken(super.getTokenInArc());
	}

	@Override
	public boolean haveEnoughToken() {
		// TODO Auto-generated method stub
		return true; //for the ArcLeft, we set the result to true because it doesn't affect whether the transition is triggerable or not
	}

	@Override
	public String toString() {
		return "arcLeft weights " + super.getTokenInArc() + " (transition to place with " + super.getPlace().getToken()+ " tokens)\n";
	}
	
	
	
	
	
	
	

}
