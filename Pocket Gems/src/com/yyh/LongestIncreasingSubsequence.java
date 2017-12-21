package com.yyh;

public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
	
	public int lengthOfLIS1(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++){
            int j = 0, k = max;
            while (j < k){
            	int mid = (j + k) / 2;
            	if (dp[mid] < nums[i]){
            		j = mid + 1;
            	} else {
            		k = mid;
            	}
            }
            dp[j] = nums[i];
            if (j == max) {
            	 max++;
            }
        }
        return max;
    }
}
