package com.yyh;
/*
 * Now you are given a string S, which represents a software license key which we would like to format. The string S is composed of alphanumerical characters and dashes. The dashes split the alphanumerical characters within the string into groups. (i.e. if there are M dashes, the string is split into M+1 groups). The dashes in the given string are possibly misplaced.

We want each group of characters to be of length K (except for possibly the first group, which could be shorter, but still must contain at least one character). To satisfy this requirement, we will reinsert dashes. Additionally, all the lower case letters in the string must be converted to upper case.

So, you are given a non-empty string S, representing a license key to format, and an integer K. And you need to return the license key formatted according to the description above.
 */
public class Solution {
	public String licenseKeyFormatting(String S, int K) {
		if (S.length() == 0){
			return S;
		}
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = S.length() - 1; i >= 0; i--){
			if (S.charAt(i) == '-'){
				continue;
			}
			char ch = S.charAt(i);
			if (ch >= 'a' && ch <= 'z'){
				ch = (char)(ch - 'a' + 'A');
			}
			sb.append(ch);
			count++;
			if (count == K){
				count = 0;
				sb.append('-');
			}
		}
		if (sb.length() == 0){
			return sb.toString();
		}
		if (sb.charAt(sb.length() - 1) == '-'){
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.reverse().toString();
	}
}
