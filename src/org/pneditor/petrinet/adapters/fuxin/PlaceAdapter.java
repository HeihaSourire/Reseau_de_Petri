package org.pneditor.petrinet.adapters.fuxin;

import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.models.fuxin.petrinetwork.Place;

public class PlaceAdapter extends AbstractPlace {
	
	private Place place;
	

	public PlaceAdapter(String label, Place place) {
		super(label);
		this.place = place;
	}

	@Override
	public void addToken() {
		// TODO Auto-generated method stub
		place.addToken(1);

	}

	@Override
	public void removeToken() {
		// TODO Auto-generated method stub
		place.addToken(-1);

	}

	@Override
	public int getTokens() {
		// TODO Auto-generated method stub
		return place.getToken();
	}

	@Override
	public void setTokens(int tokens) {
		// TODO Auto-generated method stub
		place.setToken(tokens);
		return;

	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
	
	
	
	

}
