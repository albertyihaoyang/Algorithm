package com.yyh;
import java.util.*;
// Reverse digits of an integer.
public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reverse my = new Reverse();
		System.out.println(my.reverse(-123));
	}
	
	public int reverse(int x) {
        Deque<Integer> deque = new ArrayDeque<>();
        while (x != 0){
            int val = x % 10;
            deque.offerFirst(val);
            x /= 10;
        }
        double newX = 0;
        while (!deque.isEmpty()) {
        	newX *= 10;
        	newX += deque.pollLast();
        }
        if (newX > (double)Integer.MAX_VALUE || newX < (double)Integer.MIN_VALUE){
        	return 0;
        }
        return (int)newX;
    }

}
