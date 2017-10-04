/*
 * Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Solution {
	public static void main(String[] args){
		System.out.println(singleNumber(new int[] {1,3,2,3,4,2,1}));
	}
	public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) result ^= i;
        return result;
    }
}
