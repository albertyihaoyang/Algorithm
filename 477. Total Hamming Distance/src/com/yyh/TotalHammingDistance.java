package com.yyh;

/*
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Now your job is to find the total Hamming distance between all pairs of the given numbers.
 */
public class TotalHammingDistance {
	public static void main(String[] args){
		TotalHammingDistance mySol = new TotalHammingDistance();
		System.out.println(mySol.totalHammingDistance(new int[]{4, 14, 2}));
	}
	
	public int totalHammingDistance(int[] nums) {
        int result = 0;
        for (int a = 0; a < 32; a++){
            int n = 0;
            for (int num : nums){
            	n += ((num >> a) & 1);
            }
            result += n * (nums.length - n);
        }
        return result;
    }
	
}
