package com.yyh;

/*
 * Remove1Set given characters in input string, the relative order 
 * of other characters should be remained. Return the new string after deletion.
 * 
 * Assumptions
 * 	The given input string is not null.
 * 	The characters to be removed is given by another string, it is guranteed to be not null.
 */
public class Remove2Inplace {

	public static void main(String[] args) {
		System.out.println(remove("abcdba","ab"));

	}

	public static String remove(String input, String t) {
	    if (input.length() == 0 || t.length() == 0){
	    	return input;
	    }
	    for (int i = 0; i < t.length(); i++){
	    	char ch = t.charAt(i);
	    	int pointer = 0;
	    	while (pointer < input.length()){
	    		if (input.charAt(pointer) == ch){
	    			input = input.substring(0, pointer) + input.substring(pointer + 1, input.length());
	    		}
	    		pointer++;
	    	}
	    }
	    return input;
	 }
	
}
