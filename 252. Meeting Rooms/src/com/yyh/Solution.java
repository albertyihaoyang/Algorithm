package com.yyh;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * determine if a person could attend all meetings.
 */
class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}

public class Solution {
	public boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval i1, Interval i2){
				if (i1.start == i2.start){
					return 0;
				}
				return i1.start < i2.start ? -1 : 1;
			}
		});
		for (int i = 1; i < intervals.length; i++){
			if (intervals[i].start < intervals[i - 1].end){
				return false;
			}
		}
		return true;
	}
}
