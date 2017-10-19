package com.yyh;

import java.util.Arrays;

// Given scores of N athletes, find their relative ranks and the people with the top three highest scores, 
// who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
public class Solution {
	public String[] findRelativeRanks(int[] nums) {
int[][] pair = new int[nums.length][2];
        
        for (int i = 0; i < nums.length; i++) {
            pair[i][0] = nums[i];
            pair[i][1] = i;
        }
        
        Arrays.sort(pair, (a, b) -> (b[0] - a[0]));
        
        String[] result = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[pair[i][1]] = "Gold Medal";
            }
            else if (i == 1) {
                result[pair[i][1]] = "Silver Medal";
            }
            else if (i == 2) {
                result[pair[i][1]] = "Bronze Medal";
            }
            else {
                result[pair[i][1]] = (i + 1) + "";
            }
        }

        return result;
	}
}
