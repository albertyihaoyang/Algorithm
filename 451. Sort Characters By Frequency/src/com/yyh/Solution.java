package com.yyh;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Given a string, sort it in decreasing order based on the frequency of characters.
public class Solution {
	public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>(){
            @Override
            public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2){
                if (e1.getValue() == e2.getValue()) return 0;
                return e1.getValue() > e2.getValue() ? -1: 1; 
            }
        });
        for (Map.Entry<Character, Integer> en: map.entrySet()) pq.offer(en);
        
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            Map.Entry<Character, Integer> en = pq.poll();
            for (int i = 0; i < en.getValue(); i++) sb.append(en.getKey());
        }
        return sb.toString();
    }
}
