package model.fringes;

import model.states.State;

public class DFS implements Fringe{
	
	private Node first;
	private int total = 0;
	
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
	
	public DFS(State firstState){
		first = new Node(firstState,null);
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

	@Override
	public boolean add(State state) {
		 Node current = first;
	     first = new Node(state,current);
	     total++;
	     return true;
	}

	@Override
	public boolean isEmpty() {
		return total == 0;
	}

}
