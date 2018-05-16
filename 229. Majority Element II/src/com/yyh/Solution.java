package com.yyh;

import java.util.ArrayList;
import java.util.List;

// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
public class Solution {
	public List<Integer> majorityElement(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        int[][] res = new int[2][2];
        for (int i: nums){
            if (res[0][0] == i){
                res[0][1]++;
            } else if (res[1][0] == i){
                res[1][1]++;
            } else if (res[0][1] == 0){
                res[0][0] = i;
                res[0][1] = 1;
            } else if (res[1][1] == 0){
                res[1][0] = i;
                res[1][1] = 1;
            } else {
                res[0][1]--;
                res[1][1]--;
            }
        }
        for (int i = 0; i < 2; i++){
            int count = 0;
            if (res[i][1] > 0){
                int cur = res[i][0];
                for (int n: nums){
                    if (cur == n){
                        count++;
                    }
                }
                if (count > nums.length / 3){
                    ret.add(cur);
                }
            }
        }
        return ret;
    }
}
