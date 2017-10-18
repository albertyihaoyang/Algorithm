package com.yyh;
/*
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, 
 * judge if this robot makes a circle, which means it moves back to the original place.
 * The move sequence is represented by a string. And each move is represent by a character. 
 * The valid robot moves are R (Right), L (Left), U (Up) and D (down).
 * The output should be true or false representing whether the robot makes a circle.
 */
public class Solution {
	public boolean judgeCircle(String moves) {
		if (moves.length() % 2 == 1){
			return false;
		}
		int[] step = new int[4];
		for (char c : moves.toCharArray()){
			switch (c){
				case 'U': step[0]++; break;
				case 'D': step[1]++; break;
				case 'R': step[2]++; break;
				case 'L': step[3]++; break;
				default: return false;
			}
		}
		return step[0] == step[1] && step[2] == step[3];
		
	}
}
