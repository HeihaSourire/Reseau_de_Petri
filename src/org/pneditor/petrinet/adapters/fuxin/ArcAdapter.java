package org.pneditor.petrinet.adapters.fuxin;

import org.hamcrest.core.IsInstanceOf;
import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.models.fuxin.arc.Arc;
import org.pneditor.petrinet.models.fuxin.arc.ArcEnteredNormal;
import org.pneditor.petrinet.models.fuxin.arc.ArcLeft;
import org.pneditor.petrinet.models.fuxin.arc.ArcVideur;
import org.pneditor.petrinet.models.fuxin.arc.ArcZero;

public class ArcAdapter extends AbstractArc {
	
	private Arc arc;
	private AbstractNode source;
	private AbstractNode destination;
	


	public ArcAdapter(Arc arc, AbstractNode source, AbstractNode destination) {
		super();
		this.arc = arc;
		this.source = source;
		this.destination = destination;

	}

	@Override
	public AbstractNode getSource() {
		// TODO Auto-generated method stub
		return this.source;
	}

	@Override
	public AbstractNode getDestination() {
		// TODO Auto-generated method stub
		return this.destination;
	}

	@Override
	public boolean isReset() {
		// TODO Auto-generated method stub
		return arc instanceof ArcVideur;
	}

	@Override
	public boolean isRegular() {
		// TODO Auto-generated method stub
		return arc instanceof ArcEnteredNormal || arc instanceof ArcLeft;
	}

	@Override
	public boolean isInhibitory() {
		// TODO Auto-generated method stub
		return arc instanceof ArcZero;
	}

	@Override
	public int getMultiplicity() throws ResetArcMultiplicityException {
		// TODO Auto-generated method stub
		return arc.getTokenInArc();
	}

	@Override
	public void setMultiplicity(int multiplicity) throws ResetArcMultiplicityException {
		// TODO Auto-generated method stub
		arc.changeArcToken(multiplicity);
	}

	public Arc getArc() {
		return arc;
	}
	
	

}
