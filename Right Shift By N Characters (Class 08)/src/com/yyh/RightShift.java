package com.yyh;

/*
 * Right shift a given string by n characters.
 */
public class RightShift {

	public static void main(String[] args) {
		RightShift myRS = new RightShift();
		System.out.println(myRS.rightShift("Google", 3));
	}

	public String rightShift(String input, int n) {
	    if (input.length() <= 1){
	    	return input;
	    }
	    char[] array = input.toCharArray();
	    n %= array.length;
	    reverse(array, array.length - n, array.length - 1);
	    reverse(array, 0, array.length - n - 1);
	    reverse(array, 0, array.length - 1);
	    return new String(array);
	}
	
	private void reverse(char[] array, int left, int right){
		while (left < right) {
			char tmp = array[left];
			array[left] = array[right];
			array[right] = tmp;
			left++;
			right--;
		}
	}
}
