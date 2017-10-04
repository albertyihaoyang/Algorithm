package com.yyh;
import java.util.ArrayList;
/*
 * Given a set of characters represented by a String, return a list containing all subsets of the characters.
 * Assumptions:
 * There are no duplicate characters in the original set.
 */
import java.util.List;

public class SubSets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String set = "abcde";
		System.out.print(subSets(set));
	}
	
	public static List<String> subSets(String set) {
	    if (set== null) {
	    	return new ArrayList<String>();
	    }
	    List<String> result = new ArrayList<String>();
	    if (set.length() == 0){
	    	result.add("");
	    	return result;
	    }
	    String cur = "";
	    subSets(set, 0, cur, result);
	    return result;  
	  }
	
	public static void subSets(String set, int index, String cur, List<String> result){
		if (index == set.length()){
			result.add(cur);
			return;
		}
		cur = cur + set.charAt(index);
		subSets(set, index + 1, cur, result);
		cur = cur.substring(0, cur.length()-1);
		subSets(set, index + 1, cur, result);
	}

}
