package com.yyh;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 */

public class Solution {

}

class MovingAverage {
    int curSize;
    double total;
    Queue<Integer> queue;
    int size;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        curSize = 0;
        queue = new LinkedList<Integer>();
        total = 0.0;
        this.size = size;
    }
    
    public double next(int val) {
        if (curSize < this.size){
            curSize++;
            queue.offer(val);
            total += val;
            return total / curSize;
        }
        Integer cur = queue.poll();
        if (cur == null) return -1;
        total -= cur;
        total += val;
        queue.offer(val);
        return total / curSize;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */