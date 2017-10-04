package com.yyh;

public class L2Norm {
	public static void main(String[] args){
		int [] a = {-2, 1, 5, 6, 7};
		double l2Norm = 0.0;
		for (int i : a){
			l2Norm += i*i;
		}
		System.out.println(Math.sqrt(l2Norm));
	}
}
