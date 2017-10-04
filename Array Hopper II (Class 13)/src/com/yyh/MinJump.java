package com.yyh;

public class MinJump {

	public static void main(String[] args) {
		MinJump my = new MinJump();
		System.out.println(my.minJump(new int[]{3, 3, 1, 0, 4}));
		System.out.println(my.minJump(new int[]{2, 1, 1, 0, 2}));
	}
	
	public int minJump(int[] array) {
	    int[] result = new int[array.length];
	    result[result.length - 1] = 0;
	    for (int i = result.length - 2; i >= 0; i--){
	      int min = Integer.MAX_VALUE;
	      for (int j = 1; j <= array[i]; j++){
	        if (i + j >= array.length){
	          break;
	        } else if (result[i + j]  == -1){
	          continue;
	        } else {
	          min = Math.min(min, result[i + j]);
	        }
	      }
	      result[i] = (min == Integer.MAX_VALUE ? -1 : min + 1); 
	    }
	    return result[0];
	  }

}
