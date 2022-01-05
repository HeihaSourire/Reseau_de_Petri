package org.pneditor.petrinet.adapters.fuxin;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.PetriNetInterface;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.UnimplementedCaseException;
import org.pneditor.petrinet.models.fuxin.arc.ArcEnteredNormal;
import org.pneditor.petrinet.models.fuxin.arc.ArcLeft;
import org.pneditor.petrinet.models.fuxin.arc.ArcVideur;
import org.pneditor.petrinet.models.fuxin.arc.ArcZero;
import org.pneditor.petrinet.models.fuxin.exception.DoubleArcException;
import org.pneditor.petrinet.models.fuxin.petrinetwork.PetriNetworkImpl;
import org.pneditor.petrinet.models.fuxin.petrinetwork.Place;
import org.pneditor.petrinet.models.fuxin.petrinetwork.Transition;


public class PetriNetAdapter extends PetriNetInterface {
	
	private int transitionNumber = 0; //the number of transition which will be show in interface
	private int placeNumber = 0; //the nuumber of place which will be shoz in interface
	
	PetriNetworkImpl petriNetworkImpl = new PetriNetworkImpl();

	@Override
	public AbstractPlace addPlace() {
		// TODO Auto-generated method stub
		PlaceAdapter placeAdapter = new PlaceAdapter("Place" + placeNumber, petriNetworkImpl.addPlace(0));
		placeNumber++;
		return placeAdapter;
	}

	@Override
	public AbstractTransition addTransition() {
		// TODO Auto-generated method stub
		TransitionAdapter transitionAdapter = new TransitionAdapter("Transition" + transitionNumber, petriNetworkImpl.addTransition());
		transitionNumber++;
		return transitionAdapter;
		
	}

	@Override
	public AbstractArc addRegularArc(AbstractNode source, AbstractNode destination) throws UnimplementedCaseException {
		// TODO Auto-generated method stub
		
		//if source AbstractNode is a place
		if(source.isPlace()) {
			Place place = ((PlaceAdapter)source).getPlace();
			Transition transition = ((TransitionAdapter)destination).getTransition();
			ArcEnteredNormal arcEnteredNormal = petriNetworkImpl.addArcEnteredNormal(place, transition, 1);
			
			try {
				petriNetworkImpl.connectTransition2ArcEntered(transition, arcEnteredNormal);
			} catch (DoubleArcException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return new ArcAdapter(arcEnteredNormal, source, destination);
		
		}else { //if source AbstractNode is a transition
			Place place = ((PlaceAdapter)destination).getPlace();
			Transition transition = ((TransitionAdapter)source).getTransition();
			ArcLeft arcLeft = petriNetworkImpl.addArcLeft(place, transition, 1);
			
			try {
				petriNetworkImpl.connectTransition2ArcLeft(transition, arcLeft);
			} catch (DoubleArcException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return new ArcAdapter(arcLeft, source, destination);
			
		}
	}

	@Override
	public AbstractArc addInhibitoryArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		// TODO Auto-generated method stub
		Place myPlace = ((PlaceAdapter)place).getPlace();
		Transition myTransition = ((TransitionAdapter)transition).getTransition();
		ArcZero arcZero = petriNetworkImpl.addArcZero(myPlace, myTransition);
		
		try {
			petriNetworkImpl.connectTransition2ArcEntered(myTransition, arcZero);
		} catch (DoubleArcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ArcAdapter(arcZero, place, transition);
	}

	@Override
	public AbstractArc addResetArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		// TODO Auto-generated method stub
		Place myPlace = ((PlaceAdapter)place).getPlace();
		Transition myTransition = ((TransitionAdapter)transition).getTransition();
		ArcVideur arcVideur = petriNetworkImpl.addArcVideur(myPlace, myTransition);
		
		try {
			petriNetworkImpl.connectTransition2ArcEntered(myTransition, arcVideur);
		} catch (DoubleArcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ArcAdapter(arcVideur, place, transition);
	}

	@Override
	public void removePlace(AbstractPlace place) {
		// TODO Auto-generated method stub
		PlaceAdapter placeAdapter = (PlaceAdapter)place;
	    petriNetworkImpl.deletePlace(placeAdapter.getPlace());

	}

	@Override
	public void removeTransition(AbstractTransition transition) {
		// TODO Auto-generated method stub
		TransitionAdapter transitionAdapter = (TransitionAdapter)transition;
		petriNetworkImpl.deleteTransition(transitionAdapter.getTransition());

	}

	@Override
	public void removeArc(AbstractArc arc) {
		// TODO Auto-generated method stub
		ArcAdapter arcAdapter = (ArcAdapter)arc;
		petriNetworkImpl.deleteArc(arcAdapter.getArc());

	}

	@Override
	public boolean isEnabled(AbstractTransition transition) throws ResetArcMultiplicityException {
		// TODO Auto-generated method stub
		Transition myTransition = ((TransitionAdapter)transition).getTransition();
		return petriNetworkImpl.isEnable(myTransition);
	}

	@Override
	public void fire(AbstractTransition transition) throws ResetArcMultiplicityException {
		// TODO Auto-generated method stub
		Transition myTransition = ((TransitionAdapter)transition).getTransition();
		petriNetworkImpl.fire(myTransition);

	}

}
