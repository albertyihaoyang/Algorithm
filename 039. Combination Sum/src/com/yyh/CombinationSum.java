package com.yyh;
import java.util.*;
//Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
//	find all unique combinations in C where the candidate numbers sums to T.
//The same repeated number may be chosen from C unlimited number of times.
public class CombinationSum {

	public static void main(String[] args) {
		CombinationSum my = new CombinationSum();
		int[] candidates = {2, 3, 6, 7};
		int target = 7;
		System.out.println(my.combinationSum(candidates, target).toString());
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0 || target == 0){
        	return result;
        }
        List<Integer> curR = new ArrayList<>();
        helper(candidates, target, 0, curR, result);
        return result;
    }
	
	private void helper(int[] candidates, int target, int index, List<Integer> curR, List<List<Integer>> result){
		if (index > candidates.length){
			return;
		} else if (index == candidates.length && target == 0){
			result.add(new ArrayList<Integer>(curR));
		} else if (index == candidates.length){
			return;
		} else {
			int i = 0;
			for (i = 1; i <= target / candidates[index]; i++){
				curR.add(candidates[index]);
				helper(candidates, target - candidates[index] * i, index + 1, curR, result);
			}
			for (int j = 0; j < i - 1; j++){
				curR.remove(curR.size() - 1);
			}
			helper(candidates, target, index + 1, curR, result);
		}
	}
}
