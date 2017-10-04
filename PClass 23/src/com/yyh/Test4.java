package com.yyh;

public class Test4 {

	public static <E> E findMiddle(E[] array){
		int mid = array.length / 2;
		E midElem = array[mid];
		return midElem;
	}
	
	public static void main(String[] args) {
		String[] array = {"Adam", "Bob", "Cathy"};
		String mid = findMiddle(array);
//		int[] array = {1, 3, 5};
//		int mid = findMiddle(array);
		System.out.println(mid);
	}

}
