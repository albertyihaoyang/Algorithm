package com.yyh;
import java.util.*;
/*
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. 
 * No two characters may map to the same character but a character may map to itself.
 */
public class WordPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordPattern mySol = new WordPattern();
		System.out.println(mySol.wordPattern("abba", "dog cat cat dog"));
		System.out.println(mySol.wordPattern("abba", "dog cat cat fish"));
		System.out.println(mySol.wordPattern("aaaa", "dog cat cat dog"));
		System.out.println(mySol.wordPattern("abba", "dog dog dog dog"));
		
	}

	public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> tSet = new HashSet<>();
        char[] pArr = pattern.toCharArray();
        char[] sArr = str.toCharArray();
        List<String> strList = new ArrayList<>();
        int slow = 0;
        for (int fast = 0; fast < sArr.length; fast++){
        	if (sArr[fast] == ' '){
        		strList.add(new String(sArr, slow, fast - slow));
        		slow = fast + 1;
        	}
        }
        strList.add(new String(sArr, slow, sArr.length - slow));
        String[] strArr = new String[strList.size()];
        strList.toArray(strArr);
        if (pArr.length != strArr.length){
        	return false;
        }
        for (int i = 0; i < pArr.length; i++){
        	Character sChar = pArr[i];
        	String strString = strArr[i];
        	String Val = map.get(sChar);
        	if (Val == null){
        		if (!tSet.contains(strString)){
        			map.put(sChar, strString);
        			tSet.add(strString);
        		} else {
        			return false;
        		}
        	} else if (Val.equals(strString)){
        		continue;
        	} else {
        		return false;
        	}
        }
        return true;
    }
}
