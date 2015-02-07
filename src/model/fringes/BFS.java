package model.fringes;

import model.states.State;

public class BFS implements Fringe{

	private Node first,last;
	private int total = 0;
	
	private class Node {
        private State state;
        private Node next;
        
        private Node(State state, Node next){
        	this.state=state;
        	this.next=next;
        }
    }
	
	public BFS(State firstState){
		first = new Node(firstState,null);
		last = first;
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
        if (total == 0) last = null;
        return state;
	}

	@Override
	public boolean add(State state) {
		Node oldNode = last;
		last = new Node(state,null);
	    total++;
	    if (total==1)first = last;
	    else oldNode.next = last;
	    return true;
	}

	@Override
	public boolean isEmpty() {
		return total == 0;
	}

}
