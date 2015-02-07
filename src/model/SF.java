package model;

import java.util.ArrayList;
import java.util.Arrays;

public class SF {
	
	/**
	 * Creates and ArrayList containing all the numbers passed in.
	 * @param numbers String containing all the numbers separated by a blank space
	 * @return ArrayList<String> ArrayList containg all the numbers
	 */
	public static ArrayList<String> getArraylist(String numbers){
		String[] array = numbers.equals("") ? new String[0] : numbers.split(" ");
		ArrayList<String> array_list = new ArrayList(Arrays.asList(array)); 
		return array_list;
		
	}
}
