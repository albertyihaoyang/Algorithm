
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maximumProduct(new int[] {1,2,3,4,-1,-7}));
	}
	public static int maximumProduct(int[] nums) {
        selectionSort(nums);
        int l = nums.length;
        if (nums[l-1] <= 0) {
            return nums[l-1] * nums[l-2] * nums[l-3];
        }
        else if (nums[l-2] <= 0 || nums[l-3] <= 0 || nums[0] * nums[1] > nums[l-2] * nums[l-3]){
            return nums[l-1] * nums[0] * nums[1];
        }
        else {
        	return nums[l-1] * nums[l-2] * nums[l-3];
        }
    }
    public static int[] selectionSort(int[] array) {
    if (array == null) {
    	return array;
    }
    else if (array.length == 0) {
    	return array;
    }
    else {
    	int global = 0;
    	int temp;
    	for (int i = 0; i < array.length; i++) {
    		global = i;
    		for (int j = i+1; j < array.length; j++) {
    			if (array[j] < array[global]) {
    				global = j;
    			}	
    		}
    		temp = array[i];
    		array[i] = array[global];
    		array[global] = temp;
    	}
    }
    return array;
    } 
}
