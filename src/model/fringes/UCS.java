package model.fringes;

import java.util.ArrayList;
import java.util.HashMap;

import model.SF;
import model.states.State;

/**
 * Implementation of a fringe that uses Uniform Cost Search
 * @author Nicola Pedretti
 *
 */
public class UCS implements Fringe{

	private Node first;
	private int total = 0;
	private HashMap<String,Integer> costs;
	
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
	
	public UCS(State firstState){
		first = new Node(firstState,null);
		total++;
		costs = new HashMap<String,Integer>();
		initializeCosts();
	}
	
	/**
	 * Initializes the costs array with all the different operators and their costs
	 */
	private void initializeCosts(){
		costs.put("/", 32);
		costs.put("*", 6);
		costs.put("-", 4);
		costs.put("+", 4);
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

	@Override
	public boolean add(State state) {
		int stateCost = calculateStateCost(state);
		Node current = first;
		if(first==null) {
			first = new Node(state,null);
			total++;
			return true;
		}
		while(current.next!=null){
			if(calculateStateCost(current.next.state)>=stateCost){
				Node newNode = new Node(state,current.next);
				current.next=newNode;
				total++;
				return true;
			}
			current = current.next;
		}
		Node newNode = new Node(state,current.next);
		current.next = newNode;
		total++;
	    return true;
	}
	
	private int calculateStateCost(State state){
		ArrayList<String> operations = SF.getArraylist(state.operationsUsed);
		int cost = 0;
		for(String operation: operations){
			cost+=costs.get(operation);
		}
		return cost;
	}

	@Override
	public boolean isEmpty() {
		return total == 0;
	}
	
	
}
