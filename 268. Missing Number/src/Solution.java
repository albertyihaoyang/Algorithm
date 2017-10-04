
public class Solution {
	public static void main(String[] args){
		System.out.println(missingNumber(new int[] {0,1,3}));
	}
	
	public static int missingNumber(int[] nums) {
		int l = nums.length;
		int total = l*(l+1)/2;
		for (int i = 0; i < l; i++){
			total -= nums[i];
		}
		return total;
    }
}
