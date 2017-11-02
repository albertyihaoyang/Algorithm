package com.yyh;
// There are 1000 buckets, one and only one of them contains poison, the rest are filled with water. 
// They all look the same. If a pig drinks that poison it will die within 15 minutes. What is the minimum amount of pigs you need to figure out which bucket contains the poison within one hour.
public class Solution {
	public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int test = minutesToTest / minutesToDie + 1;
        int cur = 1;
        int res = 0;
        while (cur < buckets){
            cur *= test;
            res++;
        }
        return res;
    }
}
