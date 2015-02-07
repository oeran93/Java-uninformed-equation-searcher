package model.states;

import java.util.ArrayList;
import java.util.Arrays;

import model.SF;

public class NumberState extends State{
	
	public NumberState(String nl, String nu, String ou, int cr, String branch_path, OperationState parent_state){
		super(nl,nu,ou,cr,branch_path,parent_state);
	}
	
	@Override
	public ArrayList<State> createSuccessorStates(){
		ArrayList<State> states = new ArrayList<State>();
		ArrayList<String> numLeft = SF.getArraylist(numbersLeft);
		for(int branch_path= 0; branch_path< numLeft.size(); branch_path++){
			if(validStateResult(Integer.parseInt(numLeft.get(branch_path)))){
				states.add(new OperationState(getNewNumbersLeft(branch_path),getNewNumbersUsed(branch_path)
						,operationsUsed,getNewStateResult(numLeft.get(branch_path)),path+Integer.toString(branch_path),this));
			}
		}
		return states;
	}
	
	/**
	 * check if the state result is an integer
	 * @param newNumber the number added to the state
	 * @return
	 */
	private boolean validStateResult(int newNumber){
		if(!operationsUsed.equals("") && operationsUsed.charAt(operationsUsed.length()-1)=='/'){
			return currentResult%newNumber==0;
		}
		return true;
	}
	
	/**
	 * get the new numbers left of a state
	 * @param indexItemremoved index, in the numbersLeft, of the item removed
	 * @return String the new numbersLeft
	 */
	private String getNewNumbersLeft(int indexItemRemoved){
		ArrayList<String> tempNumbersLeft = SF.getArraylist(numbersLeft);
		tempNumbersLeft.remove(indexItemRemoved);
		String newNumbersLeft = "";
		for(String number: tempNumbersLeft){
			newNumbersLeft= newNumbersLeft+" "+number;
		}
		return newNumbersLeft.trim();
	}
	
	/**
	 * get the new numbersUsed of the state
	 * @param indexItemToAdd index, in the numbersLeft, of the item to add
	 * @return String the new numbersUsed
	 */
	private String getNewNumbersUsed(int indexItemToAdd){
		return (numbersUsed+" "+SF.getArraylist(numbersLeft).get(indexItemToAdd)).trim();
	}
	
	/**
	 * get the new current result of a state
	 * @param newNumber String the recently added number
	 * @return int the new current result
	 */
	private int getNewStateResult(String newNumber){
		if (operationsUsed.equals("")){
			return Integer.parseInt(newNumber);
		}
		switch(operationsUsed.charAt(operationsUsed.length()-1)){
		case '+':
			return currentResult + Integer.parseInt(newNumber);
		case '-':
			return currentResult - Integer.parseInt(newNumber);
		case '*':
			return currentResult * Integer.parseInt(newNumber);
		case '/':
			return currentResult / Integer.parseInt(newNumber);
		default:
			return 0;
		}
	}
}
