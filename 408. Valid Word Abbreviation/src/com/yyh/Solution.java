package com.yyh;
// Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.
public class Solution {
	public boolean validWordAbbreviation(String word, String abbr) {
        if (word.length() == 0 && abbr.length() == 0) return true;
        if (word.length() == 0 || abbr.length() == 0) return true;
        int w = 0;
        int a = 0;
        while (w < word.length() && a < abbr.length()){
            char curW = word.charAt(w);
            char curA = abbr.charAt(a);
            if (curW == curA){
                w++;
                a++;
                continue;
            } else if (curA <= '0' || curA > '9'){
                return false;
            } else {
                int res = 0;
                while (curA >= '0' && curA <='9'){
                    res = res * 10 + (curA - '0');
                    a++;
                    if (a == abbr.length()) break;
                    curA = abbr.charAt(a);
                }
                w += res;
            }
        }
        return w == word.length() && a == abbr.length();
    }
}
