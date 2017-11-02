package com.yyh;
// Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. 
// There is no limit on how many times a digit can be reused.
public class Solution {
	public static void main(String[] args){
		Solution my = new Solution();
		System.out.println(my.nextClosestTime("00:00"));
	}
	
	int dif = 24 * 60 + 1; // Total minutes of a day but avoid "11:11" "22:22" "00:00"
    String result;
    
    public String nextClosestTime(String time) {
        int[] target = new int[4];
        target[0] = time.charAt(0) - '0';
        target[1] = time.charAt(1) - '0';
        target[2] = time.charAt(3) - '0';
        target[3] = time.charAt(4) - '0';
        
        int[] cur = new int[4];
        
        helper(target, cur, 0); // Use dfs for every digit to generate possible answer
        return result;
    }

    // Time: O(4^4) = O(1);
    // Space: O(1);
    private void helper(int[] target, int[] cur, int ind) {
        // Base case:
    	if (ind == 4) {
            int d = timeDif(target, cur);
            if (d < dif) {
                dif = d;
                result = String.format("%02d", arrToTime(cur) / 60) + ":" + String.format("%02d", arrToTime(cur) % 60);
            }
        } else {
            for (int i = 0; i < 4; i++) {
                cur[ind] = target[i];
                if (ind == 1) { // 0 <= hr < 24, prune the invalid cases
                    int hour = 10 * cur[0] + cur[1];
                    if (hour >= 0 && hour <= 23){
                    	helper(target, cur, ind + 1);
                    }
                } else if (ind == 3) {// 0 <= min < 60
                    int minu = 10 * cur[2] + cur[3];
                    if (minu >= 0 && minu <= 59){
                    	helper(target, cur, ind + 1);
                    }
                } else {
                    helper(target, cur, ind + 1);
                }
            }
        }
    }

    private int timeDif(int[] tar, int[] cur) {
        int target = arrToTime(tar);
        int current = arrToTime(cur);
        return current > target ? current - target : current + 24 * 60 - target;
    }
    
    private int arrToTime(int[] arr){
    	 return (arr[0] * 10 + arr[1]) * 60 + arr[2] * 10 + arr[3];
    }
}
