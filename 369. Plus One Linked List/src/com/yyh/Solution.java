package com.yyh;
/*
 * Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
 */
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
	public ListNode plusOne(ListNode head) {
        if (head == null) return null;
        if (head.val == 0){
            head.val = 1;
            return head;
        }
        int add = helper(head);
        if (add == 0){
            return head;
        } else {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
    }
    
    public int helper(ListNode head){
        if (head.next == null){
            head.val += 1;
            if (head.val == 10){
                head.val = 0;
                return 1;
            } else return 0;
        }
        head.val += helper(head.next);
        if (head.val == 10){
                head.val = 0;
                return 1;
        }
        return 0;
    }
}
