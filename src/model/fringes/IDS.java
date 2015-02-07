package model.fringes;

import model.SF;
import model.states.State;


public class IDS implements Fringe{

	private Node first;
	private int total = 0;
	private State start_state;
	private State currentParent;
	private int currentDepth = 0;
	private int currentMaxDepth = 1;
	private int maxDepth;
	private int added=0;
	
	/**
	 * Single element of the fringe
	 * @author Nicola Pedretti
	 *
	 */
	private class Node {
        private State state;
        private Node next;
        
        private Node(State state, Node next){
        	this.state=state;
        	this.next=next;
        }
    }
	
	public IDS(State first_state){
		first = new Node(first_state,null);
		start_state = first_state;
		maxDepth = 2*(SF.getArraylist(first_state.numbersLeft).size())-1;
		total++;
		
	}
	
	@Override
	public State peek() {
		if (first == null) new java.util.NoSuchElementException();
		return first.state;
	}

	@Override
	public State pull() {
		if (first == null) new java.util.NoSuchElementException();
        State state = first.state;
        first = first.next;
        total--;
        return state;
	}
	
	/**
	 * brings the search back to the initial state 
	 * and increases the currentMaxDepth
	 */
	private void goBackToStart(){
		if(!(++currentMaxDepth>maxDepth)){
			added=0;
			first = new Node(start_state,null);
	    	currentDepth=0;
	    	currentParent=start_state;
	    	total++;
		}
	}

	@Override
	public boolean add(State state) {
		 if(!isStateOverCurrentMaxDepth(state)){
			 if(total==0 && currentMaxDepth<maxDepth){
				 goBackToStart();
			 }
			 return false;
		 }
		 Node current = first;
		 first = new Node(state,current);
	     total++;
	     return true;
	}
	
	/**
	 * check if a state has passed the currentMaxDepth
	 * @param state State to check
	 * @return true if it has passed the currentMacDepth
	 */
	private boolean isStateOverCurrentMaxDepth(State state){
		int current_depth = SF.getArraylist(state.numbersUsed).size()+SF.getArraylist(state.operationsUsed).size();
		return current_depth<=currentMaxDepth;
	}

	@Override
	public boolean isEmpty() {
		return total == 0;
	}
	
	

}
