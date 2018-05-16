package com.yyh;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
	public int minMutation(String start, String end, String[] bank) {
        int res = 0;
        char[] arr = "ACGT".toCharArray();
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        Queue<String> cur = new LinkedList<>();
        cur.add(start);
        while (!cur.isEmpty()){
            if (cur.contains(end)) return res;
            Queue<String> next = new LinkedList<>();
            while (!cur.isEmpty()){
                String curString = cur.poll();
                for (int i = 0; i < curString.length(); i++){
                    char[] curArr = curString.toCharArray();
                    for (int j = 0; j < 4; j++){
                        curArr[i] = arr[j];
                        String newString = new String(curArr);
                        if (set.contains(newString)){
                            set.remove(newString);
                            next.offer(newString);
                        }
                    }
                }
            }
            cur = next;
            res++;
        }
        return -1;
    }
}
