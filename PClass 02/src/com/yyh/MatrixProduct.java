package com.yyh;

public class MatrixProduct {

	public static void main(String[] args) {
		int [][] a = {{1,3,4},{3,4,6},{3,-2,-1}};
		int [][] b = {{1,3,4},{3,4,6},{3,-2,-1}};
		if (a.length != b[0].length || a[0].length!=b.length){
			System.out.println("Matrix Not match!");
		}
		else {
			int [][] nm = new int [a.length][b[0].length];
			for (int i = 0; i < a.length; i++){
				for (int k = 0; k < b[0].length; k++){
					int sum = 0;
					for (int j = 0; j < a[0].length; j++){
						sum = a[i][j] + b[j][k];
					}
					nm[i][k] = sum;
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
