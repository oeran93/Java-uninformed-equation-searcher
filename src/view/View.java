package view;

import controller.Main;
import model.states.State;

public class View {
	
	/**
	 * prints the content of a state
	 * @param state State
	 */
	public static void printStateContent(State state){
		System.out.println("///EXPAND NEW STATE///");
		System.out.println("PATH: "+state.path.toString());
		System.out.println("NUMBERS LEFT: "+state.numbersLeft);
		System.out.println("NUMBERS USED: "+state.numbersUsed);
		System.out.println("CURRENT EQUATION: "+state);
		System.out.println("CURRENT RESULT: "+state.currentResult);
	}
	
	/**
	 * prints the trace back of the goal
	 * @param state
	 */
	public static void printGoalStateTraceBack(State state){
		System.out.println("\nTracing back goal state (branch_path:"+state.path+"):\n");
		while(state != null){
			System.out.println(state);
			state = state.parentState;
		}
	}
	
	/**
	 * prints the absence of a goal state
	 */
	public static void alertNoGoalState(){
		System.out.println("No goal state was found!");
	}

}
