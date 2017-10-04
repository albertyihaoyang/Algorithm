package com.yyh;
/*
 * Remove adjacent, repeated characters in a given string, leaving only one character for each group of such characters.
 */
public class DeDup {

	public static void main(String[] args) {
		String input = "aaaabbbc";
		System.out.println(deDup(input));
		

	}

	public static String deDup(String input) {
	    if (input == null || input.length() == 0){
	    	return input;
	    }
		int slow = 0;
	    int fast = 0;
	    char temp = ' ';
	    while (fast < input.length()){
	    	if (input.charAt(fast) != temp){
	    		temp = input.charAt(fast);
	    		input = input.substring(0, slow) + temp + input.substring(slow + 1, input.length());
	    		slow++;
	    	}
	    	fast++;
	    }
	    return input.substring(0, slow);
	  }
}
