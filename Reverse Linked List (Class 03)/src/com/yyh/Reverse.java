package com.yyh;

/*
 * Reverse a singly-linked list.
 * Examples
 * 	L = null, return null
 * 	L = 1 -> null, return 1 -> null
 * 	L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null
 */
 
public class Reverse {
	public static void main(String[] args){
		ListNode l1 = new ListNode (1);
		ListNode l2 = new ListNode (2);
		ListNode l3 = new ListNode (3);
		l1.next = l2;
		l2.next = l3;
		System.out.println(l3);
		System.out.println(reverse(l1));
	}
	
	public static ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = head;
		ListNode next = head;
		ListNode pre = null;
		while (cur != null){
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
}
