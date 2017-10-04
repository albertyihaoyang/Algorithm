package com.yyh;

/*
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 */

public class HasCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HasCycle my = new HasCycle();
		ListNode N1 = new ListNode(1);
		ListNode N2 = new ListNode(2);
		ListNode N3 = new ListNode(3);
		ListNode N4 = new ListNode(4);
		N1.next = N2;
		N2.next = N3;
		N3.next = N4;
		N4.next = N1;
		//ListNodeAPI.printNode(N1);
		//System.out.println(" ");
		System.out.println(my.detectCycle(N1));
	}

	public ListNode detectCycle(ListNode head) {
        if (head == null) {
        	return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
        	fast = fast.next.next;
        	slow = slow.next;
        	if (fast == slow){
        		ListNode slow2 = head;
        		while (slow != slow2){
        			slow = slow.next;
        			slow2 = slow2.next;
        		}
        		return slow;
        	}
        }
        return null;
    }
}
