package com.yyh;
// Write a function to generate the generalized abbreviations of a word.
import java.util.ArrayList;
import java.util.List;

public class Solution {
	List<String> res;
	boolean[] arr;

	public List<String> generateAbbreviations(String word) {
		res = new ArrayList<>();
		if (word.length() == 0){
			res.add("");
			return res;
		}
		arr = new boolean[word.length()];
		helper(word, 0);
		return res;
	}

	private void helper(String word, int num){
		if (num == word.length()){
			gen(word, arr);
			return;
		}
		arr[num] = true;
		helper(word, num + 1);
		arr[num] = false;
		helper(word, num + 1);
	}

	private void gen(String word, boolean[] arr){
		StringBuilder sb= new StringBuilder();
		for (int i = 0; i < word.length(); i++){
			if (!arr[i]){
				sb.append(word.charAt(i));
				continue;
			}
			int count = 0;
			while (i < word.length() && arr[i]){
				count++;
				i++;
			}
			sb.append(count);
			i--;
		}
		res.add(sb.toString());
	}
}
