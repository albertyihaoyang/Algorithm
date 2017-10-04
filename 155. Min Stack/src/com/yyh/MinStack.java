package com.yyh;
import java.util.*;
public class MinStack {

	Deque<Integer> stack;
    Deque<Integer> minStack;
    int global = Integer.MAX_VALUE;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<>();;
        minStack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        stack.offerFirst(x);
        if (minStack.isEmpty() || minStack.peekFirst() > x){
            minStack.offerFirst(x);
        } else {
            minStack.offerFirst(minStack.peekFirst());
        }
    }
    
    public void pop() {
        if (!stack.isEmpty()){
            stack.pollFirst();
            minStack.pollFirst();
        }
    }
    
    public int top() {
        if (!stack.isEmpty()){
            return stack.peekFirst();
        }
        return 0;
    }
    
    public int getMin() {
        if (!minStack.isEmpty()){
            return minStack.peekFirst();
        }
        return 0;
    }
}
