package com.yyh;

public class Binary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Binary my = new Binary();
		my.printBinary(5);
		my.printBinary(-5);
		my.printBinary(Integer.MAX_VALUE);
		my.printBinary(Integer.MIN_VALUE);
	}

	public void printBinary(int n){
		System.out.print("Val " + n + " : ");
		for (int i = 31; i >= 0; i--){
			System.out.print((n >> i) & 1);
		}
		System.out.println();
	}
}
