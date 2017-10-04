package com.yyh;

/*
 * Repeatedly remove all adjacent, repeated characters in a given string from left to right.
 * 
 * No adjacent characters should be identified in the final string.
 */
public class DeDup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "aabccdc";
		System.out.println(deDup(input));
	}
	
	public static String deDup(String input) {
		if (input == null || input.length() == 0){
			return input;
		}
		boolean flag = false;
		int slow = 0;
		int fast = 0;
		char temp = ' ';
		for (fast = 0; fast < input.length(); fast++){
			if (input.charAt(fast) == temp && flag == false) {
				slow = fast;
				flag = true;
			} else if (input.charAt(fast) != temp && flag == true) {
				break;
			} else {
				temp = input.charAt(fast);
			}
		}
		if (flag == false) {
			return input;
		} else {
			input = input.substring(0, slow - 1) + input.substring(fast, input.length());
			return deDup(input);
		}
	  }
}
