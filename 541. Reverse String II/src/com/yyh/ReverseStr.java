package com.yyh;
//Given a string and an integer k, you need to reverse the first k characters 
//for every 2k characters counting from the start of the string. If there are 
//less than k characters left, reverse all of them. If there are less than 2k but 
//greater than or equal to k characters, then reverse the first k characters and left the other as original.
public class ReverseStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseStr my = new ReverseStr();
		System.out.println(my.reverseStr("abcdefg", 2));
	}

	public String reverseStr(String s, int k) {
        if (s == null){
            return null;
        }
        char[] arr = s.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < arr.length; fast++){
            if ((fast + 1) % k == 0 && (fast + 1) / k % 2 == 1){
                reverse(arr, slow, fast);
            } else if ((fast + 1) % k == 0 && (fast + 1) / k % 2 == 0){
                slow = fast + 1;
            }
        }
        if (arr.length % (2 * k) < k) {
            reverse(arr, slow, arr.length - 1);
        }
        return new String(arr, 0, arr.length);           
    }
    
    private void reverse(char[] arr, int left, int right){
        while (left < right){
            swap(arr, left++, right--);
        }
    }
    
    private void swap(char[] arr, int a, int b){
        char tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
