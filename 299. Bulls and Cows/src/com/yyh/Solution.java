package com.yyh;

import java.util.HashMap;
import java.util.Map;

/*
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. 
 * Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number 
 * exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position 
 * (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
 */
public class Solution {
	public String getHint(String secret, String guess) {
		int len = secret.length();
		Map<Character, Integer> map = new HashMap<>();
		int a = 0;
		int b = 0;
		for (int i = 0; i < len; i++){
			char ch = secret.charAt(i);
			if (ch == guess.charAt(i)){
				a++;
			} else {
				map.put(ch, map.getOrDefault(ch, 0) + 1);
			}
		}
		for (int i = 0; i < len; i++){
			char ch = guess.charAt(i);
			if (ch != secret.charAt(i)){
				Integer cur = map.get(ch);
				if (cur != null && cur > 0){
					cur--;
					b++;
					map.put(ch, cur);
				}
			}
		}
		return a + "A" + b + "B";
	}
}
