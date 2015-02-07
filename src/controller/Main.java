package controller;

import java.util.HashMap;

import view.View;
import model.Search;
import model.fringes.BFS;
import model.fringes.DFS;
import model.fringes.Fringe;
import model.fringes.IDS;
import model.fringes.UCS;
import model.states.NumberState;
import model.states.State;
/**
 * The Main class collects all the parameters needed for the search (debug, searchMethod, setOfNUmbers).
 * It then initializes the Search class and starts the quest for the goal.
 * @author Nicola Pedretti
 *
 */
public class Main {
	
	private static HashMap<String,Fringe> fringes = new HashMap<String,Fringe>();
	private static String numbers;
	public static Fringe fringe;
	public static int target;
	public static int debug;
	
	public static void main(String[] args){
		debug = Integer.parseInt(args[0]);
		String search_method = args[1];
		target = Integer.parseInt(args[2]);
		StringBuilder setOfNumbers = new StringBuilder();
		for(int i = 3; i< args.length; i++){
			setOfNumbers.append(args[i]);
			setOfNumbers.append(" ");
		}
		numbers = setOfNumbers.toString();
		initializeFringes();
		fringe = fringes.get(search_method);
		Search s = new Search();
		s.findGoalState();
	}
	
	/**
	 * initializes the fringes HashMap to contain all possible fringes
	 */
	public static void initializeFringes(){
		fringes.put("DFS", new DFS(new NumberState(numbers,"","",0,"0",null)));
		fringes.put("UCS", new UCS(new NumberState(numbers,"","",0,"0",null)));
		fringes.put("BFS", new BFS(new NumberState(numbers,"","",0,"0",null)));
		fringes.put("IDS", new IDS(new NumberState(numbers,"","",0,"0",null)));
	}
}
