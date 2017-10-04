package com.yyh;

public class GCD {

	public static void main(String[] args) {
		int a = 147, b = 105;
		while (a!=b){
			if (a>b){
				a -= b;
			}
			else {
				b -= a;
			}
		}
		System.out.print(a);
	}

}
