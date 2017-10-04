package com.yyh;
// Given a string, you need to reverse the order of characters 
// in each word within a sentence while still preserving whitespace and initial word order.
public class ReverseWords {
	public String reverseWords(String s) {
        if (s == null){
            return null;
        }
        char[] arr = s.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < arr.length; fast++){
            if (arr[fast] == ' '){
                reverse(arr, slow, fast - 1);
                slow = fast + 1;
            }
        }
        reverse(arr, slow, arr.length - 1);
        return new String(arr, 0, arr.length);
    }
    
    public void reverse (char[] arr, int left, int right){
        while (left < right){
            swap(arr, left++, right--);
        }
    }
    
    public void swap (char[] arr, int a, int b){
        char tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
