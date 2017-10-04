package com.yyh;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x; 
		}
}

public class ReverseBetween {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseBetween my = new ReverseBetween();
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
		my.print(my.reverseBetween(L1, 1, 4));
	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
        // 1. Head is null/single node in the link/m,n point to same node
		if (head == null || head.next == null || m == n){
            return head;
        }
		
		// 2. m = 1
        if (m == 1){
        	ListNode mNode = head; 
        	ListNode nPre = head;
        	 while (n-- > 1){
                 nPre = nPre.next;
             }
        	 ListNode nNode = nPre.next;
        	 nPre.next = null;
        	 head = reverse(mNode);
        	 mNode.next = nNode;
        	 return head;
        }
        
        // 3. Common case
        ListNode mPre = head;
        ListNode nPre = head;
        while (n > 1){
            m--;
            n--;
            if (m > 1){
                mPre = mPre.next;
            }
            nPre = nPre.next;
        }
        ListNode mNode = mPre.next;
        ListNode nNode = nPre.next;
        nPre.next = null;
        mPre.next = reverse(mNode);
        mNode.next = nNode;
        return head;
    }
    
    public ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

	public void print(ListNode head){
		ListNode cur = head;
		while (cur != null){
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
	}
}
