package model.states;

import java.util.ArrayList;

public class OperationState extends State{
	
	private char[] operations= {'+','-','*','/'};
	
	public OperationState(String nl, String nu, String ou, int cr, String branch_path, NumberState parent_state){
		super(nl,nu,ou,cr,branch_path, parent_state);
	}
	
	@Override
	public ArrayList<State> createSuccessorStates(){
		ArrayList<State> states = new ArrayList<State>();
		for(int branch_path=0;branch_path<operations.length; branch_path++){
			states.add(new NumberState(numbersLeft,numbersUsed
					,(operationsUsed+" "+operations[branch_path]).trim(), currentResult,path+Integer.toString(branch_path),this));
		}
		return states;
	}
	
}
