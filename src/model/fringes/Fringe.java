package model.fringes;

import model.states.State;

public interface Fringe {
	
	/**
	 * gets a peek at a state in the fringe without removing it.
	 * @return State state to peek
	 */
	State peek();
	/**
	 * pulls a state out of the fringe permanently
	 * @return State state pulled
	 */
	State pull();
	/**
	 * adds a state to the fringe
	 * @param state State state to add
	 * @return
	 */
	boolean add(State state);
	/**
	 * checks if the fringe is empty
	 * @return true if the fringe is empty
	 */
	boolean isEmpty();
	
}
