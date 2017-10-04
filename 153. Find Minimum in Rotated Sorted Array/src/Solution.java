/*
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
 */
public class Solution {
	public static void main(String[] args){
		int[] n = {4,5,6,7,0,1,2};
		System.out.print(findMin(n));
	}
	
	
	public static int findMin(int[] nums) {
		for (int i = 0; i < nums.length-1; i++){
			if (nums[i] > nums[i+1]){
				return nums[i+1];
			}
		}
		return nums[0];
        
    }
}
