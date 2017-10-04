package com.yyh;
import java.util.*;
// Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 
// can be used and each combination should be a unique set of numbers.
public class CombinationSum3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSum3 my = new CombinationSum3();
		System.out.println(my.combinationSum3(2, 18).toString());
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
		if (k == 0 || n == 0 || (1 + k) * k / 2 > n){
        	return result;
        }
		List<Integer> curR = new ArrayList<>();
		helper(k, n, 1, curR, result);
		return result;
    }
	
	private void helper(int k, int n, int start, List<Integer> curR, List<List<Integer>> result){
		if (k == 1 && start <= n && n <= 9){
			curR.add(n);
			result.add(new ArrayList<>(curR));
			curR.remove(curR.size() - 1);
			return;
		}
		if (k == 1){
			return;
		}
		for (int j = start; j < Math.min(10, n); j++){
			curR.add(j);
			helper(k - 1, n - j, j + 1, curR, result);
			curR.remove(curR.size() - 1);
		}
	}
}
