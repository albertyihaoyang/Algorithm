package com.yyh;

// Determine if the characters of a given string are all unique.

public class AllUnique3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllUnique3 my = new AllUnique3();
		System.out.println(my.allUnique("abA+8"));
		System.out.println(my.allUnique("abA+a8"));
	}

	public boolean allUnique(String word) {
	    boolean[] vec = new boolean[256];
	    for (int i = 0; i < word.length(); i++){
	    	if (vec[(int)word.charAt(i)]) {
	    		return false;
	    	}
	    	vec[(int)word.charAt(i)] = true;
	    }
	    return true;
	 }
}
