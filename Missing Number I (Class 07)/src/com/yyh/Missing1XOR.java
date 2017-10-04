package com.yyh;

public class Missing1XOR {
	public static void main(String[] args){
		System.out.println(missing(new int[0]));
		System.out.println(missing(new int[]{1, 2, 3}));
	}
	public static int missing(int[] array) {
	    if (array.length == 0){
	    	return 1;
	    }
	    int resultNor = 0;
	    for (int i = 1; i <= array.length + 1; i++){
	    	resultNor = resultNor ^ i;
	    }
	    int resultArr = 0;
	    for (int i : array){
	    	resultArr ^= i;
	    }
	    return resultArr ^ resultNor;
	  }
}
