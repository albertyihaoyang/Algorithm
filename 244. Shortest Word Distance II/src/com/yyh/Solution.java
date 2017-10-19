package com.yyh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * This is a follow up of Shortest Word Distance. 
 * The only difference is now you are given the list of words and your method will be called repeatedly many times 
 * with different parameters. How would you optimize it?
 * Design a class which receives a list of words in the constructor, 
 * and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.
 */
public class Solution {

}

class WordDistance {
	String[] words;
	Map<String, List<Integer>> map = new HashMap<>();
    public WordDistance(String[] words) {
        this.words = words;
        for (int i = 0; i < words.length; i++){
        	List<Integer> cur = map.get(words[i]);
        	if (cur == null){
        		cur = new ArrayList<>();
        		cur.add(i);
        		map.put(words[i], cur);
        	} else cur.add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        int i1 = 0; int i2 = 0;
        while (i1 < l1.size() && i2 < l2.size()){
        	if (l1.get(i1) > l2.get(i2)){
        		res = Math.min(res, l1.get(i1) - l2.get(i2));
        		i2++;
        	} else {
        		res = Math.min(res, l2.get(i2) - l1.get(i1));
        		i1++;
        	}
        }
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */