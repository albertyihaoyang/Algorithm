package com.yyh;

public class Solution {
	class Trie {
        Trie[] children;
        public Trie(){
            children = new Trie[2];
        }
    }
    
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Trie root = new Trie();
        for (int num: nums){
            Trie curNode = root;
            for (int i = 31; i >= 0; i--){
                int dig = (num >>> i) & 1;
                if (curNode.children[dig] == null){
                    curNode.children[dig] = new Trie();
                }
                curNode = curNode.children[dig];
            }
        }
        
        int res = 0;
        for (int num: nums){
            Trie curNode = root;
            int curSum = 0;
            for (int i = 31; i >= 0; i--){
                int dig = (num >> i) & 1;
                if (curNode.children[1 - dig] == null){
                    curNode = curNode.children[dig];
                } else {
                    curNode = curNode.children[1 - dig];
                    curSum += 1 << i;
                }
            }
            res = Math.max(res, curSum);
        }
        return res;
    }
}
