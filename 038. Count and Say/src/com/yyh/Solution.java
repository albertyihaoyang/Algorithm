package com.yyh;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.
 */
public class Solution {
	public String countAndSay(int n) {
        if (n <= 0) return "";
        Queue<Integer> cur = new ArrayDeque<>();
        cur.offer(1);
        for (int i = 2; i <= n; i++){
            cur = next(cur);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : cur){
            sb.append(i);
        }
        return sb.toString();
    }
    
    private Queue<Integer> next(Queue<Integer> cur){
        Queue<Integer> res = new ArrayDeque<>();
        int num = cur.poll();
        int count = 1;
        while (!cur.isEmpty()){
            int numCur = cur.poll();
            if (numCur != num){
                res.offer(count);
                res.offer(num);
                num = numCur;
                count = 1;
            } else {
                count++;
            }
        }
        res.offer(count);
        res.offer(num);
        return res;
    }
}
