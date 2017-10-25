package com.yyh;
/*
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or 
 * more than two continuous 'L' (late).
 */
public class Solution {
	public boolean checkRecord(String s) {
		return !s.matches(".*LLL.*|.*A.*A.*");
    }
}
