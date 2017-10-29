package com.yyh;

import java.util.ArrayList;
import java.util.List;

/*
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.
 */
public class Solution {
	public String getPermutation(int n, int k) {
        int[] fac = new int[n + 1];
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            nums.add(i);
        }
        fac[0] = 1;
        for (int i = 1; i < fac.length; i++){
            fac[i] = fac[i - 1] * i;
        }
        StringBuilder res = new StringBuilder();
        k--;
        for(int i = 1; i <= n; i++){
            int index = k / fac[n - i];
            res.append(String.valueOf(nums.get(index)));
            nums.remove(index);
            k -= index * fac[n - i];
        }
        return res.toString();
    }
}
