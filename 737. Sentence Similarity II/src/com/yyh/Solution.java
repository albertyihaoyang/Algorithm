package com.yyh;

import java.util.HashMap;
import java.util.Map;

/*
 * Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar.

For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar, if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].

Note that the similarity relation is transitive. For example, if "great" and "good" are similar, and "fine" and "good" are similar, then "great" and "fine" are similar.

Similarity is also symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.

Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though there are no specified similar word pairs.

Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].
 */
public class Solution {
	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length){
            return false;
        }
        if (words1.length == 0){
            return true;
        }
        Map<String, String> map = new HashMap<>();
        for (String[] pair : pairs){
            String word1 = pair[0];
            String word2 = pair[1];
            if (!map.containsKey(word1)){
                map.put(word1, word1);
            }
            if (!map.containsKey(word2)){
                map.put(word2, word2);
            }
            setP(map, word1, word2);
        }
        for (int i = 0; i < words1.length; i++){
            String word1 = words1[i];
            String word2 = words2[i];
            String p1 = getP(word1, map);
            String p2 = getP(word2, map);
            if (!p1.equals(p2)){
                return false;
            }
        }
        return true;
    }
    
    private String getP(String word, Map<String, String> map){
        if (!map.containsKey(word)){
            return word;
        }
        while (word != map.get(word)){
            word = map.get(word);
        }
        return word;
    }
    
    private void setP(Map<String, String> map, String w1, String w2){
        String p1 = getP(w1, map);
        String p2 = getP(w2, map);
        map.put(p1, p2);
    }
}
