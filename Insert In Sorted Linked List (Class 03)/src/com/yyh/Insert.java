package com.yyh;

/*
 * Insert a value in a sorted linked list.
 */

public class Insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode N1 = new ListNode(1);
		ListNode N2 = new ListNode(2);
		ListNode N3 = new ListNode(4);
		ListNode N4 = new ListNode(5);
		N1.next = N2;
		N2.next = N3;
		N3.next = N4;
		ListNodeAPI.printNode(N1);
		System.out.println(" ");
		ListNodeAPI.printNode(insert(N1, 3));
	}

	public static ListNode insert(ListNode head, int value) {
		ListNode newNode = new ListNode(value);
		if (head == null) {
			return newNode;
		} else if (head.value >= value) {
			newNode.next = head;
			return newNode;
		}
		ListNode pre = head;
		while (pre.next != null && pre.next.value < value) {
			pre = pre.next;
		}
		if (pre.next == null) {
			pre.next = newNode;
			return head;
		} else {
			newNode.next = pre.next;
			pre.next = newNode;
			return head;
		}
	}
}
