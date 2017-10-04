package com.yyh;

public class Reverse {
	public static void main(String[] args){
		System.out.println(reverse("Google"));
	}
	
	public static String reverse(String input) {
	    if (input == null || input.length() < 2){
	    	return input;
	    }
	    char[] set = input.toCharArray();
	    reverse(set, 0, set.length -1);
	    return new String(set, 0, set.length);
	}
	
	public static void reverse(char[] set, int start, int end){
		for (int i = 0; i <= (end - start) / 2; i++){
			char temp = set[start + i];
			set[start + i] = set[end - i];
			set[end - i] = temp;
		}
	}
	
	public static void swap(char[] set, int a, int b){
		char temp = set[a];
		set[a] = set[b];
		set[b] = temp;
	}
}
