
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(removeDuplicates(new int[] {1,1,2,2,3}));
	}
	public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
		int l = 1;
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++){
        	if (nums[i] > temp) {
        		temp = nums[i];
        		l += 1;
        	}
        }
        return l;
    }
}
