package com.yyh;

import java.util.List;

/*
 * Given a sequence of words, check whether it forms a valid word square.
 * A sequence of words forms a valid word square if the kth row and column read the exact same string, 
 * where 0 ≤ k < max(numRows, numColumns).
 */
public class Solution {
	public boolean validWordSquare(List<String> words) {
        if (words.size() != words.get(0).length()) return false;
        for (int i = 0; i < words.size(); i++){
            String sI = words.get(i);
        	for (int j = 0; j < sI.length(); j++){
                if (j >= words.size()) return false;
        		String sJ = words.get(j);
        		if (j < sI.length()){
        			if (i >= sJ.length() || sI.charAt(j) != sJ.charAt(i)) return false;
        		} else {
        			if (i < sJ.length()) return false;
        		}
        	}
        }
        return true;
    }
}
