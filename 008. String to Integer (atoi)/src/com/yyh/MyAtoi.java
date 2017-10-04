package com.yyh;

//Implement atoi to convert a string to an integer.

public class MyAtoi {

	public static void main(String[] args) {
		MyAtoi my = new MyAtoi();
		System.out.println(my.myAtoi("250"));
	}

	public int myAtoi(String str) {
        if (str == null || str.length() == 0){
        	return 0;
        }
        char[] arr = str.toCharArray();
        int result = 0;
        int sign = 1;
        int idx = 0;
        while (arr[idx] == ' '){
        	idx++;
        }
        if (arr[idx] == '-'){
        	sign = -1;
        	idx++;
        } else if (arr[idx] == '+'){
        	idx++;
        }
        for (; idx < arr.length; idx++){
        	if (arr[idx] >= '0' && arr[idx] <='9'){
        		if (result > Integer.MAX_VALUE / 10 || 
        				(result == Integer.MAX_VALUE / 10 && arr[idx] - '0' > 7)){
        			if (sign > 0) {
        				return Integer.MAX_VALUE;
        			} else {
        				return Integer.MIN_VALUE;
        			}
        		}
        		result = result * 10 + arr[idx] - '0';
        	} else {
        		break;
        	}
        }
        return result * sign;
	}
}
