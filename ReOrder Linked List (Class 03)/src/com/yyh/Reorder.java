package com.yyh;

/*
 * Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null 
 * to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null
 */

public class Reorder {

	public static void main(String[] args) {
		ListNode N1 = new ListNode(1);
		ListNode N2 = new ListNode(2);
		ListNode N3 = new ListNode(3);
		ListNode N4 = new ListNode(4);
		ListNode N5 = new ListNode(5);
		N1.next = N2;
		N2.next = N3;
		N3.next = N4;
		N4.next = N5;
		ListNodeAPI.printNode(N1);
		System.out.println(" ");
		ListNodeAPI.printNode(reorder(N1));
	}

	public static ListNode reorder(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}
		ListNode middleNode = midNode(head);
		ListNode newNode = middleNode.next;
		middleNode.next = null;
		newNode = reverse(newNode);
		ListNode reorderHead = combine(head, newNode);
		return reorderHead;
	}

	public static ListNode midNode(ListNode head) {
		ListNode slowNode = head;
		ListNode fastNode = head;
		while (fastNode.next != null && fastNode.next.next != null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
		}
		return slowNode;
	}

	public static ListNode reverse(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		ListNode next = head;
		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}

	public static ListNode combine(ListNode one, ListNode two) {
		ListNode headNode = new ListNode(-1);
		ListNode tailNode = headNode;
		while (one != null && two != null) {
			tailNode.next = one;
			tailNode = tailNode.next;
			one = one.next;
			tailNode.next = two;
			tailNode = tailNode.next;
			two = two.next;
		}
		if (one != null) {
			tailNode.next = one;
		}
		return headNode.next;
	}

}
