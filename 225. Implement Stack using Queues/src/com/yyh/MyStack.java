package com.yyh;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * Implement the following operations of a stack using queues.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
 */
public class MyStack {
Queue<Integer> cur;
    
    /** Initialize your data structure here. */
    public MyStack() {
        cur = new ArrayDeque<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        cur.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Queue<Integer> tmp = new ArrayDeque<>();
        if (cur.size() == 1){
            return cur.poll();
        }
        while (cur.size() > 1){
            tmp.offer(cur.poll());
        }
        int res = cur.poll();
        cur = tmp;
        return res;
    }
    
    /** Get the top element. */
    public int top() {
        if (cur.size() == 1){
            return cur.peek();
        }
        Queue<Integer> tmp = new ArrayDeque<>();
        while (cur.size() > 1){
            tmp.offer(cur.poll());
        }
        int res = cur.poll();
        tmp.offer(res);
        cur = tmp;
        return res;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return cur.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */