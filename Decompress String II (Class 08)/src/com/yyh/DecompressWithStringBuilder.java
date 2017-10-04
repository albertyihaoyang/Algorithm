package com.yyh;

/*
 * Given a string in compressed form, decompress it to the original string. 
 * The adjacent repeated characters in the original string are compressed to have the 
 * character followed by the number of repeated occurrences.
 */
public class DecompressWithStringBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(decompress("a1c0b2c4"));
	}

	public static String decompress(String input) {
	    if (input.length() == 0){
	    	return "";
	    }
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < input.length() / 2; i++){
	    	int num = Character.getNumericValue(input.charAt(i * 2 + 1));
	    	for (int j = 0; j < num; j++){
	    		sb.append(input.charAt(i * 2));
	    	}
	    }
	    return sb.toString();  
	 }
}
