package com.yyh;
import java.util.*;

/*
 * Write a function that takes a string as input and reverse only the vowels of a string.
 */

public class ReverseVowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseVowels myRV = new ReverseVowels();
		System.out.println(myRV.reverseVowels("leetcode"));
	}

	public String reverseVowels(String s) {
        if (s == null || s.length() <= 1){
            return s;
        }
        Set<Character> vowel = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right){
            if (!vowel.contains(arr[left])){
                left++;
            } else if (!vowel.contains(arr[right])){
                right--;
            } else {
                swap(arr, left++, right--);
            }
        }
        return new String(arr, 0, arr.length);
    }
    
    public void swap(char[] arr, int a, int b){
        char tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
