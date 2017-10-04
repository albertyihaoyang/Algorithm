package com.yyh;

public class DeleteNode {
	public static void main(String[] args){
		DeleteNode my = new DeleteNode();
		ListNode L1 = new ListNode(0);
		ListNode L2 = new ListNode(1);
		ListNode L3 = new ListNode(0);
		L1.next = L2;
		L2.next = L3;
		ListNodeAPI.printNode(L1);
		System.out.println();
		my.deleteNode(L1);
		ListNodeAPI.printNode(L1);
	}
	public void deleteNode(ListNode node) {
        ListNode cur = node;
        cur.val = cur.next.val;
        while (cur.next.next != null){
        	cur.val = cur.next.val;
        	cur = cur.next;
        }
        cur.val = cur.next.val;
        cur.next = null;
    }
}
