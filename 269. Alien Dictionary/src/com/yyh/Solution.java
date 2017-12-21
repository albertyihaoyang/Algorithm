package com.yyh;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
	public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        String res = "";
        for (String word: words){
            for (char c: word.toCharArray()){
                degree.put(c, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++){
            String s1 = words[i];
            String s2 = words[i + 1];
            for (int j = 0; j < Math.min(s1.length(), s2.length()); j++){
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                if (c1 != c2){
                    Set<Character> set = map.getOrDefault(c1, new HashSet<>());
                    if (set.add(c2)){
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q = new LinkedList<>();
        for (char c : degree.keySet()){
            if (degree.get(c) == 0){
                q.offer(c);
            }
        }
        while (!q.isEmpty()){
            char c = q.poll();
            res += c;
            if (map.containsKey(c)){
                for (char c2: map.get(c)){
                    degree.put(c2, degree.get(c2) - 1);
                    if (degree.get(c2) == 0){
                        q.offer(c2);
                    }
                }
            }
        }
        if (res.length() != degree.size()){
            return "";
        }
        return res;
    }
}
