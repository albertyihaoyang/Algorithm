package com.yyh;

/*
 * Given a linked list and a target value T, partition it such that all nodes less than T are listed before 
 * the nodes larger than or equal to target value T. The original relative order of the nodes in each of the 
 * two partitions should be preserved.
 */

public class Partition {

	public static void main(String[] args) {
		ListNode N1 = new ListNode(1);
		ListNode N2 = new ListNode(4);
		ListNode N3 = new ListNode(2);
		ListNode N4 = new ListNode(5);
		ListNode N5 = new ListNode(3);
		N1.next = N2;
		N2.next = N3;
		N3.next = N4;
		N4.next = N5;
		ListNodeAPI.printNode(N1);
		System.out.println(" ");
		ListNodeAPI.printNode(partition(N1,3));
	}
	
	public static ListNode partition(ListNode head, int target) {
	    if (head == null) {
	    	return head;
	    }
	    ListNode smallHead = new ListNode(0);
	    ListNode smallTail = smallHead;
	    ListNode largeHead = new ListNode(0);
	    ListNode largeTail = largeHead;
	    while (head != null){
	    	if (head.value < target){
	    		smallTail.next = new ListNode(head.value);
	    		smallTail = smallTail.next;
	    	} else {
	    		largeTail.next = new ListNode(head.value);
	    		largeTail = largeTail.next;
	    	}
	    	head = head.next;
	    }
	    smallTail.next = largeHead.next;
	    return smallHead.next;
	 }
}
