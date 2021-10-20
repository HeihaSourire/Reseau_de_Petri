package org.pneditor.petrinet.models.fuxin.petrinetwork;

import java.util.HashSet;
import java.util.Set;

import org.pneditor.petrinet.models.fuxin.arc.Arc;
import org.pneditor.petrinet.models.fuxin.arc.ArcVideur;




public class Transition {
	
	private Set<Arc> arcSet;

	

	public Transition() {
		super();
		arcSet = new HashSet();
		
	}

	public boolean isTriggerable(){
		//haveEnoughToken
		for(Arc arc : arcSet){
			if(!arc.haveEnoughToken()){
				return false;
			}
		}
		return true;
		
	}
	
	public void doFire(){
		//should first empty place and tokens to the place, expacially for the most simple case(one place one transition)  
		for(Arc arc : arcSet){
			if((arc instanceof ArcVideur)){
				arc.doChange();	
			}
		}
		
		for(Arc arc : arcSet){
			if(!(arc instanceof ArcVideur)){
				arc.doChange();	
			}
		}
		
	}
	
	public void addArc(Arc arc){
		arcSet.add(arc);
	}

	public void removeArc(Arc arc) {
		arcSet.remove(arc);
	}
	
	public Set<Arc> getArcSet() {
		return arcSet;
	}

	public boolean isArcExist(Arc arc) {
		//to check if the arc already exists
		for(Arc tempArc : this.arcSet) {
			if(tempArc.equals(arc)) {
				return true;
			}
		}
		
		return false;
	}
	
	public int numberOfArcLeft() {
		int numberOfArcLeft = 0;
		for(Arc arc : arcSet) {
			if(arc.isDirection() == Arc.ARCLEFT) {
				numberOfArcLeft++;
			}
		}
		
		return numberOfArcLeft;
		
	}
	
	public int numberOfArcEntered() {
		int numberOfArcEntered = 0;
		for(Arc arc : arcSet){
			if(arc.isDirection() == Arc.ARCENTERED) {
				numberOfArcEntered++;
			}
		}
		
		return numberOfArcEntered; 
	}

	@Override
	public String toString() {
		int numOfArcEntered = numberOfArcEntered();
		int numOfArcLeft = numberOfArcLeft();
		return "transition, " + numOfArcLeft + " arc left, " + numOfArcEntered + " arc entered\n";
	}
	
	

}
