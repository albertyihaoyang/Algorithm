package com.yyh;

// Method 2: Using Java's StringBuilder Utility and String's indexof(),
// not using String's replace()...
public class ReplaceWithStringBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "appledogapple";
		String s = "apple";
		String t = "cat";
		System.out.println(replace(input, s, t));
	}
	
	public static String replace(String input, String s, String t){
		// Assumptions: input, s, t are not null, s is not empty
		StringBuilder sb = new StringBuilder();
		// We check if there exists a substring same as s
		// in the substring of input starting at fromIndex
		int fromIndex = 0;
		int matchIndex = input.indexOf(s, fromIndex);
		while (matchIndex != -1) {
			sb.append(input, fromIndex, matchIndex).append(t);
			// Next time we need to start from matchIndex + s.length()
			// to find if we have later matches.
			fromIndex = matchIndex + s.length();
			matchIndex = input.indexOf(s, fromIndex);
		}
		sb.append(input, fromIndex, input.length());
		return sb.toString();
	}
}
