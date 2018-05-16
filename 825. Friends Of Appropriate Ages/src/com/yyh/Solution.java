package com.yyh;
/*
 * Some people will make friend requests. The list of their ages is given and ages[i] is the age of the ith person. 

Person A will NOT friend request person B (B != A) if any of the following conditions are true:

age[B] <= 0.5 * age[A] + 7
age[B] > age[A]
age[B] > 100 && age[A] < 100
Otherwise, A will friend request B.

Note that if A requests B, B does not necessarily request A.  Also, people will not friend request themselves.

How many total friend requests are made?
 */
public class Solution {
	public int numFriendRequests(int[] ages) {
        int res = 0;
        int[] num = new int[121];
        int[] acc = new int[121];
        for (int i: ages) num[i]++;
        for (int i = 1; i < 121; i++){
            acc[i] = acc[i - 1] + num[i];
        }
        for (int i = 15; i < 121; i++){
            if (num[i] == 0) continue;
            int count = acc[i] - acc[(i / 2) + 7];
            res += count * num[i] - num[i];
        }
        return res;
    }
}
