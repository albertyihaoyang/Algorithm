package com.yyh;

public class Test1 {
	// generic method print Array
	public static <E> void printArray(E[] inputArray){
		for (E element : inputArray){
			System.out.printf("%s ", element);
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		Integer[] intArray = {1, 2, 3, 4, 5};
		Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
		Character[] charArray = {'W', 'O', 'R', 'L', 'D'};
		
		printArray(intArray);
		printArray(doubleArray);
		printArray(charArray);
	}
}
