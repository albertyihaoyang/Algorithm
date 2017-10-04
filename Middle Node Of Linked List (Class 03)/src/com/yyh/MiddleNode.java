package com.yyh;
/*
 * Find the middle node of a given linked list.
 */
public class MiddleNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode N1 = new ListNode(1);
		ListNode N2 = new ListNode(2);
		ListNode N3 = new ListNode(3);
		ListNode N4 = new ListNode(4);
		N1.next = N2;
		N2.next = N3;
		N3.next = N4;
		ListNodeAPI.printNode(N1);
		System.out.println(" ");
		ListNodeAPI.printNode(middleNode(N1));
	}
	
	public static ListNode middleNode(ListNode head) {
	    if (head == null){
	    	return null;
	    }
	    ListNode slowNode = head;
	    ListNode fastNode = head;
	    while (fastNode.next != null && fastNode.next.next != null){
	    	slowNode = slowNode.next;
	    	fastNode = fastNode.next.next;
	    }
	    return slowNode;
	  }
}
