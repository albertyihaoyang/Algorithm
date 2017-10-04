package com.yyh;

import java.util.Arrays;

/*
 * Given a 2D matrix that contains integers only, which each row is sorted in an ascending order. 
 * The first element of next row is larger than (or equal to) the last element of previous row.
 * 
 * Given a target number, returning the position that the target locates within the matrix. 
 * If the target number does not exist in the matrix, return {-1, -1}.
 */
public class Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{1, 2, 3}, {4, 5, 7}, {8, 9, 10}};
		int target = 7;
		System.out.println(Arrays.toString(search(a, target)));
	}
	
	public static int[] search(int[][] matrix, int target){
		if (matrix == null || matrix.length == 0) {
			return new int[] {-1, -1};
		}
		int size = matrix.length * matrix[0].length;
		int start = 0, end = size - 1;
		while (start <= end){
			int mid = start + (end - start)/2;
			int mid_x = mid / matrix[0].length;
			int mid_y = mid % matrix[0].length;
			if (matrix[mid_x][mid_y] == target) {
				return new int[] {mid_x,mid_y};
			} else if (matrix[mid_x][mid_y] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return new int[] {-1, -1};
	}
}
