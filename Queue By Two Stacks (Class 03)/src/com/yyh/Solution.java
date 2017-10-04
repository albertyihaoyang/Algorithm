package com.yyh;
import java.util.*;

/*
 * Java: Implement a queue by using two stacks. The queue should provide size(), isEmpty(), offer(), poll() 
 * and peek() operations. When the queue is empty, poll() and peek() should return null.
 * 
 * Assumptions
 * 	The elements in the queue are all Integers.
 * 	size() should return the number of elements buffered in the queue.
 *  isEmpty() should return true if there is no element buffered in the queue, false otherwise.
 */

public class Solution {
	private LinkedList<Integer> in;
	private LinkedList<Integer> out;
	
	public Solution() {
		in = new LinkedList<Integer>();
		out = new LinkedList<Integer>();
	}

	public Integer poll() {
		move();
		return out.pollFirst();
	}
  
	public void offer(int element) {
		in.offerFirst(element);
 	}
  
	public Integer peek() {
		move();
		return out.peekFirst();
	}
  
	public void move(){
	  if (out.isEmpty()){
		  while (!in.isEmpty()) {
			  out.offerFirst(in.pollFirst());
		  }
	  }
	}
  
	public int size() {
		return in.size() + out.size();
	}
  
	public boolean isEmpty() {
		return in.size() == 0 && out.size() == 0;
	}
}
