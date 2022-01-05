package org.pneditor.petrinet.models.fuxin.petrinetwork;

import java.util.HashSet;
import java.util.Set;

import org.pneditor.petrinet.models.fuxin.arc.Arc;
import org.pneditor.petrinet.models.fuxin.arc.ArcEnteredNormal;
import org.pneditor.petrinet.models.fuxin.arc.ArcLeft;
import org.pneditor.petrinet.models.fuxin.arc.ArcVideur;
import org.pneditor.petrinet.models.fuxin.arc.ArcZero;
import org.pneditor.petrinet.models.fuxin.exception.DoubleArcException;


public class PetriNetworkImpl implements PetriNetwork{
	
	private Set<Place> placeSet;
	private Set<Arc> arcSet;
	private Set<Transition> transitionSet;
	
	
	
	public PetriNetworkImpl() {
		super();
		placeSet = new HashSet<>();
		arcSet = new HashSet<>();
		transitionSet = new HashSet<>();
		
	}
	/* (non-Javadoc)
	 * @see PetriNetwork.PetriNetwork#addPlace(int)
	 */
	@Override
	public Place addPlace(int initialToken)  {
		// TODO Auto-generated method stub
		if(initialToken >= 0) {
			Place newPlace = new Place(initialToken);
			placeSet.add(newPlace);
			return newPlace;
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see PetriNetwork.PetriNetwork#deletePlace(PetriNetwork.Place)
	 */
	@Override
	public void deletePlace(Place place) {
		// TODO Auto-generated method stub
		placeSet.remove(place);
		
	}
	/* (non-Javadoc)
	 * @see PetriNetwork.PetriNetwork#changePlaceToken(PetriNetwork.Place, int)
	 */
	
	public int getPlaceSetSize() {
		return placeSet.size();
	}
	
	@Override
	public void addPlaceToken(Place place, int addTokenNumber) {
		// TODO Auto-generated method stub
		if(addTokenNumber >= 0) {
			place.addToken(addTokenNumber);
		}
		
	}
	/* (non-Javadoc)
	 * @see PetriNetwork.PetriNetwork#addArcZero(PetriNetwork.Place, PetriNetwork.Transition)
	 */
	
	@Override
	public void deletePlaceToken(Place place, int deleteTokenNumber) {
		// TODO Auto-generated method stub
		if((deleteTokenNumber >= 0) && (deleteTokenNumber <= place.getToken())) {
			place.addToken(-deleteTokenNumber);
		}

	}

	@Override
	public ArcZero addArcZero(Place place, Transition transition) {
		// TODO Auto-generated method stub
		ArcZero arcZero = new ArcZero(place, transition);
		arcSet.add(arcZero);
		return arcZero;
	}
	
	/* (non-Javadoc)
	 * @see PetriNetwork.PetriNetwork#addArcVideur(PetriNetwork.Place, PetriNetwork.Transition)
	 */
	@Override
	public ArcVideur addArcVideur(Place place, Transition transition) {
		// TODO Auto-generated method stub
		ArcVideur arcVideur = new ArcVideur(place, transition);
		arcSet.add(arcVideur);
		return arcVideur;
	}
	
	/* (non-Javadoc)
	 * @see PetriNetwork.PetriNetwork#addArcEnteredNormal(PetriNetwork.Place, PetriNetwork.Transition, int)
	 */
	@Override
	public ArcEnteredNormal addArcEnteredNormal(Place place, Transition transition, int initialToken) {
		// TODO Auto-generated method stub
		ArcEnteredNormal arcEnteredNormal = new ArcEnteredNormal(place, transition, Math.abs(initialToken));
		arcSet.add(arcEnteredNormal);
		return arcEnteredNormal;

	}
	
	/* (non-Javadoc)
	 * @see PetriNetwork.PetriNetwork#addArcLeft(PetriNetwork.Place, PetriNetwork.Transition)
	 */
	@Override
	public ArcLeft addArcLeft(Place place, Transition transition, int initialToken) {
		// TODO Auto-generated method stub
		ArcLeft arcLeft = new ArcLeft(place, transition, initialToken);
		arcSet.add(arcLeft);
		return arcLeft;	
	}
	
	/* (non-Javadoc)
	 * @see PetriNetwork.PetriNetwork#connectTransition2ArcEntered(Arc.Arc)
	 */
	@Override
	public void connectTransition2ArcEntered(Transition transition, Arc arc) throws DoubleArcException {
		// TODO Auto-generated method stub
		if(transition.isArcExist(arc)) {
			throw new DoubleArcException();
		}
		
		transition.addArc(arc);
	}
	/* (non-Javadoc)
	 * @see PetriNetwork.PetriNetwork#connectTransition2ArcLeft(Arc.Arc)
	 */
	@Override
	public void connectTransition2ArcLeft(Transition transition, Arc arc) throws DoubleArcException {
		// TODO Auto-generated method stub
		if(transition.isArcExist(arc)) {
			throw new DoubleArcException();
		}
		transition.addArc(arc);
	}
	
	/* (non-Javadoc)
	 * @see PetriNetwork.PetriNetwork#deleteArc(Arc.Arc)
	 */
	@Override
	public void deleteArc(Arc arc) {
		// TODO Auto-generated method stub
		arcSet.remove(arc);
		arc.getTransition().removeArc(arc);
	}
	/* (non-Javadoc)
	 * @see PetriNetwork.PetriNetwork#changeArcToken(Arc.Arc, int)
	 */
	@Override
	public void changeArcToken(Arc arc, int newToken) {
		// TODO Auto-generated method stub
		arc.changeArcToken(newToken);
		
	}
	
	public int getArcSetSize() {
		return arcSet.size();
	}
	
	/* (non-Javadoc)
	 * @see PetriNetwork.PetriNetwork#addTransition()
	 */
	@Override
	public Transition addTransition() {
		// TODO Auto-generated method stub
		Transition transition = new Transition();
		transitionSet.add(transition);
		return transition;
	}
	
	/* (non-Javadoc)
	 * @see PetriNetwork.PetriNetwork#deleteTransition(PetriNetwork.Transition)
	 */
	@Override
	public void deleteTransition(Transition transition) {
		// TODO Auto-generated method stub
		if(arcSet != null) {
			arcSet.removeAll(transition.getArcSet());
		}
		transitionSet.remove(transition);
		
		
	}
	
	public int getTransitonSetSize() {
		return transitionSet.size();
	}
	
	@Override
	public boolean isEnable(Transition transition) {
		// TODO Auto-generated method stub
		return transition.isTriggerable();
	}
	
	/* (non-Javadoc)
	 * @see PetriNetwork.PetriNetwork#fire()
	 */
	@Override
	public void fire(Transition transition) {
		// TODO Auto-generated method stub
		transition.doFire();
		
	}
	
	
	@Override
	public String toString() {
		return "PetriNetworkImpl [placeSet=" + placeSet + ", arcSet=" + arcSet + ", transitionSet=" + transitionSet
				+ "]";
	}
	
	@Override
	public String show() {
		// TODO Auto-generated method stub
		StringBuffer sbuffer = new StringBuffer();
		
		
		sbuffer.append("PetriNetwork\n" + 
					   "	" + placeSet.size() + " places\n" + 
					   "	" + transitionSet.size() +" transition\n" + 
					   "	" + arcSet.size() + " arcs\n");
		
		sbuffer.append("List of Places:\n");
		int count = 1;
		for(Place place : placeSet) {
			sbuffer.append("	" + (count++) +" : " + place.toString());
		}
		
		sbuffer.append("List of transitions\n");
		count = 1;
		for(Transition transition : transitionSet) {
			sbuffer.append("	" + (count++) + " : " + transition.toString());
		}
		
		sbuffer.append("List of arcs\n");
		
		count = 1;
		for(Arc arc : arcSet) {
			sbuffer.append("	" + (count++) + " : " + arc.toString());
		}
		
		return sbuffer.toString();
			
	}
	

}
