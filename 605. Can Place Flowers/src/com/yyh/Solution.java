package com.yyh;
/*
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. 
 * However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), 
 * and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 */
public class Solution {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int can = 0;
        int i = 0;
        while (i < flowerbed.length){
            if (flowerbed[i] == 1){
                i++;
            } else {
                int head = i;
                int cur = 0;
                while (i < flowerbed.length && flowerbed[i] == 0){
                    cur++;
                    i++;
                }
                if (i == flowerbed.length && head == 0) can += (cur + 1) / 2;
                else if (i == flowerbed.length || head == 0) can += cur / 2;
                else can += (cur - 1) / 2;
            }
        }
        return can >= n;
    }
}
