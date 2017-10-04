package com.yyh;
// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. 
// Add the two numbers and return it as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { 
		val = x; 
	}
}
public class AddTwoNumbers {
	
	public static void main(String[] args){
		AddTwoNumbers my = new AddTwoNumbers();
		ListNode L1 = new ListNode(2);
		ListNode L2 = new ListNode(4);
		ListNode L3 = new ListNode(3);
		ListNode L4 = new ListNode(5);
		ListNode L5 = new ListNode(6);
		ListNode L6 = new ListNode(4);
		L1.next = L2;
		L2.next = L3;
		L4.next = L5;
		L5.next = L6;
		ListNode newHead = my.addTwoNumbers(L1, L4);
		while (newHead != null){
			System.out.print(newHead.val + " ");
			newHead = newHead.next;
		}
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null & l2 == null){
            return null;
        } else if (l1 == null){
            return l2;
        } else if (l2 == null){
            return l1;
        }
        int next = 0;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1.next != null && cur2.next != null){
        	cur1.val = cur1.val + cur2.val + next;
        	next = 0;
        	if (cur1.val > 9){
        		cur1.val -= 10;
        		next = 1;
        	}
        	cur1 = cur1.next;
        	cur2 = cur2.next;
        }
        if (cur1.next == null){
        	cur1.next = cur2.next;
        }
        cur1.val = cur1.val + cur2.val + next;
    	next = 0;
    	if (cur1.val > 9){
    		cur1.val -= 10;
    		next = 1;
    	}
    	while (next == 1){
    		if (cur1.next == null){
    			cur1.next = new ListNode(1);
    			next = 0;
    		} else {
    			cur1.next.val += 1;
    			next = 0;
    			if (cur1.next.val > 9){
    				cur1.next.val -= 10;
    				next = 1;
    				cur1 = cur1.next;
    			}
    		}
    	}
    	return l1;
	}
	
}
