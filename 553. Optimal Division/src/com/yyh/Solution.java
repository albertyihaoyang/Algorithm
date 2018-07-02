package com.yyh;
/*
 * Given a list of positive integers, the adjacent integers will perform the float division. For example, [2,3,4] -> 2 / 3 / 4.

However, you can add any number of parenthesis at any position to change the priority of operations. 
You should find out how to add parenthesis to get the maximum result, and return the corresponding expression in string format. Your expression should NOT contain redundant parenthesis.
 */
public class Solution {
	public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        if (nums.length == 1) return sb.toString();
        sb.append('/');
        if (nums.length == 2){
            sb.append(nums[1]);
            return sb.toString();
        }
        sb.append('(');
        for (int i = 1; i < nums.length; i++){
            sb.append(nums[i]).append('/');
        }
        sb.setCharAt(sb.length() - 1, ')');
        return sb.toString();
    }
}
