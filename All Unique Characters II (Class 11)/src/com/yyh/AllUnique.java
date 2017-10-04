package com.yyh;

// Determine if the characters of a given string are all unique.

public class AllUnique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllUnique my = new AllUnique();
		System.out.println(my.allUnique("abA+8"));
		System.out.println(my.allUnique("abA+a8"));
	}

	public boolean allUnique(String word) {
	    int[] binVec = new int[8];
	    for (int i = 0; i < word.length(); i++){
	      int asCode = (int)word.charAt(i);
	      int bin = asCode / 32;
	      int vec = 1 << asCode % 32;
	      if ((binVec[bin] & vec) > 0){
	        return false;
	      }
	      binVec[bin] |= vec;
	    }
	    return true;
	 }
}
