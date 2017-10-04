package com.yyh;

public class EditDistance {

	public static void main(String[] args) {
		EditDistance my = new EditDistance();
		System.out.println(my.editDistance("sigh", "asith"));
	}

	public int editDistance(String one, String two) {
//	    if (one.length() == 0){
//	    	return two.length();
//	    }
//	    if (two.length() == 0){
//	    	return one.length();
//	    }
	    int[][] result = new int[one.length() + 1][two.length() + 1];
	    for (int i = 0; i <= one.length(); i++){
	    	result[i][0] = i;
	    }
	    for (int j = 0; j <= two.length(); j++){
	    	result[0][j] = j;
	    }
	    for (int i = 1; i <= one.length(); i++){
	    	for (int j = 1; j <= two.length(); j++){
	    		if (one.charAt(i - 1) == two.charAt(j - 1)){
	    			result[i][j] = result[i - 1][j - 1];
	    		} else {
	    			result[i][j] = 1 + Math.min(Math.min(result[i - 1][j], result[i][j - 1]), 
	    					result[i - 1][j - 1]);
	    		}
	    	}
	    }
	    return result[one.length()][two.length()];
	  }
}
