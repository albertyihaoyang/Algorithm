package com.yyh;

public class MatrixSum {

	public static void main(String[] args) {
		int [][] a = {{1,3,4},{3,4,6},{3,-2,-1}};
		int [][] b = {{1,3,4},{3,4,6},{3,-2,-1}};
		if (a.length != b.length || a[0].length!=b[0].length){
			System.out.println("Matrix Not match!");
		} else {
			int [][] nm = new int [a.length][a[0].length];
			for (int i = 0; i < a.length; i++){
				for (int j = 0; j < a[0].length; j++){
					nm[i][j] = a[i][j] + b[i][j];
				}
			}
			for (int i = 0; i < a.length; i++){
				for (int j = 0; j < a[0].length; j++){
					System.out.print(nm[i][j]+"\t");
				}
				System.out.println("");
			}
		}
	}

}
