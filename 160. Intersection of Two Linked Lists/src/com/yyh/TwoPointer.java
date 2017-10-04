package com.yyh;

public class TwoPointer {
	public static void main(String[] args){
		ListNode L11 = new ListNode(1);
		ListNode L12 = new ListNode(2);
		ListNode L21 = new ListNode(3);
		ListNode L22 = new ListNode(4);
		ListNode L23 = new ListNode(5);
		ListNode L4 = new ListNode(6);
		ListNode L5 = new ListNode(7);
		L11.next = L12;
		L12.next = L4;
		L21.next = L22;
		L22.next = L23;
		L23.next = L4;
		L4.next = L5;
		TwoPointer my = new TwoPointer();
		ListNodeAPI.printNode(L11);
		System.out.println();
		ListNodeAPI.printNode(L21);
		System.out.println();
		System.out.println(my.getIntersectionNode(L11, L21).val);
	}
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        boolean flagA = true;
        while (true){
        	if (curA == curB){
        		return curA;
        	}
        	curA = curA.next;
        	curB = curB.next;
        	if (curA == null && flagA){
        		curA = headB;
        	}
        	if (curB == null){
        		curB = headA;
        	}
        	if (curA == null && !flagA){
        		return null;
        	}
        }
	}
}
