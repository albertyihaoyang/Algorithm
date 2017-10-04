package com.yyh;
// Reverse a singly linked list.

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class ReverseList {
	public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
