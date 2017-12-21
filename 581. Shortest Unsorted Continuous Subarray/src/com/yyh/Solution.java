package com.yyh;
/*
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, 
 * then the whole array will be sorted in ascending order, too.
 * You need to find the shortest such subarray and output its length.
 */
class Solution {
	public static void main(String[] args){
		Solution my = new Solution();
		int[] A = new int[]{2, 6, 4, 8, 10, 9, 15};
		System.out.println(my.findUnsortedSubarray(A));
	}
	
    public int findUnsortedSubarray(int[] A) {
        int n = A.length, beg = -1, end = -2, min = A[n - 1], max = A[0];
        for (int i = 1; i < n; i++){
            max = Math.max(max, A[i]);
            min = Math.min(min, A[n - 1 - i]);
            if (A[i] < max){
                end = i;
            }
            if (A[n - 1 - i] > min){
                beg = n - 1 - i;
            }
        }
        return end - beg + 1;
    }
}
