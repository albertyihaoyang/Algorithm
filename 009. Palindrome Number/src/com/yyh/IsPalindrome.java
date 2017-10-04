package com.yyh;
// Determine whether an integer is a palindrome. Do this without extra space.
public class IsPalindrome {

	public static void main(String[] args) {
		IsPalindrome my = new IsPalindrome();
		System.out.print(my.isPalindrome(Integer.MAX_VALUE));
	}

	public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)){
        	return false;
        }
        int rev = 0;
        while (x > rev){
        	rev = rev * 10 + x % 10;
        	x /= 10;
        }
        return (x == rev || (x == rev / 10));
    }
}
