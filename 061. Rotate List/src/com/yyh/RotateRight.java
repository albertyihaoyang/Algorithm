package com.yyh;
//Given a list, rotate the list to the right by k places, where k is non-negative.
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x; 
		}
}
public class RotateRight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateRight my = new RotateRight();
		ListNode L1 = new ListNode(1);
		ListNode L2 = new ListNode(2);
		ListNode L3 = new ListNode(3);
		ListNode L4 = new ListNode(4);
		ListNode L5 = new ListNode(5);
		L1.next = L2;
		L2.next = L3;
		L3.next = L4;
		L4.next = L5;
		my.print(L1);
		System.out.println();
		my.print(my.rotateRight(L1, 2));
	}

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        int end = 1;
        while (cur.next != null){
            cur = cur.next;
            end++;
        }
        if (k % end == 0){
            return head;
        }
        k = end - (k % end);
        ListNode newPre = head;
        while (k > 1){
            newPre = newPre.next;
            k--;
        }
        ListNode newHead = newPre.next;
        newPre.next = null;
        cur.next = head;
        return newHead;
    }
	
	public void print(ListNode head){
		ListNode cur = head;
		while (cur != null){
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
	}
}
