package com.yyh;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Given a list of strings, you need to find the longest uncommon subsequence among them. The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be any subsequence of the other strings.

A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.

The input will be a list of strings, and the output needs to be the length of the longest uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.
 */
public class Solution {
	public int findLUSlength(String[] strs) {
        Map<String, Integer> subseqFreq = new HashMap<>();
        for (String s : strs){
            for (String subSeq : getSubseq(s)){
                subseqFreq.put(subSeq, subseqFreq.getOrDefault(subSeq, 0) + 1);
            }
        }
        int longest = -1;
        for (Map.Entry<String, Integer> en : subseqFreq.entrySet()){
            if (en.getValue() == 1){
                longest = Math.max(longest, en.getKey().length());
            }
        }
        return longest;
    }
	
	private static Set<String> getSubseq(String s){
        Set<String> res = new HashSet<>();
        if (s.length() == 0){
            res.add("");
            return res;
        }
        Set<String> subRes = getSubseq(s.substring(1));
        res.addAll(subRes);
        for (String seq : subRes){
            res.add(s.charAt(0) + seq);
        }
        return res;
    }
}
