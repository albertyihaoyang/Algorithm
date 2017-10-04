package com.yyh;
import java.util.*;
//Given a string, find the length of the longest substring without repeating characters.
public class LengthOfLongestSubstring {
	
	public static void main(String[] args){
		LengthOfLongestSubstring my = new LengthOfLongestSubstring();
		System.out.println(my.lengthOfLongestSubstring("pwwkew"));
	}
	
	public int lengthOfLongestSubstring(String s) {
        if (s == null){
            return 0;
        }
        Set<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        int slow = 0;
        int max = 0;
        for (int fast = 0; fast < arr.length; fast++){
            char cur = arr[fast];
            while (set.contains(cur)){
                set.remove(arr[slow++]);
            }
            set.add(cur);
            if (fast - slow + 1 > max){
                max = fast - slow + 1;
            }
        }
        return max;
    }
}
