package com.yyh;
import java.util.*;
/*
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. 
 * No two characters may map to the same character but a character may map to itself.
 */
public class IsIsomorphic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsIsomorphic mySol = new IsIsomorphic();
		System.out.println(mySol.isIsomorphic("egg", "add"));
		//System.out.println(mySol.isIsomorphic("foo", "bar"));
		System.out.println(mySol.isIsomorphic("ab", "aa"));
		System.out.println(mySol.isIsomorphic("ab", "ca"));
		System.out.println(mySol.isIsomorphic("aa", "ab"));
		
	}

	public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()){
        	return false;
        }
        Map<Character, Character> map = new HashMap<>();
        Set<Character> tSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
        	Character sChar = s.charAt(i);
        	Character tChar = t.charAt(i);
        	Character Val = map.get(sChar);
        	if (Val == tChar){
        		continue;
        	} else if (Val == null && !tSet.contains(tChar)){
        		map.put(sChar, tChar);
        		tSet.add(tChar);
        	} else {
        		return false;
        	}
        }
        return true;
    }
}
