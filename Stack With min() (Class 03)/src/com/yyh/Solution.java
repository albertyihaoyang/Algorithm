package com.yyh;
import java.util.LinkedList;

/*
 * Enhance the stack implementation to support min() operation. min() should return 
 * 	the current minimum value in the stack. If the stack is empty, min() should return -1.
 * pop() - remove and return the top element, if the stack is empty, return -1
 * push(int element) - push the element to top
 * top() - return the top element without remove it, if the stack is empty, return -1
 * min() - return the current min value in the stack.
 */

public class Solution {
	private LinkedList<Integer> in;
	private LinkedList<Integer> minStore;
	
	public Solution() {
		in = new LinkedList<Integer>();
		minStore = new LinkedList<Integer>(); 
	}
  
	public int pop() {
	  if (in.isEmpty()) {
		  return -1;
	  } else {
		  minStore.pollFirst();
		  return in.pollFirst();
	  }
	}
  
	public void push(int element) {
	  in.offerFirst(element);
	  if (minStore.isEmpty()) {
		  minStore.offerFirst(element);
	  } else {
		  int globalMin = minStore.peekFirst();
		  if (element < globalMin) {
			  minStore.offerFirst(element);
		  } else {
			  minStore.offerFirst(globalMin);
		  }
	  }
	}
  
	public int top() {
		if (in.isEmpty()) {
			return -1;
		} else {
			return in.peekFirst();
		}
	}
  
	public int min() {
		if (minStore.isEmpty()) {
			return -1;
		} else {
			return minStore.peekFirst();
		}
	}
}

