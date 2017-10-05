package com.yyh;

import java.util.ArrayList;
import java.util.List;

// Common Elements In Three Sorted Array
public class Common {
	public List<Integer> common(int[] a, int[] b, int[] c) {
	    List<Integer> res = new ArrayList<>();
	    int i = 0; int j = 0; int k = 0;
	    while (i < a.length && j < b.length && k < c.length){
	    	if (a[i] < b[j]){
	    		i++;
	    	} else if (a[i] > b[j]){
	    		j++;
	    	} else {
	    		while (k < c.length && c[k] < a[i]){
	    			k++;
	    		}
	    		if (k < c.length && c[k] == a[i]) {
	    			res.add(c[k]);
	    			k++;
	    		}
	    		i++;j++;
	    	}
	    }
	    return res;
	}
}
