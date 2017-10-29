package com.yyh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given a collection of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 */
public class Solution {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, res, cur, 0);
        return res;
    }
    
    private void helper(int[] candidates, int target, List<List<Integer>> res, List<Integer> cur, int index){
        if (target == 0){
            res.add(new ArrayList<Integer>(cur));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < candidates.length; i++){
            if (!set.contains(candidates[i])){
                if (candidates[i] <= target){
                    cur.add(candidates[i]);
                    helper(candidates, target - candidates[i], res, cur, i + 1);
                    cur.remove(cur.size() - 1);
                }
            }
            set.add(candidates[i]);
        }
    }
}
