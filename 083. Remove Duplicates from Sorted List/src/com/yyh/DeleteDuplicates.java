package com.yyh;

/*
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 */

public class DeleteDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteDuplicates my = new DeleteDuplicates();
		ListNode L1 = new ListNode(1);
		ListNode L2 = new ListNode(1);
		ListNode L3 = new ListNode(2);
		ListNode L4 = new ListNode(3);
		ListNode L5 = new ListNode(3);
		L1.next = L2;
		L2.next = L3;
		L3.next = L4;
		L4.next = L5;
		ListNodeAPI.printNode(L1);
		System.out.println();
		ListNodeAPI.printNode(my.deleteDuplicates(L1));
	}
	
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
        	return null;
        }
        ListNode cur = head;
        ListNode next = cur;
        int curVal = cur.val;
        while (cur != null){
        	next = next.next;
        	if (next == null){
        		cur.next = null;
        		break;
        	}
        	if (next.val == curVal){
        		continue;
        	} else {
        		cur.next = next;
        		curVal = next.val;
        	}
        	cur = cur.next;
        }
        return head;
    }

}
