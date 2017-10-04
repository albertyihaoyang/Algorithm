package com.yyh;

/*
 * Given a string in compressed form, decompress it to the original string. 
 * The adjacent repeated characters in the original string are compressed to have the 
 * character followed by the number of repeated occurrences.
 */
public class DecompressWithInPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(decompress("a1c0b2c4"));
	}

	public static String decompress(String input) {
	    if (input.length() == 0){
	    	return "";
	    }
	    int totalLen = 0;
	    for (int i = 0; i < input.length() / 2; i++){
	    	totalLen += Character.getNumericValue(input.charAt(i * 2 + 1));
	    }
	    char[] newString = new char[totalLen];
	    int index = 0;
	    for (int i = 0; i < input.length() / 2; i++){
	    	int repeat = Character.getNumericValue(input.charAt(i * 2 + 1));
	    	for (int j = 0; j < repeat; j++){
	    		newString[index++] = input.charAt(i * 2);
	    	}
	    }
	    return new String(newString, 0, newString.length);
	 }
}
