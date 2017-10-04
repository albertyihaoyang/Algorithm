package com.yyh;
import java.util.*;

public class AllPermutation {
	public static void main (String[] args){
		AllPermutation mySol = new AllPermutation();
		String test = "";
		List<String> output = mySol.permutation(test);
		System.out.println("Input is: " + test);
		System.out.println("Your output is: " + output.toString());
		System.out.println(" And the correct output should be: [a])");

		test = "a";
		output = mySol.permutation(test);
		System.out.println("Input is: " + test);
		System.out.println("Your output is: " + output.toString());
		System.out.println(" And the correct output should be: [a])");

		test = "abc";
		output = mySol.permutation(test);
		System.out.println("Input is: " + test);
		System.out.println("Your output is: " + output.toString());
		System.out.println(" And the correct output should be: [abc, acb, bac, bca, cab, cba])");

		test = "aab";
		output = mySol.permutation(test);
		System.out.println("Input is: " + test);
		System.out.println("Your output is: " + output.toString());
		System.out.println(" And the correct output should be: [aab,aba,baa])");

	}
	
	// Assumption: String is not null
	// Time Complexity: O(n!) / Space Complexity: O(n^2)
	public List<String> permutation(String input){
		List<String> result = new ArrayList<>();
		if (input.length() == 0) {
			return result;
		}
		// Use Set to record duplication and char array to build permutated String
		char[] inputArr = input.toCharArray();
		Set<String> dup = new HashSet<>();
		char[] arr = new char[input.length()];
		helper(inputArr, arr, 0, dup, result);
		return result;
	}

	private void helper(char[] inputArr, char[] arr, int index, Set<String> dup, List<String> result){
		// If already one char left, add the char to the new String and add to result with 
// check duplication
		if (index == inputArr.length - 1) {
			arr[index] = inputArr[index];
			String newString = new String(arr, 0, arr.length);
			if (!dup.contains(newString)){
				dup.add(newString);
				result.add(newString);
				return;
			}
		}
		// Try all the unvisited char with swap target char to current index place
		for (int i = index; i < inputArr.length; i++){
			swap(inputArr, index, i);
			arr[index] = inputArr[index];
			helper(inputArr, arr, index + 1, dup, result);
			swap(inputArr, index, i);
		}
	}
	
	private void swap(char[] arr, int a, int b){
		char tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}

