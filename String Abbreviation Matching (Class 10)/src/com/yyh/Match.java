package com.yyh;
//Word “book” can be abbreviated to 4, b3, b2k, etc. Given a string and an abbreviation, 
//return if the string matches the abbreviation.
public class Match {

	public static void main(String[] args) {
		Match my = new Match();
		System.out.println(my.match("book", "b2k"));
		System.out.println(my.match("apple", "a2l2"));
		System.out.println(my.match("sophisticated", "s11d"));

	}

	public boolean match(String input, String pattern) {
	    if (input == null || pattern ==null){
	    	return false;
	    }
	    if (input.length() == 0 && pattern.length() == 0){
	    	return true;
	    } else if (input.length() == 0 || pattern.length() == 0){
	    	return false;
	    }
	    char[] inputArr = input.toCharArray();
	    char[] patternArr = pattern.toCharArray();
	    return match(inputArr, 0, patternArr, 0);
	 }
	
	private boolean match(char[] inputArr, int iIndex, char[] patternArr, int pIndex){
		if (iIndex == inputArr.length && pIndex == patternArr.length){
			return true;
		} else if (iIndex >= inputArr.length || pIndex >= patternArr.length){
			return false;
		}
		if (inputArr[iIndex] == patternArr[pIndex]){
			return match(inputArr, iIndex + 1, patternArr, pIndex + 1);
		}
		if (patternArr[pIndex] > '0' && patternArr[pIndex] <= '9'){
			int nums = 0;
			while (pIndex < patternArr.length && patternArr[pIndex] >= '0' && patternArr[pIndex] <= '9'){
				nums = nums * 10 + (patternArr[pIndex++] - 48);
			}
			return match(inputArr, iIndex + nums, patternArr, pIndex);
		}
		return false;
	}
}
