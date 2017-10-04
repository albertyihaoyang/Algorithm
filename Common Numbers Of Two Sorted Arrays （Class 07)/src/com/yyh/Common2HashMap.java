package com.yyh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Common2HashMap {
	public static void main(String[] args) {
		Integer[] a = new Integer[] {1, 1, 2, 2, 3};
		Integer[] b = new Integer[] {1, 1, 2, 5, 6};
		List<Integer> A = Arrays.asList(a);
		List<Integer> B = Arrays.asList(b);
		System.out.println(common(A, B));
	}
	public static List<Integer> common(List<Integer> A, List<Integer> B) {
		List<Integer> result = new ArrayList<Integer>();
		Map<Integer, Integer> countA = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.size(); i++){
			Integer cur = countA.get(A.get(i));
			if (cur != null) {
				countA.put(A.get(i), cur + 1);
			} else {
				countA.put(A.get(i), 1);
			}
		}
		Map<Integer, Integer> countB = new HashMap<Integer, Integer>();
		for (int i = 0; i < B.size(); i++){
			Integer cur = countB.get(B.get(i));
			if (cur != null) {
				countB.put(B.get(i), cur + 1);
			} else {
				countB.put(B.get(i), 1);
			}
		}
		for (Map.Entry<Integer, Integer> entry : countA.entrySet()){
			Integer cInB = countB.get(entry.getKey());
			if (cInB != null) {
				for (int i = 0; i < Math.min(cInB, entry.getValue()); i++){
					result.add(entry.getKey());
				}
			}
		}
		return result;
	}
}
