package org.pneditor.petrinet.models.fuxin.petrinetwork;

import org.pneditor.petrinet.models.fuxin.arc.Arc;
import org.pneditor.petrinet.models.fuxin.arc.ArcEnteredNormal;
import org.pneditor.petrinet.models.fuxin.arc.ArcLeft;
import org.pneditor.petrinet.models.fuxin.arc.ArcVideur;
import org.pneditor.petrinet.models.fuxin.arc.ArcZero;
import org.pneditor.petrinet.models.fuxin.exception.DoubleArcException;

public interface PetriNetwork {
	
	/**
	 * This function enables the user to add a Place to PetriNetwork  
	 * @author FU Wenjie XIN Yuhua
	 * @param initialToken
	 * @return Place added to PetriNetWork  
	 */
	public Place addPlace(int initialToken);
	
	/**
	 * Delete a Place from PetriNetwork  
	 * @author FU Wenjie XIN Yuhua
	 * @param place
	 */
	public void deletePlace(Place place);
	
	/**
	 * Add Token to a Place in PetriNetwork  
	 * @author FU Wenjie XIN Yuhua
	 * @param place
	 * @param addTokenNumber
	 */
	public void addPlaceToken(Place place, int addTokenNumber);
	
	/**
	 * Delete Token from a Place in PetriNetwork  
	 * @author FU Wenjie XIN Yuhua
	 * @param place
	 * @param deleteTokenNumber
	 */
	public void deletePlaceToken(Place place, int deleteTokenNumber);
	
	/**
	 * Add an ArcLeft(Transition -> Place) to PetriNetwork  
	 * @author FU Wenjie XIN Yuhua
	 * @param place
	 * @param transition
	 * @param initialToken
	 * @return ArcLet added to PetriNetwork  
	 */
	public ArcLeft addArcLeft(Place place, Transition transition, int initialToken);
	
	/**
	 * Add an ArcZero(Place -> Transition) to PetriNetwork 
	 * @author FU Wenjie XIN Yuhua
	 * @param place
	 * @param transition
//	 * @return ArcZero added to PetriNetwork
	 */
	public ArcZero addArcZero(Place place, Transition transition);

	/**
	 * Add an ArcVideur(Place -> Transition) to PetriNetwork 
	 * @author FU Wenjie XIN Yuhua
	 * @param place
	 * @param transition
	 * @return ArcVideur added to PetriNetwork
	 */
	public ArcVideur addArcVideur(Place place, Transition transition);
	
	/**
	 * Add an ArcEnteredNormal(Place -> Transition) to PetriNetwork 
	 * @author FU Wenjie XIN Yuhua
	 * @param place
	 * @param transition
	 * @param initialToken
	 * @return ArcEnteredNormal added to PetriNetwork
	 */
	public ArcEnteredNormal addArcEnteredNormal(Place place, Transition transition, int initialToken);
	
	/**
	 * Delete a Arc from PetriNetwork  
	 * @author FU Wenjie XIN Yuhua
	 * @param arc
	 */
	public void deleteArc(Arc arc);
	
	/**
//	 * Add an Transition to PetriNetwork 
	 * @author FU Wenjie XIN Yuhua
	 * @return Transition added to PetriNetwork
	 */
	public Transition addTransition();
	
	/**
	 * Connect Place and Transition through an ArcEntered  
	 * @author FU Wenjie XIN Yuhua
	 * @param transition
	 * @param arc
	 * @throws DoubleArcException
	 */
	public void connectTransition2ArcEntered(Transition transition, Arc arc) throws DoubleArcException;
	
	/**
	 * Connect Place and Transition through an ArcLeft
	 * @author FU Wenjie XIN Yuhua
	 * @param transition
	 * @param arc
	 * @throws DoubleArcException
	 */
	public void connectTransition2ArcLeft(Transition transition, Arc arc) throws DoubleArcException;
	
	/**
	 * Delete a Transition from PetriNetwork 
	 * @author FU Wenjie XIN Yuhua
	 * @param transition
	 */
	public void deleteTransition(Transition transition);
	
	/**
	 * Change the token on an Arc in the PetriNetwork  
	 * @author FU Wenjie XIN Yuhua
	 * @param arc
	 * @param newToken
	 */
	public void changeArcToken(Arc arc, int newToken);
	
	/**
	 * Make Transition perform an action  
	 * @author FU Wenjie XIN Yuhua
	 */
	public void fire(Transition transition);
	
	public boolean isEnable(Transition transition);
	
	/**
	 * Print out the PetriNetwork as a string  
	 * @author FU Wenjie XIN Yuhua
	 * @return A string containing PetriNetwrok information  
	 */
	public String show();
	
}
