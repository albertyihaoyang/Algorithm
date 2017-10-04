package com.yyh;

public class Prime {

	public static void main(String[] args) {
		int i = 99;
		boolean flag = true;
		for (int k = 2; k * k < i; i++){
			if (i % k == 0){
				flag = false;
				break;
			}
		}
		System.out.print(flag);
	}

}
