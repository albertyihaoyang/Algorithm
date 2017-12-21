package com.yyh;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar.
 * For example, "great acting skills" and "fine drama talent" are similar, if the similar word pairs are pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]].

Note that the similarity relation is not transitive. For example, if "great" and "fine" are similar, and "fine" and "good" are similar, "great" and "good" are not necessarily similar.

However, similarity is symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.

Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though there are no specified similar word pairs.

Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].
 */
class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length){
            return false;
        }
        if (words1.length == 0){
            return true;
        }
        Map<String, Set<String>> map = new HashMap<>();
        for (String[] pair : pairs){
            Set<String> set = map.get(pair[0]);
            if (set == null){
                set = new HashSet<String>();
            }
            set.add(pair[1]);
            map.put(pair[0], set);
            set = map.get(pair[1]);
            if (set == null){
                set = new HashSet<String>();
            }
            set.add(pair[0]);
            map.put(pair[1], set);
        }
        for (int i = 0; i < words1.length; i++){
            Set<String> set = map.get(words1[i]);
            if (words1[i].equals(words2[i])){
                continue;
            }
            if (set == null || !set.contains(words2[i])){
                return false;
            }
        }
        
        return true;
    }
}