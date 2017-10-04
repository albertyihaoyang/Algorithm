package com.yyh;

public class ReverseWords {
	public static void main(String[] args){
		System.out.println(reverseWords("I love Google"));
	}
	
	public static String reverseWords(String input) {
	    if (input == null || input.length() < 2){
	    	return input;
	    }
	    char[] set = input.toCharArray();
	    int slow = 0;
	    int fast = 0;
	    while (fast < set.length){
	    	if (set[fast] == ' '){
	    		reverse(set, slow, fast - 1);
	    		slow = fast + 1;
	    	}
	    	fast++;
	    }
	    reverse(set, slow, fast - 1);
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
