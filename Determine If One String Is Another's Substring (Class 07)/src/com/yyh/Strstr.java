package com.yyh;

public class Strstr {
	public static void main(String[] args){
		System.out.println(strstr("bcabc",""));
	}
	
	public static int strstr(String large, String small) {
	    if (small.length() == 0){
	    	return 0;
	    }
	    for (int i = 0; i <= large.length() - small.length(); i++){
	    	int j = 0;
	    	for (j = 0; j < small.length(); j++) {
	    		if (large.charAt(i + j) != small.charAt(j)) {
	    			break;
	    		}
	    		if (j == small.length() - 1) {
	    			return i;
	    		}
	    	}
	    }
	    return -1;
	 }
}
