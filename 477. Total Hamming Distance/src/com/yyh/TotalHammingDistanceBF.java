package com.yyh;

public class TotalHammingDistanceBF {
	public int totalHammingDistance(int[] nums) {
        int result = 0;
        for (int a = 0; a < nums.length; a++){
            for (int b = a + 1; b < nums.length; b++){
                result += hammingDistance(nums[a], nums[b]);
            }
        }
        return result;
    }
	
	private int hammingDistance(int a, int b){
        int dif = a ^ b;
        int result = 0;
        while (dif > 0) {
            if ((dif & 1) > 0){
                result++;
            }
            dif >>= 1;
        }
        return result;
    }
}
