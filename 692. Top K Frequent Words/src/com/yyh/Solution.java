package com.yyh;
/*
 * Given a non-empty list of words, return the k most frequent elements.
 * Your answer should be sorted by frequency from highest to lowest. 
 * If two words have the same frequency, then the word with the lower alphabetical order comes first.
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
	public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> en1, Map.Entry<String, Integer> en2){
                if (en1.getValue() == en2.getValue()){
                    return -(en1.getKey().compareTo(en2.getKey()));
                }
                return en1.getValue() - en2.getValue();
            }
        });
        for (Map.Entry<String, Integer> en : map.entrySet()){
            pq.offer(en);
            if (pq.size() > k){
                pq.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()){
            res.add(0, pq.poll().getKey());
        }
        return res;
    }
}
