package com.yyh;
/*
 * At a lemonade stand, each lemonade costs $5. 

Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).

Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.  You must provide the correct change to each customer, so that the net transaction is that the customer pays $5.

Note that you don't have any change in hand at first.

Return true if and only if you can provide every customer with correct change.
 */
public class Solution {
	public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i: bills){
            if (i == 5) five++;
            else if (i == 10) {
                if (five < 1) return false;
                else {
                    five--;
                    ten++;
                }
            } else {
                if (five >= 1 && ten >= 1){
                    five--;
                    ten--;
                } else if (five >= 3){
                    five -= 3;
                } else return false;
            }
        }
        return true;
    }
}
