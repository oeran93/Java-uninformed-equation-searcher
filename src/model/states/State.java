package model.states;

import java.util.ArrayList;
import java.util.Arrays;

import model.SF;

/**
 * Class that stores all the main information about a state
 * and the operations that it can do
 */
public abstract class State {
	
	public String numbersLeft;
	public String numbersUsed;
	public String operationsUsed;
	public int currentResult;
	public State parentState;
	public StringBuilder path = new StringBuilder();
	
	public State(String nl, String nu, String ou, int cr, String path, State parentState){
		this.numbersLeft = nl;
		this.numbersUsed = nu;
		this.operationsUsed = ou;
		this.currentResult = cr;
		this.parentState = parentState;
		this.path.append(path);
	}
	
	/**
	 * Creates all the successor states of the state
	 */
	public abstract ArrayList<State> createSuccessorStates();
	
	@Override
	public String toString(){
		String operations_order = "+-*/";
		StringBuilder equation = new StringBuilder();
		ArrayList<String> numbers = SF.getArraylist(numbersUsed);
		ArrayList<String> operators = SF.getArraylist(operationsUsed);
		char last_operator ='/';
		int number_closing_parenthesis = 0;
		for(int i=0; i<numbers.size();i++){
			equation.append(numbers.get(i));
			if(i<operators.size()){
				if (operations_order.indexOf(last_operator)<operations_order.indexOf(operators.get(i))){
					equation.append(")");
					number_closing_parenthesis++;
				}
				last_operator=operators.get(i).charAt(0);
				equation.append(operators.get(i));
			}
		}
		for(int i=0;i<number_closing_parenthesis;i++){
			equation.insert(0, "(");
		}
		return equation.toString();
	}
	
}
