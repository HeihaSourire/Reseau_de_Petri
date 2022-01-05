package org.pneditor.petrinet.adapters.fuxin;

import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.models.fuxin.petrinetwork.Transition;

public class TransitionAdapter extends AbstractTransition {
	
	private Transition transition;

	public TransitionAdapter(String label, Transition transition) {
		super(label);
		this.transition = transition;
		// TODO Auto-generated constructor stub
	}

	public Transition getTransition() {
		return transition;
	}

	public void setTransition(Transition transition) {
		this.transition = transition;
	}
	

}
