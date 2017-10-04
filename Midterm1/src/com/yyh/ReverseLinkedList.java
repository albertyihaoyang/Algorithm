package com.yyh;

class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int val){
		this.val = val;
		next = null;
	}
} 

public class ReverseLinkedList {
	
	public static void main(String[] args){
		ReverseLinkedList mySol = new ReverseLinkedList();
		ListNode l1 = new ListNode (1);
		ListNode l2 = new ListNode (2);
		ListNode l3 = new ListNode (3);
		l1.next = l2;
		l2.next = l3;
		System.out.println(l3);
		System.out.println(mySol.reverseIter(l1));
		System.out.println(mySol.reverseRec(l1));
	}
	
	// Iterative Method
	// Time Complexity: O(n)/ Space Complexity: O(1)
	public ListNode reverseIter (ListNode head){
		if (head == null || head.next == null) {
			return head;
		}
		// Use three node to maintain the link between nodes when reversing
		ListNode cur = head;
		ListNode next = cur;
		ListNode pre = null;
		while (cur != null){
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}

	// Recursive Method
	// Time Complexity: O(n)/ Space Complexity: O(n)
	public ListNode reverseRec (ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		// Use recursive method to reverse the list with one node shorter
		ListNode newHead = reverseRec(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
	
	
}

