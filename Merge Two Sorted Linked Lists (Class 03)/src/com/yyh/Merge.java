package com.yyh;

/*
 * Merge two sorted lists into one large sorted list.
 */
public class Merge {

	public static void main(String[] args) {
		ListNode N1 = new ListNode(1);
		ListNode N2 = new ListNode(7);
		ListNode N3 = new ListNode(2);
		ListNode N4 = new ListNode(5);
		ListNode N5 = new ListNode(6);
		N1.next = N2;
		N3.next = N4;
		N4.next = N5;
		ListNodeAPI.printNode(N1);
		System.out.println(" ");
		ListNodeAPI.printNode(N3);
		System.out.println(" ");
		ListNodeAPI.printNode(merge(N3,N1));	
	}
	
	public static ListNode merge(ListNode one, ListNode two) {
	    if (one == null && two == null){
	    	return null;
	    }
	    ListNode preNode = new ListNode(-1);
	    ListNode preTail = preNode;
	    ListNode cur1 = one;
	    ListNode cur2 = two;
	    while (cur1 != null && cur2 != null){
	    	if (cur1.value <= cur2.value){
	    		preTail.next = cur1;
	    		cur1 = cur1.next;
	    		preTail = preTail.next;
	    	} else {
	    		preTail.next = cur2;
	    		cur2 = cur2.next;
	    		preTail = preTail.next;
	    	}
	    }
	    if (cur1 == null){
	    	preTail.next = cur2;
	    } else {
	    	preTail.next = cur1;
	    }
	    return preNode.next;
	}
}
