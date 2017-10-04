package com.yyh;

/*
 * Check if a given linked list has a cycle. Return true if it does, otherwise return false.
 */

public class HasCycle {

	public static void main(String[] args) {
		ListNode N1 = new ListNode(1);
		ListNode N2 = new ListNode(2);
		ListNode N3 = new ListNode(3);
		ListNode N4 = new ListNode(4);
		N1.next = N2;
		N2.next = N3;
		N3.next = N4;
		N4.next = N1;
		//ListNodeAPI.printNode(N1);
		System.out.println(" ");
		System.out.println(hasCycle(N1));
	}
	
	public static boolean hasCycle(ListNode head) {
	    if (head == null || head.next == null){
	    	return false;
	    }
	    ListNode slowNode = head;
	    ListNode fastNode = head;
	    while (fastNode.next != null && fastNode.next.next != null){
	    	slowNode = slowNode.next;
	    	fastNode = fastNode.next.next;
	    	if (fastNode == slowNode){
	    		return true;
	    	}
	    }
	    return false;
	 }

}
