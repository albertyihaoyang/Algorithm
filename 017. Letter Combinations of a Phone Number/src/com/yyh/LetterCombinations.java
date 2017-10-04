package com.yyh;
import java.util.*;
//Given a digit string, return all possible letter combinations that the number could represent.
public class LetterCombinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LetterCombinations my = new LetterCombinations();
		System.out.println(my.letterCombinations("23").toString());
	}

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if (digits == null || digits.length() == 0){
			return result;
		}
		char[] dArr = digits.toCharArray();
		char[] curR = new char[dArr.length];
		Map<Character, List<Character>> dict = new HashMap<>();
		List<Character> set2 = new ArrayList<>(Arrays.asList('a', 'b', 'c'));
		List<Character> set3 = new ArrayList<>(Arrays.asList('d', 'e', 'f'));
		List<Character> set4 = new ArrayList<>(Arrays.asList('g', 'h', 'i'));
		List<Character> set5 = new ArrayList<>(Arrays.asList('j', 'k', 'l'));
		List<Character> set6 = new ArrayList<>(Arrays.asList('m', 'n', 'o'));
		List<Character> set7 = new ArrayList<>(Arrays.asList('p', 'q', 'r', 's'));
		List<Character> set8 = new ArrayList<>(Arrays.asList('t', 'u', 'v'));
		List<Character> set9 = new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z'));
		dict.put('2', set2); dict.put('3', set3); dict.put('4', set4); dict.put('5', set5);
		dict.put('6', set6); dict.put('7', set7); dict.put('8', set8); dict.put('9', set9);
		helper(dArr, curR, 0, result, dict);
		return result;
    }
	
	private void helper(char[] dArr, char[] curR, int index, List<String> result, Map<Character, List<Character>> dict){
		if (index == dArr.length){
			result.add(new String(curR, 0, curR.length));
			return;
		}
		if (!dict.containsKey(dArr[index])){
			return;
		}
		List<Character> curList = dict.get(dArr[index]);
		for (int i = 0; i < curList.size(); i++){
			curR[index] = curList.get(i);
			helper(dArr, curR, index + 1, result, dict);
		}
	}
}
