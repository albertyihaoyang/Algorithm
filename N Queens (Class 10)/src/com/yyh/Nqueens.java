package com.yyh;
import java.util.*;
public class Nqueens {
	public static void main(String[] args){
		Nqueens my = new Nqueens();
		System.out.println(my.nqueens(4).toString());
		System.out.println(my.nqueens(6).toString());
		System.out.println(my.nqueens(8).toString());
	}
	
	public List<List<Integer>> nqueens(int n) {
		List<List<Integer>> result = new ArrayList<>();
		if (n <= 0){
			return null;
		}
		Integer[] curR = new Integer[n];
		helper(n, 0, curR, result);
		return result;
	 }
	
	private void helper(int n, int index, Integer[] curR, List<List<Integer>> result){
		if (index == n){
			List<Integer> list = new ArrayList<>(Arrays.asList(curR));
			result.add(list);
		}
		for (int i = 0; i < n; i++){
			boolean flag = true;
			for (int j = 0; j < index; j++){
				if (i == curR[j]){
					flag = false;
					break;
				}
				if (Math.abs(i - curR[j]) == Math.abs(index - j)){
					flag = false;
					break;
				}
			}
			if (flag){
				curR[index] = i;
				helper(n, index + 1, curR, result);
			}
		}
	}
}
