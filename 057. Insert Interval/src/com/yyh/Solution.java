package com.yyh;

import java.util.ArrayList;
import java.util.List;

class Interval {
	int start;
	int end;
	Interval() { 
		start = 0;
		end = 0; 
	}
	Interval(int s, int e) {
		start = s; 
		end = e; 
	}
}

public class Solution {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new ArrayList<>();
		int i = 0;
		// add all the intervals ending before newIntervl starts
		while (i < intervals.size() && intervals.get(i).end < newInterval.start){
			res.add(intervals.get(i++));
		}
		while (i < intervals.size() && intervals.get(i).start <= newInterval.end){
			newInterval = new Interval(Math.min(newInterval.start, intervals.get(i).start), Math.max(newInterval.end, intervals.get(i).end));
			i++;
		}
		res.add(newInterval); // add the union of intervals we got
		// add all the rest
		while (i < intervals.size()) res.add(intervals.get(i++));
		return res;
	}
}
