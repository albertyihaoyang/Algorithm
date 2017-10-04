package com.yyh;

public class Innerprroduct {

	public static void main(String[] args) {
		int [] a = {1, 2, 3, 4, 5};
		int [] b = {2, 3, 4, 5, 6};
		int sum = 0;
		for (int i = 0; i < a.length; i++){
			sum += a[i]*b[i];
		}
		System.out.print(sum);
	}

}
