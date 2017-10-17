package com.yyh;
/*
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * find the minimum number of conference rooms required.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}

public class Solution {
	public int minMeetingRooms(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval i1, Interval i2){
				if (i1.start == i2.start){
					return 0;
				}
				return i1.start < i2.start ? -1 : 1;
			}
		});
		PriorityQueue<Interval> minHeap = new PriorityQueue<>(new Comparator<Interval>(){
			@Override
			public int compare(Interval i1, Interval i2){
				if (i1.end == i2.end){
					return 0;
				}
				return i1.end < i2.end ? -1 : 1;
			}
		});
		for (Interval i : intervals){
			if (minHeap.isEmpty() || minHeap.peek().end > i.start){
				minHeap.add(i);
			} else {
				minHeap.poll();
				minHeap.add(i);
			}
		}
		return minHeap.size();
	}
}
