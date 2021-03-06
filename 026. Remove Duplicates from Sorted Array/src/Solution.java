import java.util.Arrays;

// Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution my = new Solution();
		int[] nums = new int[]{1, 1, 2, 3, 4, 4};
		System.out.println(my.removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}
	
	public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
        	return nums.length;
        }
		int slow = 1;
        for (int fast = 1; fast < nums.length; fast++){
        	if (nums[fast] != nums[slow - 1]){
        		nums[slow++] = nums[fast];
        	}
        }
        return slow;
    }
}
