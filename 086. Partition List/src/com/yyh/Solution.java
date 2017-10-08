package com.yyh;
/*
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 */

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { 
		val = x; 
	}
}

public class Solution {

	public ListNode partition(ListNode head, int x) {
		ListNode Small = new ListNode(0);
		ListNode Large = new ListNode(0);
		ListNode smallTail = Small;
		ListNode largeTail = Large;
		while (head != null){
			if (head.val < x){
				smallTail.next = head;
				head = head.next;
				smallTail = smallTail.next;
				smallTail.next = null;
			} else {
				largeTail.next = head;
				head = head.next;
				largeTail = largeTail.next;
				largeTail.next = null;
			}
		}
		smallTail.next = Large.next;
		return Small.next;
	}
}
