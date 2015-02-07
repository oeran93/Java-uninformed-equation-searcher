package model;

import java.util.ArrayList;

import controller.Main;
import view.View;
import model.states.State;

/**
 * Starts the search loop, pulls states out of the fringe.
 * expands states and adds them to the fringe.
 * Analyzes every state before expanding it, to check if it is the goal
 * @author Nicola Pedretti
 *
 */
public class Search{
	
	public Search(){}
	
	/**
	 * Loops that continues the search
	 */
	public void findGoalState(){
		while(!Main.fringe.isEmpty() && !is_goal(Main.fringe.peek())){
			keepSearching();
		}
		if (Main.fringe.isEmpty()){
			View.alertNoGoalState();
		}
		View.printGoalStateTraceBack(Main.fringe.pull());
	}
	
	/**
	 * Pulls states out of the fringe and expands them.
	 */
	public void keepSearching(){
		State toExpand = Main.fringe.pull();
		if(toExpand.numbersLeft.trim().equals("")){return;}
		ArrayList<State> states = expand_state(toExpand);
		for(State state: states){
			if(!Main.fringe.add(state)) break;
		}
	}
	
	/**
	 * Expands one state
	 * @param parentState State to be expanded
	 * @return ArrayList<State> all the children states
	 */
	public ArrayList<State> expand_state(State parentState){
		if(Main.debug==1) View.printStateContent(parentState);
		return parentState.createSuccessorStates();
	}
	
	/**
	 * Check if a state is the goal state
	 * @param currentState State to be checked
	 * @return
	 */
	public boolean is_goal(State currentState){
		return (currentState.currentResult == Main.target);
	}
	
	
	
}
