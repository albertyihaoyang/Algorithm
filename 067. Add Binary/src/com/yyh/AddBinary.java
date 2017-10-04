package com.yyh;
//Given two binary strings, return their sum (also a binary string).
public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddBinary my = new AddBinary();
		System.out.println(my.addBinary("11", "0"));
	}

	public String addBinary(String a, String b) {
        if (a == null || a.length() == 0){
        	return b;
        }
        if (b == null || b.length() == 0){
        	return a;
        }
        
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        reverse(aArr, 0, aArr.length - 1);
        reverse(bArr, 0, bArr.length - 1);
        char[] result = new char[Math.max(aArr.length, bArr.length) + 1];
        int next = 0;
        int i = 0;
        for (i = 0; i < Math.min(aArr.length, bArr.length); i++){
        	int cur = aArr[i] + bArr[i] + next;
        	if (cur == 96){
        		result[i] = '0';
        		next = 0;
        	} else if (cur == 97){
        		result[i] = '1';
        		next = 0;
        	} else if (cur == 98){
        		result[i] = '0';
        		next = 1;
        	} else if (cur == 99){
        		result[i] = '1';
        		next = 1;
        	}
        }
        if (i == aArr.length && i == bArr.length){
        	if (next == 1){
        		result[i] = '1';
        	}
        } else if (i == aArr.length){
        	for (i = aArr.length; i < bArr.length; i++){
        		int cur = bArr[i] + next;
        		if (cur == 48){
            		result[i] = '0';
            		next = 0;
            	} else if (cur == 49){
            		result[i] = '1';
            		next = 0;
            	} else if (cur == 50){
            		result[i] = '0';
            		next = 1;
            	}
        	}
        	if (next == 1){
        		result[i] = '1';
        	} 
        } else if (i == bArr.length){
        	for (i = bArr.length; i < aArr.length; i++){
        		int cur = aArr[i] + next;
        		if (cur == 48){
            		result[i] = '0';
            		next = 0;
            	} else if (cur == 49){
            		result[i] = '1';
            		next = 0;
            	} else if (cur == 50){
            		result[i] = '0';
            		next = 1;
            	}
        	}
        	if (next == 1){
        		result[i] = '1';
        	} 
        }
        reverse(result, 0, result.length - 1);
        if (result[0] == '1'){
        	return new String(result, 0, result.length);
        } else {
        	return new String(result, 1, result.length - 1);
        }
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
