package com.yyh;

/*
 * Remove all elements from a linked list of integers that have value val.
 */

public class RemoveElements {
	public ListNode removeElements(ListNode head, int val) {
        if (head == null){
        	return null;
        } else if (head.val == val){
        	return removeElements(head.next, val);
        }
        head.next = removeElements(head.next, val);
        return head;
    }
}
