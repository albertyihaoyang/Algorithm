package com.yyh;
/*
 * Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.
 * Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered 
 * by those heaters.
 * So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.
 * Note:
 * Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 * Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 * As long as a house is in the heaters' warm radius range, it can be warmed.
 * All the heaters follow your radius standard and the warm radius will the same.
 */

import java.util.Arrays;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = Integer.MIN_VALUE;
        for (int house : houses){
            res = Math.max(res, helper(house, heaters));
        }
        return res;
    }
    
    private int helper(int house, int[] heaters){
        int l = 0, r = heaters.length - 1;
        if (house <= heaters[0]){
            return heaters[0] - house;
        }
        if (house >= heaters[r]){
            return house - heaters[r];
        }
        while (l + 1 < r){
            int mid = l + (r - l) / 2;
            if (heaters[mid] == house){
                return 0;
            } else if (heaters[mid] > house){
                r = mid;
            } else {
                l = mid;
            }
        }
        return Math.min(heaters[r] - house, house - heaters[l]);
    }
                           
                         
}
