package com.yyh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Find all numbers that appear in both of two sorted arrays (the two arrays are all sorted in ascending order).
 */
public class Common1Pointer {

	public static void main(String[] args) {
		Integer[] a = new Integer[] {1, 1, 2, 2, 3};
		Integer[] b = new Integer[] {1, 1, 2, 5, 6};
		List<Integer> A = Arrays.asList(a);
		List<Integer> B = Arrays.asList(b);
		System.out.println(common(A, B));
	}
	public static List<Integer> common(List<Integer> A, List<Integer> B) {
	    if (A.size() == 0 || B.size() == 0){
	    	return new ArrayList<Integer>();
	    }
	    int a = 0;
	    int b = 0;
	    List<Integer> resultList = new ArrayList<Integer>();
	    while (a < A.size() && b < B.size()){
	    	if (A.get(a) == B.get(b)){
	    		resultList.add(A.get(a));
	    		a++;
	    		b++;
	    	} else if (A.get(a) > B.get(b)){
	    		b++;
	    	} else {
	    		a++;
	    	}
	    }
	    return resultList;
	  }
}
