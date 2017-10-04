package com.yyh;
// Given a positive integer num, write a function which returns True if num is a perfect square else False.
public class IsPerfectSquare {
	public boolean isPerfectSquare(int num) {
        int i = 0;
        while (i * i < num && i * i >= 0){
            i++;
        }
        return (i * i == num);
    }
}
