
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
