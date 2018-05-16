package com.yyh;

public class FindDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findDuplicate(int[] nums) {
		if (nums.length > 1){
			int slow = nums[0];
			int fast = nums[slow];
			while (slow != fast) {
				slow = nums[slow];
				fast = nums[nums[fast]];
			}
			fast = 0;
			while (fast != slow) {
				fast = nums[fast];
				slow = nums[slow];
			}
			return slow;
		}
		return -1;
	}
}
