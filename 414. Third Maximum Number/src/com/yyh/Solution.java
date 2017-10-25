package com.yyh;
/*
 * Given a non-empty array of integers, return the third maximum number in this array. 
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 */
public class Solution {
	public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (int i : nums){
            if (max1 == null || i > max1){
                max3 = max2;
                max2 = max1;
                max1 = i;
            } else if (i == max1){
                continue;
            } else if (max2 == null || i > max2){
                max3 = max2;
                max2 = i;
            } else if (i == max2){
                continue;
            } else if (max3 == null || i > max3){
                max3 = i;
            }
        }
        return max3 == null? max1 : max3;
    }
}
