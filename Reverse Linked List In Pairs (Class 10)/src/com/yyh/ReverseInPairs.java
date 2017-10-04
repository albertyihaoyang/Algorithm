package com.yyh;
//Reverse pairs of elements in a singly-linked list.
class ListNode {
	 public int value;
	 public ListNode next;
	 public ListNode(int value) {
		 this.value = value;
		 next = null;
		 }
}

public class ReverseInPairs {
	public ListNode reverseInPairs(ListNode head) {
	    if (head == null || head.next == null){
	      return head;
	    }
	    ListNode next = head.next;
	    head.next = reverseInPairs(next.next);
	    next.next = head;
	    return next;
	}
}
