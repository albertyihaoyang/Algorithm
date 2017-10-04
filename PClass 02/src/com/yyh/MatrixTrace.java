package com.yyh;

public class MatrixTrace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] a = {{1,3,4},{3,4,6},{3,-2,-1}};
		if (a.length != a[0].length){
			System.out.println("Not square matrix!");
		} else {
			int sum = 0;
			for (int i = 0; i < a.length; i++){
				sum += a[i][i];
			}
			System.out.println(sum);
		}
	}

}
