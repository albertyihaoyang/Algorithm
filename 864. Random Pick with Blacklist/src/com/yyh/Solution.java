package com.yyh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given a blacklist B containing unique integers from [0, N), write a function to return a uniform random integer from [0, N) which is NOT in B.

Optimize it such that it minimizes the call to system’s Math.random().
 */
public class Solution {
	int[] blacklist;
    int len;
    int N;
    List<Integer> list = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    
    public Solution(int N, int[] blacklist) {
        this.N = N;
        this.blacklist = blacklist;
        Arrays.sort(blacklist);
        len = blacklist.length;
    }
    
    public int pick() {
        if (len == 0) return (int)(Math.random() * N);
        if (list.size() >= N - len){
            int ind = (int)(Math.random() * (N - len));
            return list.get(ind);
            
        }
        int i = (int)(Math.random() * N);
        while (isIn(i, blacklist)){
            i = (int)(Math.random() * N);
        }
        if (visited.add(i)) list.add(i);
        return i;
    }
    
    private boolean isIn(int i, int[] blacklist){
        int left = 0;
        int right = len - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (blacklist[mid] == i) return true;
            else if (blacklist[mid] > i){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return blacklist[left] == i;
    }
}
