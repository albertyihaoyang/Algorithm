package com.yyh;
/*
 * S and T are strings composed of lowercase letters. In S, no letter occurs more than once.
 * S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. 
 * More specifically, if x occurs before y in S, then x should occur before y in the returned string.
 * Return any permutation of T (as a string) that satisfies this property.
 */
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
	public String customSortString(String S, String T) {
        int[] arr = new int[26];
        for (int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);
            arr[ch - 'a'] = i + 1;
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>(){
            @Override
            public int compare(Character a, Character b){
                return arr[a - 'a'] - arr[b - 'a'];
            }
        });
        for (char ch: T.toCharArray()){
            pq.offer(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            sb.append(pq.poll());
        }
        return sb.toString();
    }
}
