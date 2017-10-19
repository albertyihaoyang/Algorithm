package com.yyh;

import java.util.ArrayList;
import java.util.List;

/*
 * You are playing the following Flip Game with your friend: 
 * Given a string that contains only these two characters: + and -, 
 * you and your friend take turns to flip two consecutive "++" into "--". 
 * The game ends when a person can no longer make a move and therefore the other person will be the winner.
 * Write a function to compute all possible states of the string after one valid move.
 */
public class Solution {
	public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() <= 1){
            return res;
        }
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length() - 1; i++){
        	if (arr[i] == arr[i + 1]){
        		if (arr[i] == '+'){
        			arr[i] = '-'; arr[i + 1] = '-';
        			res.add(new String(arr));
        			arr[i] = '+'; arr[i + 1] = '+';
        		}
        	}
        }
        return res;
    }
}
