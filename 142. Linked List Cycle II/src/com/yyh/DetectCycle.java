package com.yyh;

public class DetectCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DetectCycle my = new DetectCycle();
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
		System.out.println(my.hasCycle(N1));
	}

	public boolean hasCycle(ListNode head) {
        if (head == null) {
        	return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
        	fast = fast.next;
        	if (fast == slow){
        		return true;
        	}
        	fast = fast.next;
        	if (fast == slow){
        		return true;
        	}
        	slow = slow.next;
        }
        return false;
    }
}
