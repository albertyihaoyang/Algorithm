package com.yyh;
// Given a linked list, swap every two adjacent nodes and return its head.
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { 
		val = x; 
	}
}

public class SwapPairsRec {
	public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
