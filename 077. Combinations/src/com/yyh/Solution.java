package com.yyh;
// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        if (n == 0 || k == 0 || k > n){
            return res;
        }
        helper(1, n, k, cur, res);
        return res;
    }
    
    private void helper(int index, int n, int k, List<Integer> cur, List<List<Integer>> res){
        if (cur.size() == k){
            res.add(new ArrayList<>(cur));
            return;
        }
        if (index > n) return;
        for (int i = index; i <= n; i++){
            cur.add(i);
            helper(i + 1, n, k, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
