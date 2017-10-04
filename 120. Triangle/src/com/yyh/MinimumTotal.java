package com.yyh;
import java.util.*;
// Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
public class MinimumTotal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0){
        	return 0;
        }
        if (triangle.size() == 1){
        	return triangle.get(0).get(0);
        }
        List<Integer> result = triangle.get(triangle.size() - 1);
        for (int i = triangle.size() - 2; i >= 0; i--){
        	List<Integer> above = triangle.get(i);
        	List<Integer> newR = new ArrayList<>();
        	for (int j = 0; j <i; j++){
        		newR.add(above.get(j) + Math.min(result.get(j), result.get(j + 1)));
        	}
        	result = newR;
        }
        return result.get(0);
    }
}
