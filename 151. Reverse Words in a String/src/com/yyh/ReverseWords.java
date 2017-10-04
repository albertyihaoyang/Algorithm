package com.yyh;
// Given an input string, reverse the string word by word.
public class ReverseWords {

	public static void main(String[] args) {
		ReverseWords my = new ReverseWords();
		System.out.println(my.reverseWords("the sky is blue"));
	}

	public String reverseWords(String s) {
        if (s.length() == 0 || s == " "){
        	return "";
        }
        char[] arr = s.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast < s.length()){
        	if (arr[fast] == ' '){
        		reverse(arr, slow, fast - 1);
        		slow = fast + 1;
        	}
        	fast++;
        }
        reverse(arr, slow, fast - 1);
        reverse(arr, 0, fast - 1);
        return new String(arr);
    }
	
	private void reverse(char[] arr, int a, int b){
		while (a < b){
			swap(arr, a++, b--);
		}
	}
	
	private void swap(char[] arr, int a, int b){
		char tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
