package com.yyh;
//Sort a linked list using insertion sort.

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
	public ListNode insertionSortList(ListNode head) {
		if (head == null){
			return head;
		}
		ListNode helper = new ListNode(0); // new starter of the sorted list
		ListNode cur = head; // the node will be inserted
		ListNode pre = helper; //insert node between pre and pre.next
		ListNode next = null;
		while (cur != null){
			next = cur.next;
			while (pre.next != null && pre.next.val < cur.val){
				pre = pre.next;
			}
			cur.next = pre.next;
			pre.next = cur;
			pre = helper;
			cur = next;
		}
		return helper.next;
	}
}
