package com.yyh;
/*
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements that appear twice in this array.
 */
import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while (i < nums.length){
            while (nums[i] != 0 && nums[i] != i + 1){
                int cur = nums[i];
                if (nums[cur - 1] != cur){
                    swap(nums, cur - 1, i);
                } else {
                    nums[i] = 0;
                    res.add(cur);
                }
            }
            i++;
        }
        return res;
    }
    
    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
