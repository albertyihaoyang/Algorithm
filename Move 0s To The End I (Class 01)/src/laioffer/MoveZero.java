package laioffer;

import java.util.Arrays;

/*
 * Given an array of integers, move all the 0s to the right end of the array.
 * The relative order of the elements in the original array does not need to be maintained.
 */
public class MoveZero {
	public static void main(String[] args){
		int [] arr = new int[]{4, 0, 2, 1, 0, 5, 6, 3};
		System.out.println(Arrays.toString(moveZero(arr)));
		System.out.println(moveZero(null));
	}
	
	public static int[] moveZero(int[] array) {
		myMoveZero(array);
		return array;
	}
	
	public static void myMoveZero(int[] array){
		if (array == null || array.length < 2) {
	    	return;
	    } else {
	    	int i = 0, j = array.length-1;
	    	while (i<j){
	    		if (array[i] == 0){
	    			array[i] = array[j];
	    			array[j]=0;
	    			j--;	
	    		} else {
	    			i++;
	    		}

	    	}
	    }
	}
}
